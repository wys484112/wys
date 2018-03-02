package com.huawei.common.model.queryasyncommandsV4;

import java.io.Serializable;
import java.util.List;

import net.sf.json.JSONObject;

public class MQueryAsynCommandsV4 implements Serializable  {
    private MPagination pagination;

    private List<MData> data;

    public void setPagination(MPagination pagination){
        this.pagination = pagination;
    }
    public MPagination getPagination(){
        return this.pagination;
    }
    public void setData(List<MData> data){
        this.data = data;
    }
    public List<MData> getData(){
        return this.data;
    }
    
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}

