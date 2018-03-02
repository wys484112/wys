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
public class MParas implements Serializable {
    private String openhour;

    private String openminute;

    private String closehour;

    private String closeminute;

    public void setOpenhour(String openhour){
        this.openhour = openhour;
    }
    public String getOpenhour(){
        return this.openhour;
    }
    public void setOpenminute(String openminute){
        this.openminute = openminute;
    }
    public String getOpenminute(){
        return this.openminute;
    }
    public void setClosehour(String closehour){
        this.closehour = closehour;
    }
    public String getClosehour(){
        return this.closehour;
    }
    public void setCloseminute(String closeminute){
        this.closeminute = closeminute;
    }
    public String getCloseminute(){
        return this.closeminute;
    }
    
    
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}