package com.huawei.common.model.queryasyncommandsV4;

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
public class MData implements Serializable {
    private String commandId;

    private String appId;

    private String deviceId;

    private MCommand command;

    private String callbackUrl;

    private int expireTime;

    private String status;

    private MResult result;

    private String creationTime;

    private String executeTime;

    private String platformIssuedTime;

    private String deliveredTime;

    private int issuedTimes;

    public void setCommandId(String commandId){
        this.commandId = commandId;
    }
    public String getCommandId(){
        return this.commandId;
    }
    public void setAppId(String appId){
        this.appId = appId;
    }
    public String getAppId(){
        return this.appId;
    }
    public void setDeviceId(String deviceId){
        this.deviceId = deviceId;
    }
    public String getDeviceId(){
        return this.deviceId;
    }
    public void setCommand(MCommand command){
        this.command = command;
    }
    public MCommand getCommand(){
        return this.command;
    }
    public void setCallbackUrl(String callbackUrl){
        this.callbackUrl = callbackUrl;
    }
    public String getCallbackUrl(){
        return this.callbackUrl;
    }
    public void setExpireTime(int expireTime){
        this.expireTime = expireTime;
    }
    public int getExpireTime(){
        return this.expireTime;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setResult(MResult result){
        this.result = result;
    }
    public MResult getResult(){
        return this.result;
    }
    public void setCreationTime(String creationTime){
        this.creationTime = creationTime;
    }
    public String getCreationTime(){
        return this.creationTime;
    }
    public void setExecuteTime(String executeTime){
        this.executeTime = executeTime;
    }
    public String getExecuteTime(){
        return this.executeTime;
    }
    public void setPlatformIssuedTime(String platformIssuedTime){
        this.platformIssuedTime = platformIssuedTime;
    }
    public String getPlatformIssuedTime(){
        return this.platformIssuedTime;
    }
    public void setDeliveredTime(String deliveredTime){
        this.deliveredTime = deliveredTime;
    }
    public String getDeliveredTime(){
        return this.deliveredTime;
    }
    public void setIssuedTimes(int issuedTimes){
        this.issuedTimes = issuedTimes;
    }
    public int getIssuedTimes(){
        return this.issuedTimes;
    }
    
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}