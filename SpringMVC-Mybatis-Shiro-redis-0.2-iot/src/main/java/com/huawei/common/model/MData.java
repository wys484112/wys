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
    private int VoltgeValue;

    private int ElectricityValue;

    private int TemperatureValue;

    private int BrightnessValue;

    private int LightStatus;

    public void setVoltgeValue(int VoltgeValue){
        this.VoltgeValue = VoltgeValue;
    }
    public int getVoltgeValue(){
        return this.VoltgeValue;
    }
    public void setElectricityValue(int ElectricityValue){
        this.ElectricityValue = ElectricityValue;
    }
    public int getElectricityValue(){
        return this.ElectricityValue;
    }
    public void setTemperatureValue(int TemperatureValue){
        this.TemperatureValue = TemperatureValue;
    }
    public int getTemperatureValue(){
        return this.TemperatureValue;
    }
    public void setBrightnessValue(int BrightnessValue){
        this.BrightnessValue = BrightnessValue;
    }
    public int getBrightnessValue(){
        return this.BrightnessValue;
    }
    public void setLightStatus(int LightStatus){
        this.LightStatus = LightStatus;
    }
    public int getLightStatus(){
        return this.LightStatus;
    }

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}