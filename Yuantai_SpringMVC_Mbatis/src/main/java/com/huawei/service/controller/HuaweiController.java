package com.huawei.service.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.huawei.common.model.MAuthentication;
import com.huawei.common.model.MDevice;
import com.huawei.common.model.MDeviceDataHistoryDTOs;
import com.huawei.common.model.MDeviceInfo;
import com.huawei.common.model.MQueryDeviceHistoryData;
import com.huawei.common.model.MQueryDevices;
import com.huawei.common.model.MRegisterDirectlyConnectedDevice;
import com.huawei.common.model.queryasyncommandsV4.MData;
import com.huawei.common.model.queryasyncommandsV4.MQueryAsynCommandsV4;
import com.huawei.common.model.querydevicecapabilities.MQueryDeviceCapabilities;
import com.huawei.iot.service.ModifyDeviceInfoService;
import com.huawei.iot.service.RegisterDirectlyConnectedDeviceService;
import com.huawei.service.appAccessSecurity.*;
import com.huawei.service.dataCollection.*;
import com.huawei.service.deviceManagement.*;
import com.huawei.service.signalingDelivery.*;

import com.sojson.common.controller.BaseController;
import com.sojson.common.model.UPermission;
import com.sojson.common.model.URolePermission;
import com.sojson.common.model.UUser;
import com.sojson.common.utils.LoggerUtils;
import com.sojson.common.utils.StringUtils;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.core.shiro.token.manager.TokenManager;

import net.sf.json.JSONObject;

import com.alibaba.fastjson.*;//要导入的fastjson包

/**
 * 
 * 开发公司：itboy.net<br/>
 * 版权：itboy.net<br/>
 * <p>
 * 
 * 用户登录相关，不需要做登录限制
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2016年5月3日 　<br/>
 * <p>
 * *******
 * <p>
 * @author zhou-baicheng
 * @email  i@itboy.net
 * @version 1.0,2016年5月3日 <br/>
 * 
 */
@Controller
@Scope(value="prototype")
@RequestMapping("huawei")
public class HuaweiController extends BaseController {


	@Autowired
	RegisterDirectlyConnectedDeviceService registerDirectlyConnectedDeviceService;
	
	@Autowired
	ModifyDeviceInfoService modifyDeviceInfoService;
	

