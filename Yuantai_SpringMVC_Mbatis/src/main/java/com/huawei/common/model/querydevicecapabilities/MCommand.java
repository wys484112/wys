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
public class MCommand implements Serializable {
    private String commandName;

    private List<MPara> paras;

    private String responses;

    public void setCommandName(String commandName){
        this.commandName = commandName;
    }
    public String getCommandName(){
        return this.commandName;
    }
    public void setParas(List<MPara> paras){
        this.paras = paras;
    }
    public List<MPara> getParas(){
        return this.paras;
    }
    public void setResponses(String responses){
        this.responses = responses;
    }
    public String getResponses(){
        return this.responses;
    }

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}