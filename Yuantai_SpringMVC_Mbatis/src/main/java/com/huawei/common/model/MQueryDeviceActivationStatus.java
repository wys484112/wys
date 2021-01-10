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
public class MQueryDeviceActivationStatus implements Serializable {
    private String deviceId;

    private boolean activated;

    private String name;

    public void setDeviceId(String deviceId){
        this.deviceId = deviceId;
    }
    public String getDeviceId(){
        return this.deviceId;
    }
    public void setActivated(boolean activated){
        this.activated = activated;
    }
    public boolean getActivated(){
        return this.activated;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}