	@RequestMapping(value="Authentication",method=RequestMethod.GET)
	@ResponseBody
	public String Authentication() {
		try {
			String temp = Authentication.Authentication();
			
			MAuthentication mMAuthentication=JSON.parseObject(temp,MAuthentication.class);  

	
			System.out.print("vvvvvvvvvvvvvv:" + mMAuthentication.getAccessToken());
			return mMAuthentication.getAccessToken();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}
	
	
	@RequestMapping(value="RefreshToken",method=RequestMethod.GET)
	@ResponseBody
	public String RefreshToken(){
		try {
			return RefreshToken.RefreshToken();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
	}
	
	
	
	@RequestMapping(value="QueryDeviceCapabilities",method=RequestMethod.GET)
	@ResponseBody
	public String QueryDeviceCapabilities(String deviceId) {
		try {

			String temp = QueryDeviceCapabilities.QueryDeviceCapabilities(deviceId);
			// MQueryDeviceCapabilities mMQueryDeviceCapabilities =
			// (MQueryDeviceCapabilities) JsonUtil.convertJsonStringToObject(temp,
			// MQueryDeviceCapabilities.class);
			// return mMQueryDeviceCapabilities.getAccessToken();

			MQueryDeviceCapabilities mMQueryDeviceCapabilities = JSON.parseObject(temp, MQueryDeviceCapabilities.class);

			System.out.print("vvvvvvvvvvvvvv:" + mMQueryDeviceCapabilities.getDeviceCapabilities().get(0));

			return temp;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}
	
	
	@RequestMapping(value="QueryDeviceData",method=RequestMethod.GET)
	@ResponseBody
	public String QueryDeviceData(){
		try {
			return QueryDeviceData.QueryDeviceData();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
	}
	
	
	@RequestMapping(value="QueryDeviceHistoryData")
	public ModelAndView QueryDeviceHistoryData(String deviceIds,Integer pageNo){
		
		String temp = null;
		try {
			
			int successCount=0,errorCount=0;
			String resultMsg ="删除%s条，失败%s条";
			String[] idArray = new String[]{};
			if(StringUtils.contains(deviceIds, ",")){
				idArray = deviceIds.split(",");
			}else{
				idArray = new String[]{deviceIds};
			}
			for (String idx : idArray) {
				System.out.print("vvvvvvvvvvvvvv: idx==="+idx);
				temp = QueryDeviceHistoryData.QueryDeviceHistoryData(idx,pageNo!=null&&pageNo>=1? pageNo:0);
			}
			
			System.out.print("vvvvvvvvvvvvvv: name==="+deviceIds);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(temp!=null) {
			System.out.print("vvvvvvvvvvvvvv: QueryDeviceHistoryData temp="+temp);

			MQueryDeviceHistoryData mMQueryDeviceHistoryData = JSON.parseObject(temp, MQueryDeviceHistoryData.class);
			if(pageNo!=null&&pageNo>=1) {
				Pagination<MDeviceDataHistoryDTOs> devices = new Pagination<MDeviceDataHistoryDTOs>(pageNo, 10, mMQueryDeviceHistoryData.getTotalCount(),
						mMQueryDeviceHistoryData.getDeviceDataHistoryDTOs());// permissionService.findPage(modelMap,pageNo,pageSize);
				System.out.print("vvvvvvvvvvvvvv: QueryDeviceHistoryData");

				return new ModelAndView("huawei/QueryDeviceHistoryData", "page", devices);					
			}else {
				Pagination<MDeviceDataHistoryDTOs> devices = new Pagination<MDeviceDataHistoryDTOs>(0, 10, mMQueryDeviceHistoryData.getTotalCount(),
						mMQueryDeviceHistoryData.getDeviceDataHistoryDTOs());// permissionService.findPage(modelMap,pageNo,pageSize);
				System.out.print("vvvvvvvvvvvvvv: QueryDeviceHistoryData");

				return new ModelAndView("huawei/QueryDeviceHistoryData", "page", devices);					
			}
	
		}else {
			return new ModelAndView("huawei/QueryDeviceHistoryData", "page", null);		

		}

//		return new ModelAndView("huawei/QueryDevices");				

	}
	

	
	@RequestMapping(value="QueryAsynCommandsV4")
	public ModelAndView QueryAsynCommandsV4(String deviceIds,Integer pageNo){
		System.out.print("vvvvvvvvvvvvvv: QueryAsynCommandsV4== pageNo="+pageNo);

		String temp = null;
		try {
			
			int successCount=0,errorCount=0;
			String resultMsg ="删除%s条，失败%s条";
			String[] idArray = new String[]{};
			if(StringUtils.contains(deviceIds, ",")){
				idArray = deviceIds.split(",");
			}else{
				idArray = new String[]{deviceIds};
			}
			for (String idx : idArray) {
				System.out.print("vvvvvvvvvvvvvv: idx==="+idx);
				temp = QueryAsynCommandsV4.QueryAsynCommandsV4(idx,pageNo!=null&&pageNo>=1? pageNo:0);
			}
			
			System.out.print("vvvvvvvvvvvvvv: name==="+deviceIds);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(temp!=null) {
			System.out.print("vvvvvvvvvvvvvv: QueryAsynCommandsV4 temp="+temp);

			MQueryAsynCommandsV4 mMQueryAsynCommandsV4 = JSON.parseObject(temp, MQueryAsynCommandsV4.class);
			if(pageNo!=null&&pageNo>=1) {
				Pagination<MData> devices = new Pagination<MData>(pageNo, 10, mMQueryAsynCommandsV4.getPagination().getTotalSize(),
						mMQueryAsynCommandsV4.getData());// permissionService.findPage(modelMap,pageNo,pageSize);
				System.out.print("vvvvvvvvvvvvvv: QueryAsynCommandsV4 aaaaaaa");

				return new ModelAndView("huawei/QueryAsynCommandsV4", "page", devices);						
			}else {
				Pagination<MData> devices = new Pagination<MData>(0, 10, mMQueryAsynCommandsV4.getPagination().getTotalSize(),
						mMQueryAsynCommandsV4.getData());// permissionService.findPage(modelMap,pageNo,pageSize);
				System.out.print("vvvvvvvvvvvvvv: QueryAsynCommandsV4");

				return new ModelAndView("huawei/QueryAsynCommandsV4", "page", devices);						
			}

		}else {
			return new ModelAndView("huawei/QueryAsynCommandsV4", "page", null);		

		}
	}
	
	
	@RequestMapping(value="RegisterDirectlyConnectedDevice",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> RegisterDirectlyConnectedDevice(MRegisterDirectlyConnectedDevice mRegisterDirectlyConnectedDevice){
		
		String temp = null;
		try {
			temp = RegisterDirectlyConnectedDevice.RegisterDirectlyConnectedDevice(mRegisterDirectlyConnectedDevice);
			resultMap.put("status", 200);
			resultMap.put("entity", JSON.parseObject(temp, MRegisterDirectlyConnectedDevice.class));			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMap.put("status", 500);
			resultMap.put("message", "添加失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "添加权限报错。source[%s]", mRegisterDirectlyConnectedDevice.toString());			
		}
		
//		写入数据库
//		MRegisterDirectlyConnectedDevice mMRegisterDirectlyConnectedDevice = JSON.parseObject(temp, MRegisterDirectlyConnectedDevice.class);
//		System.out.print("vvvvvvvvvvvvvv: mMRegisterDirectlyConnectedDevice.="+mMRegisterDirectlyConnectedDevice.toString());
//		registerDirectlyConnectedDeviceService.insertSelective(mMRegisterDirectlyConnectedDevice);				
		return resultMap;
	}
	
	
	
//	@RequestMapping(value="QueryDevicesAA",method=RequestMethod.GET)
//	@ResponseBody
//	public String QueryDevicesAA(){
//		try {
//			return QueryDevices.QueryDevices();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		return null;
//	}
	
	
	@RequestMapping(value="QueryDevices")
	public ModelAndView QueryDevices(String findContent, ModelMap modelMap, Integer pageNo) {
		System.out.print("vvvvvvvvvvvvvv:QueryDevices  pageNo="+pageNo);

		String temp = null;
		try {
			temp = QueryDevices.QueryDevices(pageNo!=null&&pageNo>=1? pageNo-1:0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MQueryDevices mMQueryDevices = JSON.parseObject(temp, MQueryDevices.class);
		System.out.print("vvvvvvvvvvvvvv: mMQueryDevices.="+mMQueryDevices);
		if(mMQueryDevices==null) {
			return new ModelAndView("huawei/QueryDevices", "page", null);						
			
		}
		System.out.print("vvvvvvvvvvvvvv:QueryDevices  findContent="+findContent);
		
		if(findContent!=null && !findContent.trim().isEmpty()) {
			List<MDevice> MDevices = new ArrayList<MDevice>();
			int count = 0;
			MQueryDevices mMQueryDevice = new MQueryDevices();
			for(int i=0;i<mMQueryDevices.getDevices().size();i++) {
				if(mMQueryDevices.getDevices().get(i).getDeviceId().equals(findContent)) {
					count++;
					MDevices.add(mMQueryDevices.getDevices().get(i));					
				}
			}
			
			if(count==0) {
				modelMap.put("findContent", findContent);
				if(pageNo!=null&&pageNo>=1) {
					Pagination<MDevice> devices = new Pagination<MDevice>(pageNo, 10, mMQueryDevices.getTotalCount(),
							mMQueryDevices.getDevices());// permissionService.findPage(modelMap,pageNo,pageSize);
					System.out.print("vvvvvvvvvvvvvv: 111");

					return new ModelAndView("huawei/QueryDevices", "page", devices);					
				}else {
					Pagination<MDevice> devices = new Pagination<MDevice>(0, 10, mMQueryDevices.getTotalCount(),
							mMQueryDevices.getDevices());// permissionService.findPage(modelMap,pageNo,pageSize);
					System.out.print("vvvvvvvvvvvvvv: 111");

					return new ModelAndView("huawei/QueryDevices", "page", devices);					
				}
					
			}else {
				mMQueryDevice.setTotalCount(count);
				mMQueryDevice.setDevices(MDevices);
				if(pageNo!=null&&pageNo>=1) {
					Pagination<MDevice> devices = new Pagination<MDevice>(pageNo, 10, mMQueryDevice.getTotalCount(),
							mMQueryDevice.getDevices());// permissionService.findPage(modelMap,pageNo,pageSize);
					System.out.print("vvvvvvvvvvvvvv: findContent");

					return new ModelAndView("huawei/QueryDevices", "page", devices);						
				}else {
					Pagination<MDevice> devices = new Pagination<MDevice>(0, 10, mMQueryDevice.getTotalCount(),
							mMQueryDevice.getDevices());// permissionService.findPage(modelMap,pageNo,pageSize);
					System.out.print("vvvvvvvvvvvvvv: findContent");

					return new ModelAndView("huawei/QueryDevices", "page", devices);						
				}				
			
			}

		}else {
			modelMap.put("findContent", findContent);
			if(pageNo!=null&&pageNo>=1) {
				Pagination<MDevice> devices = new Pagination<MDevice>(pageNo, 10, mMQueryDevices.getTotalCount(),
						mMQueryDevices.getDevices());// permissionService.findPage(modelMap,pageNo,pageSize);
				System.out.print("vvvvvvvvvvvvvv: 111");

				return new ModelAndView("huawei/QueryDevices", "page", devices);					
			}else {
				Pagination<MDevice> devices = new Pagination<MDevice>(0, 10, mMQueryDevices.getTotalCount(),
						mMQueryDevices.getDevices());// permissionService.findPage(modelMap,pageNo,pageSize);
				System.out.print("vvvvvvvvvvvvvv: 111");

				return new ModelAndView("huawei/QueryDevices", "page", devices);	
			}			
		
		}

	}			
	/**
	 * 设备信息编辑修改
	 * @return
	 */
	@RequestMapping(value="modifyDeviceInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modifyDeviceInfo(String deviceIds,MDeviceInfo entity){
	
		try {
			int successCount=0,errorCount=0;
			String resultMsg ="删除%s条，失败%s条";
			String[] idArray = new String[]{};
			if(StringUtils.contains(deviceIds, ",")){
				idArray = deviceIds.split(",");
			}else{
				idArray = new String[]{deviceIds};
			}

			System.out.print("vvvvvvvvvvvvvv: modifyDeviceInfo==="+entity.getName());

			
			for (String idx : idArray) {
				System.out.print("vvvvvvvvvvvvvv: idx==="+idx);
				entity.setDeviceId(idx);
				ModifyDeviceInfo.ModifyDeviceInfo(entity);				
			}
			resultMap.put("status", 200);
			resultMsg = "操作成功";

			resultMap.put("resultMsg", resultMsg);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除用户出现错误，ids[%s]", deviceIds);
			resultMap.put("status", 500);
			resultMap.put("message", "删除出现错误，请刷新后再试！");
		}
		return resultMap;	
		
	}
	
	/**
	 * 删除设备
	 * @return
	 */
	@RequestMapping(value="DeleteDirectlyConnectedDevice",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> DeleteDirectlyConnectedDevice(String deviceIds){

		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			int successCount=0,errorCount=0;
			String resultMsg ="删除%s条，失败%s条";
			String[] idArray = new String[]{};
			if(StringUtils.contains(deviceIds, ",")){
				idArray = deviceIds.split(",");
			}else{
				idArray = new String[]{deviceIds};
			}
			
			for (String idx : idArray) {
				System.out.print("vvvvvvvvvvvvvv: idx==="+idx);
				
				DeleteDirectlyConnectedDevice.DeleteDirectlyConnectedDevice(idx);
			}
			resultMap.put("status", 200);
			resultMsg = "操作成功";

			resultMap.put("resultMsg", resultMsg);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除用户出现错误，ids[%s]", deviceIds);
			resultMap.put("status", 500);
			resultMap.put("message", "删除出现错误，请刷新后再试！");
		}
		return resultMap;	
	}	
	
//	@RequestMapping(value="modifyDeviceInfo",method=RequestMethod.POST)
//	@ResponseBody
//	public Map<String,Object> modifyDeviceInfo(MDeviceInfo deviceinfo){
//		try {
//			MDeviceInfo entity = modifyDeviceInfoService.insertSelective(deviceinfo);
//			resultMap.put("status", 200);
//			resultMap.put("entity", entity);
//		} catch (Exception e) {
//			resultMap.put("status", 500);
//			resultMap.put("message", "添加失败，请刷新后再试！");
//			LoggerUtils.fmtError(getClass(), e, "添加权限报错。source[%s]", deviceinfo.toString());
//		}
//		return resultMap;
//	}
	
	/**
	 * 登录提交
	 * @param entity		登录的UUser
	 * @param rememberMe	是否记住
	 * @param request		request，用来取登录之前Url地址，用来登录后跳转到没有登录之前的页面。
	 * @return
	 */
//	@RequestMapping(value="submitLogin",method=RequestMethod.POST)
//	@ResponseBody
//	public Map<String,Object> submitLogin(UUser entity,Boolean rememberMe,HttpServletRequest request){
//		try {
//			Authentication.Authentication();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			entity = TokenManager.login(entity,rememberMe);
//			resultMap.put("status", 200);
//			resultMap.put("message", "登录成功");
//			
//			
//			/**
//			 * shiro 获取登录之前的地址
//			 * 之前0.1版本这个没判断空。
//			 */
//			SavedRequest savedRequest = WebUtils.getSavedRequest(request);
//			String url = null ;
//			if(null != savedRequest){
//				url = savedRequest.getRequestUrl();
//			}
//			/**
//			 * 我们平常用的获取上一个请求的方式，在Session不一致的情况下是获取不到的
//			 * String url = (String) request.getAttribute(WebUtils.FORWARD_REQUEST_URI_ATTRIBUTE);
//			 */
//			LoggerUtils.fmtDebug(getClass(), "获取登录之前的URL:[%s]",url);
//			//如果登录之前没有地址，那么就跳转到首页。
//			if(StringUtils.isBlank(url)){
//				url = request.getContextPath() + "/user/index.shtml";
//			}
//			//跳转地址
//			resultMap.put("back_url", url);
//		/**
//		 * 这里其实可以直接catch Exception，然后抛出 message即可，但是最好还是各种明细catch 好点。。
//		 */
//		} catch (DisabledAccountException e) {
//			resultMap.put("status", 500);
//			resultMap.put("message", "帐号已经禁用。");
//		} catch (Exception e) {
//			resultMap.put("status", 500);
//			resultMap.put("message", "帐号或密码错误");
//		}
//			
//		return resultMap;
//	}
	
	/**
	 * 退出
	 * @return
	 */
//	@RequestMapping(value="logout",method =RequestMethod.GET)
//	@ResponseBody
//	public Map<String,Object> logout(){
//		try {
//			TokenManager.logout();
//			resultMap.put("status", 200);
//		} catch (Exception e) {
//			resultMap.put("status", 500);
//			logger.error("errorMessage:" + e.getMessage());
//			LoggerUtils.fmtError(getClass(), e, "退出出现错误，%s。", e.getMessage());
//		}
//		return resultMap;
//	}
}
