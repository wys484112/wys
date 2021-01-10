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
public class MPagination implements Serializable {
    private int pageNo;

    private int pageSize;

    private int totalSize;

    public void setPageNo(int pageNo){
        this.pageNo = pageNo;
    }
    public int getPageNo(){
        return this.pageNo;
    }
    public void setPageSize(int pageSize){
        this.pageSize = pageSize;
    }
    public int getPageSize(){
        return this.pageSize;
    }
    public void setTotalSize(int totalSize){
        this.totalSize = totalSize;
    }
    public int getTotalSize(){
        return this.totalSize;
    }
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}