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
public class MRegisterDirectlyConnectedDevice implements Serializable {
    private String deviceId;

    private String verifyCode;

    private Long timeout;

    private String psk;

    public void setDeviceId(String deviceId){
        this.deviceId = deviceId;
    }
    public String getDeviceId(){
        return this.deviceId;
    }
    public void setVerifyCode(String verifyCode){
        this.verifyCode = verifyCode;
    }
    public String getVerifyCode(){
        return this.verifyCode;
    }
    public void setTimeout(Long timeout){
        this.timeout = timeout;
    }
    public Long getTimeout(){
        return this.timeout;
    }
    public void setPsk(String psk){
        this.psk = psk;
    }
    public String getPsk(){
        return this.psk;
    }

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}