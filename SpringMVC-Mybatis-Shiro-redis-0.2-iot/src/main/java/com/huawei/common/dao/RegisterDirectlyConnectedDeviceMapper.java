package com.huawei.common.dao;

import java.util.List;
import java.util.Set;

import com.huawei.common.model.MRegisterDirectlyConnectedDevice;

public interface RegisterDirectlyConnectedDeviceMapper {

    int insert(MRegisterDirectlyConnectedDevice record);

    int insertSelective(MRegisterDirectlyConnectedDevice record);

}