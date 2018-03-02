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
public class MData implements Serializable {
    private int voltgeValue;

    private int powerValue;

    private int temperatureValue;

    private int brightnessValue;

    private int lightStatus;

    public void setVoltgeValue(int voltgeValue){
        this.voltgeValue = voltgeValue;
    }
    public int getVoltgeValue(){
        return this.voltgeValue;
    }
    public void setPowerValue(int powerValue){
        this.powerValue = powerValue;
    }
    public int getPowerValue(){
        return this.powerValue;
    }
    public void setTemperatureValue(int temperatureValue){
        this.temperatureValue = temperatureValue;
    }
    public int getTemperatureValue(){
        return this.temperatureValue;
    }
    public void setBrightnessValue(int brightnessValue){
        this.brightnessValue = brightnessValue;
    }
    public int getBrightnessValue(){
        return this.brightnessValue;
    }
    public void setLightStatus(int lightStatus){
        this.lightStatus = lightStatus;
    }
    public int getLightStatus(){
        return this.lightStatus;
    }

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}




