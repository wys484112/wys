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
public class MResult implements Serializable {
    private int result;

    public void setResult(int result){
        this.result = result;
    }
    public int getResult(){
        return this.result;
    }
    
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}