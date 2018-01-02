package com.example.sql.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sql.model.User;
import com.example.sql.service.UserService;

@Controller
public class LoginAction {

	@Autowired
	private UserService userService;


	
	
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/login.action") // 只接收POST方法的提交方式
	// http://localhost:8080/hellohello/login.action?username=lixiaoxi&password=111111
	public User Login(String username, String password) {
		User user = new User();
		System.out.println("username==" + username);
		System.out.println("password==" + password);

		user.setUsername("吴银生");
		user.setPassword(password);

		if(username.isEmpty()){
			return user;
		}else if(password.isEmpty()){
			return user;
		}
		
		
		  JSONObject object = (JSONObject) JSONObject.wrap(user);

		  
		List<User> users = userService.login(user);
		if (users == null && users.isEmpty()) {
			return user;
		}
		System.out.println("users==" + users.size());
		if (users.size() <= 0) {
			return user;

		} else {
			return user;

		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/Register.action") // 只接收POST方法的提交方式
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
		int id=userService.register(user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", id);

		JSONObject jsonObject = (JSONObject) JSONObject.wrap(map);
		System.out.println(jsonObject);
		

		return  jsonObject.toString();


	}
	
	
	
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/testjson.action") // 只接收POST方法的提交方式
	// http://localhost:8080/hellohello/login.action?username=lixiaoxi&password=111111
	public String test(String username, String password) {
		User user = new User();
		System.out.println("username==" + username);
		System.out.println("password==" + password);

		user.setUsername(username);
		user.setPassword(password);

		List<User> users = userService.login(user);
		if (users == null && users.isEmpty()) {
			return "login error";
		}
		System.out.println("users==" + users.size());
		if (users.size() <= 0) {
			return "login error";

		} else {
			return "login_success";

		}
	}
	
	
}
