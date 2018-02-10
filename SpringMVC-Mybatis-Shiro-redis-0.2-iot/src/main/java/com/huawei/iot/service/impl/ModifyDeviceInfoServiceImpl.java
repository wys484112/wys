package com.huawei.iot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huawei.common.dao.ModifyDeviceInfoMapper;
import com.huawei.common.dao.RegisterDirectlyConnectedDeviceMapper;
import com.huawei.common.model.MDeviceInfo;
import com.huawei.common.model.MRegisterDirectlyConnectedDevice;
import com.huawei.iot.service.ModifyDeviceInfoService;
import com.huawei.iot.service.RegisterDirectlyConnectedDeviceService;
import com.sojson.core.mybatis.BaseMybatisDao;
@Service
public class ModifyDeviceInfoServiceImpl extends BaseMybatisDao<RegisterDirectlyConnectedDeviceMapper> implements ModifyDeviceInfoService {

	@Autowired
	ModifyDeviceInfoMapper permissionMapper;

	
	@Override
	public MDeviceInfo insert(MDeviceInfo record) {
		permissionMapper.insert(record);
		return record;
	}

	@Override
	public MDeviceInfo insertSelective(MDeviceInfo record) {
		//添加权限
		permissionMapper.insertSelective(record);
		return record;
	}

	
}
