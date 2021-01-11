package com.sojson.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.sojson.common.dao.PostageCalcModeMapper;
import com.sojson.common.dao.PostageValueMapper;
import com.sojson.common.dao.UUserMapper;
import com.sojson.common.dao.UUserRoleMapper;
import com.sojson.common.model.PostageValue;
import com.sojson.common.model.UUser;
import com.sojson.common.model.UUserRole;
import com.sojson.common.utils.LoggerUtils;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.core.shiro.session.CustomSessionManager;
import com.sojson.core.shiro.token.manager.TokenManager;
import com.sojson.permission.bo.URoleBo;
import com.sojson.permission.bo.UserRoleAllocationBo;
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
	public Map<String, Object> refreshPostageValueTable() {
		for(int i=0;i<1000*30;i++) {
			
		}
		// TODO Auto-generated method stub
		return null;
	}

}
