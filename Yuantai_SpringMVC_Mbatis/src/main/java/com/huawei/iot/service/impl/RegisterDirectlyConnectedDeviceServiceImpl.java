package com.huawei.iot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huawei.common.dao.RegisterDirectlyConnectedDeviceMapper;
import com.huawei.common.model.MRegisterDirectlyConnectedDevice;
import com.huawei.iot.service.RegisterDirectlyConnectedDeviceService;
import com.sojson.core.mybatis.BaseMybatisDao;
@Service
public class RegisterDirectlyConnectedDeviceServiceImpl extends BaseMybatisDao<RegisterDirectlyConnectedDeviceMapper> implements RegisterDirectlyConnectedDeviceService {

	@Autowired
	RegisterDirectlyConnectedDeviceMapper permissionMapper;

	
	@Override
	public MRegisterDirectlyConnectedDevice insert(MRegisterDirectlyConnectedDevice record) {
		permissionMapper.insert(record);
		return record;
	}

	@Override
	public MRegisterDirectlyConnectedDevice insertSelective(MRegisterDirectlyConnectedDevice record) {
		//添加权限
		permissionMapper.insertSelective(record);
		return record;
	}

	
}
