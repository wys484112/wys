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
public class MDeviceInfo implements Serializable {
       private String deviceId;
       
       private String nodeId;

	    private String name;

	    private String description;

	    private String manufacturerId;

	    private String manufacturerName;

	    private String mac;

	    private String location;

	    private String deviceType;

	    private String model;

	    private String swVersion;

	    private String fwVersion;

	    private String hwVersion;

	    private String protocolType;

	    private String bridgeId;

	    private String status;

	    private String statusDetail;

	    private String mute;

	    private String supportedSecurity;

	    private String isSecurity;

	    private String signalStrength;

	    private String sigVersion;

	    private String serialNumber;

	    private String batteryLevel;

		public String getDeviceId() {
			return deviceId;
		}
		public void setDeviceId(String deviceId) {
			this.deviceId = deviceId;
		}
	    public void setNodeId(String nodeId){
	        this.nodeId = nodeId;
	    }
	    public String getNodeId(){
	        return this.nodeId;
	    }
	    public void setName(String name){
	        this.name = name;
	    }
	    public String getName(){
	        return this.name;
	    }
	    public void setDescription(String description){
	        this.description = description;
	    }
	    public String getDescription(){
	        return this.description;
	    }
	    public void setManufacturerId(String manufacturerId){
	        this.manufacturerId = manufacturerId;
	    }
	    public String getManufacturerId(){
	        return this.manufacturerId;
	    }
	    public void setManufacturerName(String manufacturerName){
	        this.manufacturerName = manufacturerName;
	    }
	    public String getManufacturerName(){
	        return this.manufacturerName;
	    }
	    public void setMac(String mac){
	        this.mac = mac;
	    }
	    public String getMac(){
	        return this.mac;
	    }
	    public void setLocation(String location){
	        this.location = location;
	    }
	    public String getLocation(){
	        return this.location;
	    }
	    public void setDeviceType(String deviceType){
	        this.deviceType = deviceType;
	    }
	    public String getDeviceType(){
	        return this.deviceType;
	    }
	    public void setModel(String model){
	        this.model = model;
	    }
	    public String getModel(){
	        return this.model;
	    }
	    public void setSwVersion(String swVersion){
	        this.swVersion = swVersion;
	    }
	    public String getSwVersion(){
	        return this.swVersion;
	    }
	    public void setFwVersion(String fwVersion){
	        this.fwVersion = fwVersion;
	    }
	    public String getFwVersion(){
	        return this.fwVersion;
	    }
	    public void setHwVersion(String hwVersion){
	        this.hwVersion = hwVersion;
	    }
	    public String getHwVersion(){
	        return this.hwVersion;
	    }
	    public void setProtocolType(String protocolType){
	        this.protocolType = protocolType;
	    }
	    public String getProtocolType(){
	        return this.protocolType;
	    }
	    public void setBridgeId(String bridgeId){
	        this.bridgeId = bridgeId;
	    }
	    public String getBridgeId(){
	        return this.bridgeId;
	    }
	    public void setStatus(String status){
	        this.status = status;
	    }
	    public String getStatus(){
	        return this.status;
	    }
	    public void setStatusDetail(String statusDetail){
	        this.statusDetail = statusDetail;
	    }
	    public String getStatusDetail(){
	        return this.statusDetail;
	    }
	    public void setMute(String mute){
	        this.mute = mute;
	    }
	    public String getMute(){
	        return this.mute;
	    }
	    public void setSupportedSecurity(String supportedSecurity){
	        this.supportedSecurity = supportedSecurity;
	    }
	    public String getSupportedSecurity(){
	        return this.supportedSecurity;
	    }
	    public void setIsSecurity(String isSecurity){
	        this.isSecurity = isSecurity;
	    }
	    public String getIsSecurity(){
	        return this.isSecurity;
	    }
	    public void setSignalStrength(String signalStrength){
	        this.signalStrength = signalStrength;
	    }
	    public String getSignalStrength(){
	        return this.signalStrength;
	    }
	    public void setSigVersion(String sigVersion){
	        this.sigVersion = sigVersion;
	    }
	    public String getSigVersion(){
	        return this.sigVersion;
	    }
	    public void setSerialNumber(String serialNumber){
	        this.serialNumber = serialNumber;
	    }
	    public String getSerialNumber(){
	        return this.serialNumber;
	    }
	    public void setBatteryLevel(String batteryLevel){
	        this.batteryLevel = batteryLevel;
	    }
	    public String getBatteryLevel(){
	        return this.batteryLevel;
	    }

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}