package com.huawei.iot.service;

import com.huawei.common.model.MRegisterDirectlyConnectedDevice;

public interface RegisterDirectlyConnectedDeviceService {

	MRegisterDirectlyConnectedDevice insert(MRegisterDirectlyConnectedDevice record);

	MRegisterDirectlyConnectedDevice insertSelective(MRegisterDirectlyConnectedDevice record);

}
