package com.sojson.user.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.sojson.common.dao.CountrtyCodeMapper;
import com.sojson.common.dao.PostageCalcModeMapper;
import com.sojson.common.dao.PostageValueMapper;
import com.sojson.common.dao.ServiceModeMapper;
import com.sojson.common.dao.UUserMapper;
import com.sojson.common.dao.UUserRoleMapper;
import com.sojson.common.model.CountrtyCode;
import com.sojson.common.model.PostageCalcMode;
import com.sojson.common.model.PostageValue;
import com.sojson.common.model.ServiceMode;
import com.sojson.common.model.UUser;
import com.sojson.common.model.UUserRole;
import com.sojson.common.utils.LoggerUtils;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.core.shiro.session.CustomSessionManager;
import com.sojson.core.shiro.token.manager.TokenManager;
import com.sojson.permission.bo.URoleBo;
import com.sojson.permission.bo.UserRoleAllocationBo;
import com.sojson.user.controller.MemberController;
import com.sojson.user.service.PostageService;
import com.sojson.user.service.UUserService;

@Service
public class PostageServiceImpl extends BaseMybatisDao<PostageValueMapper> implements PostageService {
	/***
	 * 用户手动操作Session
	 * */
	@Autowired
	CustomSessionManager customSessionManager;
	@Autowired
	UUserRoleMapper userRoleMapper;
	@Autowired
	PostageCalcModeMapper postageCalcModeMapper;
	@Autowired
	PostageValueMapper postageValueMapper;
	@Autowired
	CountrtyCodeMapper countrtyCodeMapper;
	@Autowired
	ServiceModeMapper serviceModeMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return postageValueMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PostageValue insert(PostageValue entity) {
		postageValueMapper.insert(entity);
		return entity;
	}

	@Override
	public PostageValue insertSelective(PostageValue entity) {
		postageValueMapper.insertSelective(entity);
		return entity;
	}

	@Override
	public PostageValue selectByPrimaryKey(Long id) {
		return postageValueMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(PostageValue entity) {
		return postageValueMapper.updateByPrimaryKey(entity);
	}

	@Override
	public int updateByPrimaryKeySelective(PostageValue entity) {
		return postageValueMapper.updateByPrimaryKeySelective(entity);
	}


	@SuppressWarnings("unchecked")
	@Override
	public Pagination<PostageValue> findByPage(Map<String, Object> resultMap,
			Integer pageNo, Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}

	@Override
	public Map<String, Object> deleteUserById(String ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			int count=0;
			String[] idArray = new String[]{};
			if(StringUtils.contains(ids, ",")){
				idArray = ids.split(",");
			}else{
				idArray = new String[]{ids};
			}
			
			for (String id : idArray) {
				count+=this.deleteByPrimaryKey(new Long(id));
			}
			resultMap.put("status", 200);
			resultMap.put("count", count);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除用户出现错误，ids[%s]", ids);
			resultMap.put("status", 500);
			resultMap.put("message", "删除出现错误，请刷新后再试！");
		}
		return resultMap;
	}



	@SuppressWarnings("unchecked")
	@Override
	public Pagination<UserRoleAllocationBo> findUserAndRole(ModelMap modelMap,
			Integer pageNo, Integer pageSize) {
		return super.findPage("findUserAndRole", "findCount", modelMap, pageNo, pageSize);
	}

	@Override
	public Map<String, Object> insertPostageValueTable() {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		int weightAll = 3;
	
		List<ServiceMode> serviceModes = serviceModeMapper.selectAllServiceMode();
		int serviceModeNUM = serviceModes.size();
		List<CountrtyCode> countryCodes = countrtyCodeMapper.selectAllCountry();
		int countryNUM = countryCodes.size();
		try {
		
		for (Long i = (long) 1; i < weightAll; i++) {
			LoggerUtils.fmtDebug(getClass(), "bbbbb   : %d",i);

			for (int j = 0; j < countryNUM; j++) {
				LoggerUtils.fmtDebug(getClass(), "bbbbb   : %d",j);

				for (int k = 0; k < serviceModeNUM; k++) {
					LoggerUtils.fmtDebug(getClass(), "bbbbbbbbbbbb   : %s",countryCodes.get(j).getCode());
					LoggerUtils.fmtDebug(getClass(), "bbbbbbbbbbbb   serviceModes: %s",serviceModes.get(k).getServicemode());

					List<PostageCalcMode> postageCalcModes = postageCalcModeMapper.selectByCountryCodeAndServiceMode(
							countryCodes.get(j).getCode(), serviceModes.get(k).getServicemode());
					
					List<PostageValue> postageValues=new ArrayList<PostageValue>();
					for(int l=0;l<postageCalcModes.size();l++) {
						LoggerUtils.fmtDebug(getClass(), "bbbbbbbbbbbbfasd   : %d",l);

						PostageValue postageValue=new PostageValue();
						postageValue.setCountrycode(countryCodes.get(j).getCode());
						postageValue.setWeight(i);
						postageValue.setServicemode(serviceModes.get(k).getServicemode());
						postageValue.setLogistics(postageCalcModes.get(l).getLogistics());
						postageValue.setCalculation(Double.toString(calc(postageCalcModes.get(l).getCalculation(),i)));
			
						postageValues.add(postageValue);
						
					}
					if(postageValues.size()>0) {
						LoggerUtils.fmtDebug(getClass(), "bbbbb sdfafd");

						Collections.sort(postageValues);
						postageValueMapper.insertSelective(postageValues.get(0));
						if(postageValues.size()>=2) {
							postageValueMapper.insertSelective(postageValues.get(1));
						}
					}

				}
			}
		}
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMap.put("status", 500);
			resultMap.put("message", "删除出现错误，请刷新后再试！");
		}			
		// TODO Auto-generated method stub
		return resultMap;
	}
	
	//计算邮费
	public double calc(String calcmode, double weight) throws ScriptException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		engine.put("x", weight);
		// 新方法，如果不需要四舍五入，可以使用RoundingMode.DOWN
		BigDecimal bg = new BigDecimal(((double) (engine.eval(calcmode)))).setScale(3, RoundingMode.DOWN);
		double result = bg.doubleValue();
		return result;
	}

}
