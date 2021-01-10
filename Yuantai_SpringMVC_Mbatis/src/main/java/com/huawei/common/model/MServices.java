package com.huawei.common.model;

import java.io.Serializable;
import java.util.List;

import net.sf.json.JSONObject;

/**
 * 
 * 开发公司：itboy.net<br/>
 * 版权：itboy.net<br/>
 * <p>
 * 
 * 权限实体
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2016年5月25日 　<br/>
 * <p>
 * *******
 * <p>
 * 
 * @author zhou-baicheng
 * @email i@itboy.net
 * @version 1.0,2016年5月25日 <br/>
 * 
 */
public class MServices implements Serializable {
    private String serviceId;

    private String serviceType;

    private MData data;

    private String eventTime;

    private String serviceInfo;

    public void setServiceId(String serviceId){
        this.serviceId = serviceId;
    }
    public String getServiceId(){
        return this.serviceId;
    }
    public void setServiceType(String serviceType){
        this.serviceType = serviceType;
    }
    public String getServiceType(){
        return this.serviceType;
    }
    public void setData(MData data){
        this.data = data;
    }
    public MData getData(){
        return this.data;
    }
    public void setEventTime(String eventTime){
        this.eventTime = eventTime;
    }
    public String getEventTime(){
        return this.eventTime;
    }
    public void setServiceInfo(String serviceInfo){
        this.serviceInfo = serviceInfo;
    }
    public String getServiceInfo(){
        return this.serviceInfo;
    }

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}