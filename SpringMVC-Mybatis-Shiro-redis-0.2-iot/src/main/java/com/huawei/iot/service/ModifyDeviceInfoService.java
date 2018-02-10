package com.huawei.iot.service;

import com.huawei.common.model.MDeviceInfo;

public interface ModifyDeviceInfoService {

	MDeviceInfo insert(MDeviceInfo record);

	MDeviceInfo insertSelective(MDeviceInfo record);

}
