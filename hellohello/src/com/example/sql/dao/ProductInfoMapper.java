package com.example.sql.dao;

import com.example.sql.model.ProductInfo;
import com.example.sql.model.ProductInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	int countByExample(ProductInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	int deleteByExample(ProductInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	int insert(ProductInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	int insertSelective(ProductInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */List<ProductInfo> selectByExample(ProductInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */int updateByExampleSelective(@Param("record") ProductInfo record,@Param("example") ProductInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */int updateByExample(@Param("record") ProductInfo record,@Param("example") ProductInfoExample example);
}