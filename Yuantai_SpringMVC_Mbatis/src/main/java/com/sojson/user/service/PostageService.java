package com.sojson.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import com.sojson.common.model.PostageValue;
import com.sojson.common.model.UUser;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.permission.bo.URoleBo;
import com.sojson.permission.bo.UserRoleAllocationBo;

public interface PostageService {

	int deleteByPrimaryKey(Long id);

	PostageValue insert(PostageValue record);

	PostageValue insertSelective(PostageValue record);

	PostageValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PostageValue record);

    int updateByPrimaryKey(PostageValue record);
    


	Pagination<PostageValue> findByPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);

	Map<String, Object> deleteUserById(String ids);


	Pagination<UserRoleAllocationBo> findUserAndRole(ModelMap modelMap,
			Integer pageNo, Integer pageSize);

	Map<String, Object> insertPostageValueTable();


}
