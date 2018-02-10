package com.huawei.service.controller;

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
import com.huawei.common.model.MQueryDeviceCapabilities;
import com.huawei.common.model.MQueryDevices;
import com.huawei.common.model.MRegisterDirectlyConnectedDevice;
import com.huawei.iot.service.RegisterDirectlyConnectedDeviceService;
import com.huawei.service.appAccessSecurity.*;
import com.huawei.service.dataCollection.*;
import com.huawei.service.deviceManagement.*;
import com.sojson.common.controller.BaseController;
import com.sojson.common.model.UUser;
import com.sojson.common.utils.LoggerUtils;
import com.sojson.common.utils.StringUtils;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.core.shiro.token.manager.TokenManager;
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
	public String QueryDeviceCapabilities() {
		try {

			String temp = QueryDeviceCapabilities.QueryDeviceCapabilities();
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
	
	
	@RequestMapping(value="QueryDeviceHistoryData",method=RequestMethod.GET)
	@ResponseBody
	public String QueryDeviceHistoryData(){
		try {
			return QueryDeviceHistoryData.QueryDeviceHistoryData();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
	}
	
	@Autowired
	RegisterDirectlyConnectedDeviceService registerDirectlyConnectedDeviceService;
	
	@RequestMapping(value="RegisterDirectlyConnectedDevice",method=RequestMethod.GET)
	@ResponseBody
	public String RegisterDirectlyConnectedDevice(){
		
		String temp = null;
		try {
			temp = RegisterDirectlyConnectedDevice.RegisterDirectlyConnectedDevice();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MRegisterDirectlyConnectedDevice mMRegisterDirectlyConnectedDevice = JSON.parseObject(temp, MRegisterDirectlyConnectedDevice.class);
		System.out.print("vvvvvvvvvvvvvv: mMRegisterDirectlyConnectedDevice.="+mMRegisterDirectlyConnectedDevice.toString());
		registerDirectlyConnectedDeviceService.insertSelective(mMRegisterDirectlyConnectedDevice);
		
		try {
			return RegisterDirectlyConnectedDevice.RegisterDirectlyConnectedDevice();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
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
	
	
	@RequestMapping(value="QueryDevices",method=RequestMethod.GET)
	public ModelAndView QueryDevices(String findContent, ModelMap modelMap, Integer pageNo) {
		System.out.print("vvvvvvvvvvvvvv:");

		String temp = null;
		try {
			temp = QueryDevices.QueryDevices();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MQueryDevices mMQueryDevices = JSON.parseObject(temp, MQueryDevices.class);
		System.out.print("vvvvvvvvvvvvvv: mMQueryDevices.="+mMQueryDevices);

		modelMap.put("findContent", findContent);
		Pagination<MDevice> devices = new Pagination<MDevice>(0, 10, mMQueryDevices.getTotalCount(),
				mMQueryDevices.getDevices());// permissionService.findPage(modelMap,pageNo,pageSize);
		System.out.print("vvvvvvvvvvvvvv: 111");

		return new ModelAndView("huawei/QueryDevices", "page", devices);
	}
	
	@RequestMapping(value="DeleteDirectlyConnectedDevice",method=RequestMethod.GET)
	@ResponseBody
	public String DeleteDirectlyConnectedDevice(){
		try {
			return DeleteDirectlyConnectedDevice.DeleteDirectlyConnectedDevice();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * 登录提交
	 * @param entity		登录的UUser
	 * @param rememberMe	是否记住
	 * @param request		request，用来取登录之前Url地址，用来登录后跳转到没有登录之前的页面。
	 * @return
	 */
	@RequestMapping(value="submitLogin",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> submitLogin(UUser entity,Boolean rememberMe,HttpServletRequest request){
		try {
			Authentication.Authentication();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			entity = TokenManager.login(entity,rememberMe);
			resultMap.put("status", 200);
			resultMap.put("message", "登录成功");
			
			
			/**
			 * shiro 获取登录之前的地址
			 * 之前0.1版本这个没判断空。
			 */
			SavedRequest savedRequest = WebUtils.getSavedRequest(request);
			String url = null ;
			if(null != savedRequest){
				url = savedRequest.getRequestUrl();
			}
			/**
			 * 我们平常用的获取上一个请求的方式，在Session不一致的情况下是获取不到的
			 * String url = (String) request.getAttribute(WebUtils.FORWARD_REQUEST_URI_ATTRIBUTE);
			 */
			LoggerUtils.fmtDebug(getClass(), "获取登录之前的URL:[%s]",url);
			//如果登录之前没有地址，那么就跳转到首页。
			if(StringUtils.isBlank(url)){
				url = request.getContextPath() + "/user/index.shtml";
			}
			//跳转地址
			resultMap.put("back_url", url);
		/**
		 * 这里其实可以直接catch Exception，然后抛出 message即可，但是最好还是各种明细catch 好点。。
		 */
		} catch (DisabledAccountException e) {
			resultMap.put("status", 500);
			resultMap.put("message", "帐号已经禁用。");
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "帐号或密码错误");
		}
			
		return resultMap;
	}
	
	/**
	 * 退出
	 * @return
	 */
	@RequestMapping(value="logout",method =RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> logout(){
		try {
			TokenManager.logout();
			resultMap.put("status", 200);
		} catch (Exception e) {
			resultMap.put("status", 500);
			logger.error("errorMessage:" + e.getMessage());
			LoggerUtils.fmtError(getClass(), e, "退出出现错误，%s。", e.getMessage());
		}
		return resultMap;
	}
}
