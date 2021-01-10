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
public class MServiceCapability implements Serializable {
    private String serviceId;

    private String serviceType;

    private String option;

    private String description;

    private List<MCommand> commands;

    private List<MProperty> properties;

    public void setServiceId(String serviceId){
        this.serviceId = serviceId;
    }
    public String getServiceId(){
        return this.serviceId;
    }
    public void setServiceType(String serviceType){
        this.serviceType = serviceType;
    }
    public String getServiceType(){
        return this.serviceType;
    }
    public void setOption(String option){
        this.option = option;
    }
    public String getOption(){
        return this.option;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setCommands(List<MCommand> commands){
        this.commands = commands;
    }
    public List<MCommand> getCommands(){
        return this.commands;
    }
    public void setProperties(List<MProperty> properties){
        this.properties = properties;
    }
    public List<MProperty> getProperties(){
        return this.properties;
    }

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}