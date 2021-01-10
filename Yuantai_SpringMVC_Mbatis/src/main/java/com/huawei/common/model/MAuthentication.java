package com.huawei.common.model;

import java.io.Serializable;

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
public class MAuthentication implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private String accessToken;

    private String tokenType;

    private String refreshToken;

    private int expiresIn;

    private String scope;

    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }
    public String getAccessToken(){
        return this.accessToken;
    }
    public void setTokenType(String tokenType){
        this.tokenType = tokenType;
    }
    public String getTokenType(){
        return this.tokenType;
    }
    public void setRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }
    public String getRefreshToken(){
        return this.refreshToken;
    }
    public void setExpiresIn(int expiresIn){
        this.expiresIn = expiresIn;
    }
    public int getExpiresIn(){
        return this.expiresIn;
    }
    public void setScope(String scope){
        this.scope = scope;
    }
    public String getScope(){
        return this.scope;
    }

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}