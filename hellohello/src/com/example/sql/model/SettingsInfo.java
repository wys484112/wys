package com.example.sql.model;

import java.util.Date;

public class SettingsInfo {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column settings_info.settingsid
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	private Integer settingsid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column settings_info.productid
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	private Integer productid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column settings_info.date
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	private Date date;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column settings_info.settingsid
	 * @return  the value of settings_info.settingsid
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	public Integer getSettingsid() {
		return settingsid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column settings_info.settingsid
	 * @param settingsid  the value for settings_info.settingsid
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	public void setSettingsid(Integer settingsid) {
		this.settingsid = settingsid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column settings_info.productid
	 * @return  the value of settings_info.productid
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	public Integer getProductid() {
		return productid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column settings_info.productid
	 * @param productid  the value for settings_info.productid
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column settings_info.date
	 * @return  the value of settings_info.date
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column settings_info.date
	 * @param date  the value for settings_info.date
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	public void setDate(Date date) {
		this.date = date;
	}
}