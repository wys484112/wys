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
public class MDeviceDataHistoryDTOs implements Serializable {
    private String deviceId;

    private String gatewayId;

    private String appId;

    private String serviceId;

    private MData data;

    private String timestamp;

    public void setDeviceId(String deviceId){
        this.deviceId = deviceId;
    }
    public String getDeviceId(){
        return this.deviceId;
    }
    public void setGatewayId(String gatewayId){
        this.gatewayId = gatewayId;
    }
    public String getGatewayId(){
        return this.gatewayId;
    }
    public void setAppId(String appId){
        this.appId = appId;
    }
    public String getAppId(){
        return this.appId;
    }
    public void setServiceId(String serviceId){
        this.serviceId = serviceId;
    }
    public String getServiceId(){
        return this.serviceId;
    }
    public void setData(MData data){
        this.data = data;
    }
    public MData getData(){
        return this.data;
    }
    public void setTimestamp(String timestamp){
        this.timestamp = timestamp;
    }
    public String getTimestamp(){
        return this.timestamp;
    }

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}