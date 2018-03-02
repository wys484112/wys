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
public class MPara implements Serializable {
    private String paraName;

    private String dataType;

    private boolean required;

    private String min;

    private String max;

    private int step;

    private int maxLength;

    private String unit;

    private String enumList;

    public void setParaName(String paraName){
        this.paraName = paraName;
    }
    public String getParaName(){
        return this.paraName;
    }
    public void setDataType(String dataType){
        this.dataType = dataType;
    }
    public String getDataType(){
        return this.dataType;
    }
    public void setRequired(boolean required){
        this.required = required;
    }
    public boolean getRequired(){
        return this.required;
    }
    public void setMin(String min){
        this.min = min;
    }
    public String getMin(){
        return this.min;
    }
    public void setMax(String max){
        this.max = max;
    }
    public String getMax(){
        return this.max;
    }
    public void setStep(int step){
        this.step = step;
    }
    public int getStep(){
        return this.step;
    }
    public void setMaxLength(int maxLength){
        this.maxLength = maxLength;
    }
    public int getMaxLength(){
        return this.maxLength;
    }
    public void setUnit(String unit){
        this.unit = unit;
    }
    public String getUnit(){
        return this.unit;
    }
    public void setEnumList(String enumList){
        this.enumList = enumList;
    }
    public String getEnumList(){
        return this.enumList;
    }

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}