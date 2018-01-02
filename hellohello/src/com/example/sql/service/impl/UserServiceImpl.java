package com.example.sql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sql.dao.UserMapper;
import com.example.sql.model.User;
import com.example.sql.model.UserExample;
import com.example.sql.model.UserExample.Criteria;
import com.example.sql.service.UserService;

@Service
public class UserServiceImpl implements UserService {


	// 注入Service依赖
	@Autowired
	private UserMapper userDao;



	@Override
	public List<User> login(User user) {
		
		UserExample teammemberExample = new UserExample();  
        Criteria criteria = teammemberExample.createCriteria();  
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
      
        List<User> listTeammembers = userDao.selectByExample(teammemberExample);  


		// TODO Auto-generated method stub
		return listTeammembers;
	}


	@Override
	public int register(User user) {
		
		return userDao.insertSelective(user);
		// TODO Auto-generated method stub
//		return 0;
	}


}
