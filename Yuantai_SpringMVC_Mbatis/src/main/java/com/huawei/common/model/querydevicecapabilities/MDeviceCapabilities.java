package com.huawei.common.model.querydevicecapabilities;

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
public class MDeviceCapabilities implements Serializable {
	  private String deviceId;

	    private List<MServiceCapability> serviceCapabilities;

	    public void setDeviceId(String deviceId){
	        this.deviceId = deviceId;
	    }
	    public String getDeviceId(){
	        return this.deviceId;
	    }
	    public void setServiceCapabilities(List<MServiceCapability> serviceCapabilities){
	        this.serviceCapabilities = serviceCapabilities;
	    }
	    public List<MServiceCapability> getServiceCapabilities(){
	        return this.serviceCapabilities;
	    }
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
	
}
