package com.example.sql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sql.dao.RunoobTblMapper;
import com.example.sql.model.RunoobTbl;
import com.example.sql.service.BookService;

@Service
public class BookServiceImpl implements BookService {


	// 注入Service依赖
	@Autowired
	private RunoobTblMapper bookDao;


	@Override
	public RunoobTbl getById(long bookId) {
		return bookDao.selectByPrimaryKey((int) bookId);
	}


}
