package com.example.sql.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepairInfoExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table repair_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table repair_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table repair_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table repair_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */public RepairInfoExample(){oredCriteria=new ArrayList<Criteria>();}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table repair_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table repair_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table repair_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table repair_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table repair_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */public List<Criteria> getOredCriteria(){return oredCriteria;}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table repair_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table repair_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table repair_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table repair_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table repair_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table repair_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */protected abstract static class GeneratedCriteria {protected List<Criterion> criteria;protected GeneratedCriteria(){super();criteria=new ArrayList<Criterion>();}public boolean isValid(){return criteria.size() > 0;}public List<Criterion> getAllCriteria(){return criteria;}public List<Criterion> getCriteria(){return criteria;}protected void addCriterion(String condition){if (condition == null){throw new RuntimeException("Value for condition cannot be null");}criteria.add(new Criterion(condition));}protected void addCriterion(String condition,Object value,String property){if (value == null){throw new RuntimeException("Value for " + property + " cannot be null");}criteria.add(new Criterion(condition,value));}protected void addCriterion(String condition,Object value1,Object value2,String property){if (value1 == null || value2 == null){throw new RuntimeException("Between values for " + property + " cannot be null");}criteria.add(new Criterion(condition,value1,value2));}public Criteria andRepairidIsNull(){addCriterion("repairId is null");return (Criteria)this;}public Criteria andRepairidIsNotNull(){addCriterion("repairId is not null");return (Criteria)this;}public Criteria andRepairidEqualTo(Integer value){addCriterion("repairId =",value,"repairid");return (Criteria)this;}public Criteria andRepairidNotEqualTo(Integer value){addCriterion("repairId <>",value,"repairid");return (Criteria)this;}public Criteria andRepairidGreaterThan(Integer value){addCriterion("repairId >",value,"repairid");return (Criteria)this;}public Criteria andRepairidGreaterThanOrEqualTo(Integer value){addCriterion("repairId >=",value,"repairid");return (Criteria)this;}public Criteria andRepairidLessThan(Integer value){addCriterion("repairId <",value,"repairid");return (Criteria)this;}public Criteria andRepairidLessThanOrEqualTo(Integer value){addCriterion("repairId <=",value,"repairid");return (Criteria)this;}public Criteria andRepairidIn(List<Integer> values){addCriterion("repairId in",values,"repairid");return (Criteria)this;}public Criteria andRepairidNotIn(List<Integer> values){addCriterion("repairId not in",values,"repairid");return (Criteria)this;}public Criteria andRepairidBetween(Integer value1,Integer value2){addCriterion("repairId between",value1,value2,"repairid");return (Criteria)this;}public Criteria andRepairidNotBetween(Integer value1,Integer value2){addCriterion("repairId not between",value1,value2,"repairid");return (Criteria)this;}public Criteria andRepairernameIsNull(){addCriterion("repairerName is null");return (Criteria)this;}public Criteria andRepairernameIsNotNull(){addCriterion("repairerName is not null");return (Criteria)this;}public Criteria andRepairernameEqualTo(String value){addCriterion("repairerName =",value,"repairername");return (Criteria)this;}public Criteria andRepairernameNotEqualTo(String value){addCriterion("repairerName <>",value,"repairername");return (Criteria)this;}public Criteria andRepairernameGreaterThan(String value){addCriterion("repairerName >",value,"repairername");return (Criteria)this;}public Criteria andRepairernameGreaterThanOrEqualTo(String value){addCriterion("repairerName >=",value,"repairername");return (Criteria)this;}public Criteria andRepairernameLessThan(String value){addCriterion("repairerName <",value,"repairername");return (Criteria)this;}public Criteria andRepairernameLessThanOrEqualTo(String value){addCriterion("repairerName <=",value,"repairername");return (Criteria)this;}public Criteria andRepairernameLike(String value){addCriterion("repairerName like",value,"repairername");return (Criteria)this;}public Criteria andRepairernameNotLike(String value){addCriterion("repairerName not like",value,"repairername");return (Criteria)this;}public Criteria andRepairernameIn(List<String> values){addCriterion("repairerName in",values,"repairername");return (Criteria)this;}public Criteria andRepairernameNotIn(List<String> values){addCriterion("repairerName not in",values,"repairername");return (Criteria)this;}public Criteria andRepairernameBetween(String value1,String value2){addCriterion("repairerName between",value1,value2,"repairername");return (Criteria)this;}public Criteria andRepairernameNotBetween(String value1,String value2){addCriterion("repairerName not between",value1,value2,"repairername");return (Criteria)this;}public Criteria andRepairertelIsNull(){addCriterion("repairertel is null");return (Criteria)this;}public Criteria andRepairertelIsNotNull(){addCriterion("repairertel is not null");return (Criteria)this;}public Criteria andRepairertelEqualTo(String value){addCriterion("repairertel =",value,"repairertel");return (Criteria)this;}public Criteria andRepairertelNotEqualTo(String value){addCriterion("repairertel <>",value,"repairertel");return (Criteria)this;}public Criteria andRepairertelGreaterThan(String value){addCriterion("repairertel >",value,"repairertel");return (Criteria)this;}public Criteria andRepairertelGreaterThanOrEqualTo(String value){addCriterion("repairertel >=",value,"repairertel");return (Criteria)this;}public Criteria andRepairertelLessThan(String value){addCriterion("repairertel <",value,"repairertel");return (Criteria)this;}public Criteria andRepairertelLessThanOrEqualTo(String value){addCriterion("repairertel <=",value,"repairertel");return (Criteria)this;}public Criteria andRepairertelLike(String value){addCriterion("repairertel like",value,"repairertel");return (Criteria)this;}public Criteria andRepairertelNotLike(String value){addCriterion("repairertel not like",value,"repairertel");return (Criteria)this;}public Criteria andRepairertelIn(List<String> values){addCriterion("repairertel in",values,"repairertel");return (Criteria)this;}public Criteria andRepairertelNotIn(List<String> values){addCriterion("repairertel not in",values,"repairertel");return (Criteria)this;}public Criteria andRepairertelBetween(String value1,String value2){addCriterion("repairertel between",value1,value2,"repairertel");return (Criteria)this;}public Criteria andRepairertelNotBetween(String value1,String value2){addCriterion("repairertel not between",value1,value2,"repairertel");return (Criteria)this;}public Criteria andProductidIsNull(){addCriterion("productid is null");return (Criteria)this;}public Criteria andProductidIsNotNull(){addCriterion("productid is not null");return (Criteria)this;}public Criteria andProductidEqualTo(Integer value){addCriterion("productid =",value,"productid");return (Criteria)this;}public Criteria andProductidNotEqualTo(Integer value){addCriterion("productid <>",value,"productid");return (Criteria)this;}public Criteria andProductidGreaterThan(Integer value){addCriterion("productid >",value,"productid");return (Criteria)this;}public Criteria andProductidGreaterThanOrEqualTo(Integer value){addCriterion("productid >=",value,"productid");return (Criteria)this;}public Criteria andProductidLessThan(Integer value){addCriterion("productid <",value,"productid");return (Criteria)this;}public Criteria andProductidLessThanOrEqualTo(Integer value){addCriterion("productid <=",value,"productid");return (Criteria)this;}public Criteria andProductidIn(List<Integer> values){addCriterion("productid in",values,"productid");return (Criteria)this;}public Criteria andProductidNotIn(List<Integer> values){addCriterion("productid not in",values,"productid");return (Criteria)this;}public Criteria andProductidBetween(Integer value1,Integer value2){addCriterion("productid between",value1,value2,"productid");return (Criteria)this;}public Criteria andProductidNotBetween(Integer value1,Integer value2){addCriterion("productid not between",value1,value2,"productid");return (Criteria)this;}public Criteria andCustomernameIsNull(){addCriterion("customername is null");return (Criteria)this;}public Criteria andCustomernameIsNotNull(){addCriterion("customername is not null");return (Criteria)this;}public Criteria andCustomernameEqualTo(String value){addCriterion("customername =",value,"customername");return (Criteria)this;}public Criteria andCustomernameNotEqualTo(String value){addCriterion("customername <>",value,"customername");return (Criteria)this;}public Criteria andCustomernameGreaterThan(String value){addCriterion("customername >",value,"customername");return (Criteria)this;}public Criteria andCustomernameGreaterThanOrEqualTo(String value){addCriterion("customername >=",value,"customername");return (Criteria)this;}public Criteria andCustomernameLessThan(String value){addCriterion("customername <",value,"customername");return (Criteria)this;}public Criteria andCustomernameLessThanOrEqualTo(String value){addCriterion("customername <=",value,"customername");return (Criteria)this;}public Criteria andCustomernameLike(String value){addCriterion("customername like",value,"customername");return (Criteria)this;}public Criteria andCustomernameNotLike(String value){addCriterion("customername not like",value,"customername");return (Criteria)this;}public Criteria andCustomernameIn(List<String> values){addCriterion("customername in",values,"customername");return (Criteria)this;}public Criteria andCustomernameNotIn(List<String> values){addCriterion("customername not in",values,"customername");return (Criteria)this;}public Criteria andCustomernameBetween(String value1,String value2){addCriterion("customername between",value1,value2,"customername");return (Criteria)this;}public Criteria andCustomernameNotBetween(String value1,String value2){addCriterion("customername not between",value1,value2,"customername");return (Criteria)this;}public Criteria andDateIsNull(){addCriterion("date is null");return (Criteria)this;}public Criteria andDateIsNotNull(){addCriterion("date is not null");return (Criteria)this;}public Criteria andDateEqualTo(Date value){addCriterion("date =",value,"date");return (Criteria)this;}public Criteria andDateNotEqualTo(Date value){addCriterion("date <>",value,"date");return (Criteria)this;}public Criteria andDateGreaterThan(Date value){addCriterion("date >",value,"date");return (Criteria)this;}public Criteria andDateGreaterThanOrEqualTo(Date value){addCriterion("date >=",value,"date");return (Criteria)this;}public Criteria andDateLessThan(Date value){addCriterion("date <",value,"date");return (Criteria)this;}public Criteria andDateLessThanOrEqualTo(Date value){addCriterion("date <=",value,"date");return (Criteria)this;}public Criteria andDateIn(List<Date> values){addCriterion("date in",values,"date");return (Criteria)this;}public Criteria andDateNotIn(List<Date> values){addCriterion("date not in",values,"date");return (Criteria)this;}public Criteria andDateBetween(Date value1,Date value2){addCriterion("date between",value1,value2,"date");return (Criteria)this;}public Criteria andDateNotBetween(Date value1,Date value2){addCriterion("date not between",value1,value2,"date");return (Criteria)this;}public Criteria andCustomertelIsNull(){addCriterion("customertel is null");return (Criteria)this;}public Criteria andCustomertelIsNotNull(){addCriterion("customertel is not null");return (Criteria)this;}public Criteria andCustomertelEqualTo(String value){addCriterion("customertel =",value,"customertel");return (Criteria)this;}public Criteria andCustomertelNotEqualTo(String value){addCriterion("customertel <>",value,"customertel");return (Criteria)this;}public Criteria andCustomertelGreaterThan(String value){addCriterion("customertel >",value,"customertel");return (Criteria)this;}public Criteria andCustomertelGreaterThanOrEqualTo(String value){addCriterion("customertel >=",value,"customertel");return (Criteria)this;}public Criteria andCustomertelLessThan(String value){addCriterion("customertel <",value,"customertel");return (Criteria)this;}public Criteria andCustomertelLessThanOrEqualTo(String value){addCriterion("customertel <=",value,"customertel");return (Criteria)this;}public Criteria andCustomertelLike(String value){addCriterion("customertel like",value,"customertel");return (Criteria)this;}public Criteria andCustomertelNotLike(String value){addCriterion("customertel not like",value,"customertel");return (Criteria)this;}public Criteria andCustomertelIn(List<String> values){addCriterion("customertel in",values,"customertel");return (Criteria)this;}public Criteria andCustomertelNotIn(List<String> values){addCriterion("customertel not in",values,"customertel");return (Criteria)this;}public Criteria andCustomertelBetween(String value1,String value2){addCriterion("customertel between",value1,value2,"customertel");return (Criteria)this;}public Criteria andCustomertelNotBetween(String value1,String value2){addCriterion("customertel not between",value1,value2,"customertel");return (Criteria)this;}}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table repair_info
	 * @mbggenerated  Thu Dec 21 13:00:16 GMT+08:00 2017
	 */public static class Criterion {private String condition;private Object value;private Object secondValue;private boolean noValue;private boolean singleValue;private boolean betweenValue;private boolean listValue;private String typeHandler;public String getCondition(){return condition;}public Object getValue(){return value;}public Object getSecondValue(){return secondValue;}public boolean isNoValue(){return noValue;}public boolean isSingleValue(){return singleValue;}public boolean isBetweenValue(){return betweenValue;}public boolean isListValue(){return listValue;}public String getTypeHandler(){return typeHandler;}protected Criterion(String condition){super();this.condition=condition;this.typeHandler=null;this.noValue=true;}protected Criterion(String condition,Object value,String typeHandler){super();this.condition=condition;this.value=value;this.typeHandler=typeHandler;if (value instanceof List<?>){this.listValue=true;} else {this.singleValue=true;}}protected Criterion(String condition,Object value){this(condition,value,null);}protected Criterion(String condition,Object value,Object secondValue,String typeHandler){super();this.condition=condition;this.value=value;this.secondValue=secondValue;this.typeHandler=typeHandler;this.betweenValue=true;}protected Criterion(String condition,Object value,Object secondValue){this(condition,value,secondValue,null);}}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table repair_info
     *
     * @mbggenerated do_not_delete_during_merge Thu Dec 21 12:44:19 GMT+08:00 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}