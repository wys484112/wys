package com.huawei.common.dao;

import com.huawei.common.model.MDeviceInfo;

public interface ModifyDeviceInfoMapper {

    int insert(MDeviceInfo record);

    int insertSelective(MDeviceInfo record);

}