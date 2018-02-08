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
 * 区分 责任人 日期 说明<br/>
 * 创建 周柏成 2016年5月25日 <br/>
 * <p>
 * *******
 * <p>
 * 
 * @author zhou-baicheng
 * @email i@itboy.net
 * @version 1.0,2016年5月25日 <br/>
 * 
 */
public class MQueryDeviceData implements Serializable {
	 private String deviceId;

	    private String gatewayId;

	    private String nodeType;

	    private String createTime;

	    private String lastModifiedTime;

	    private MDeviceInfo deviceInfo;

	    private String services;

	    private MConnectionInfo connectionInfo;

	    private String location;

	    private List<String> devGroupIds;

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
	    public void setNodeType(String nodeType){
	        this.nodeType = nodeType;
	    }
	    public String getNodeType(){
	        return this.nodeType;
	    }
	    public void setCreateTime(String createTime){
	        this.createTime = createTime;
	    }
	    public String getCreateTime(){
	        return this.createTime;
	    }
	    public void setLastModifiedTime(String lastModifiedTime){
	        this.lastModifiedTime = lastModifiedTime;
	    }
	    public String getLastModifiedTime(){
	        return this.lastModifiedTime;
	    }
	    public void setDeviceInfo(MDeviceInfo deviceInfo){
	        this.deviceInfo = deviceInfo;
	    }
	    public MDeviceInfo getDeviceInfo(){
	        return this.deviceInfo;
	    }
	    public void setServices(String services){
	        this.services = services;
	    }
	    public String getServices(){
	        return this.services;
	    }
	    public void setConnectionInfo(MConnectionInfo connectionInfo){
	        this.connectionInfo = connectionInfo;
	    }
	    public MConnectionInfo getConnectionInfo(){
	        return this.connectionInfo;
	    }
	    public void setLocation(String location){
	        this.location = location;
	    }
	    public String getLocation(){
	        return this.location;
	    }
	    public void setDevGroupIds(List<String> devGroupIds){
	        this.devGroupIds = devGroupIds;
	    }
	    public List<String> getDevGroupIds(){
	        return this.devGroupIds;
	    }

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}