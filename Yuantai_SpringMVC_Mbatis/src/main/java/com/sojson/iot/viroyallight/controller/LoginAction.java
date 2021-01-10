package com.sojson.iot.viroyallight.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
public class LoginAction {




	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}
	
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/lightlogin") // ֻ����POST�������ύ��ʽ
	// http://localhost:8080/hellohello/lightlogin?username=lixiaoxi&password=111111
	public User Login(String username, String password) {
		User user = new User();
		System.out.println("username==" + username);
		System.out.println("password==" + password);

		user.setUsername("������");
		user.setPassword(password);

		if(username.isEmpty()){
			return user;
		}else if(password.isEmpty()){
			return user;
		}
		
		
		  String object = JSONObject.toJSONString(user);

		  
			return user;

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/Register.action") // ֻ����POST�������ύ��ʽ
	// http://localhost:8080/hellohello/login.action?username=lixiaoxi&password=111111
	public String Register(@RequestBody User user) {
		System.out.println("username==" + user.getUsername());
		System.out.println("password==" + user.getPassword());
		
		if(user.getUsername().isEmpty()){
			return "username is null";
		}else if(user.getPassword().isEmpty()){
			return "password is null";
		}
		List<String>  useridlist=new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", 11);

	
		  String object = JSONObject.toJSONString(map);
		  System.out.println(object);

		return  object;


	}
	
	
	
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/testjson.action") // ֻ����POST�������ύ��ʽ
	// http://localhost:8080/hellohello/login.action?username=lixiaoxi&password=111111
	public String test(String username, String password) {
		User user = new User();
		System.out.println("username==" + username);
		System.out.println("password==" + password);

		user.setUsername(username);
		user.setPassword(password);

		return "login_success";

	}
	
	
}
