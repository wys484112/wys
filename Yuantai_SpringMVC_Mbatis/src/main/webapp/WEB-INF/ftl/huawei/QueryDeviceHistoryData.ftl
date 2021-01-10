<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8" />
		<title>设备列表 - 设备管理</title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
		<link   rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
		<link   rel="shortcut icon" href="${basePath}/favicon.ico" />
		<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>
		<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet"/>
		<script  src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
		<script  src="${basePath}/js/common/layer/layer.js"></script>
		<script  src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script  src="${basePath}/js/shiro.demo.js"></script>
		<script >
			so.init(function(){
				//初始化全选。
				so.checkBoxInit('#checkAll','[check=box]');
				
				<@shiro.hasPermission name="/huawei/DeleteDirectlyConnectedDevice.shtml">
				//全选
				so.id('queryDeviceHistoryData').on('click',function(){
					var checkeds = $('[check=box]:checked');
					if(!checkeds.length){
						return layer.msg('请选择要删除的选项。',so.default),!0;
					}
					var array = [];
					checkeds.each(function(){
						array.push(this.value);
					});
					return queryDeviceHistoryData(array);
				});
				</@shiro.hasPermission>
				
								
				<@shiro.hasPermission name="/huawei/DeleteDirectlyConnectedDevice.shtml">
				//全选
				so.id('deleteAll').on('click',function(){
					var checkeds = $('[check=box]:checked');
					if(!checkeds.length){
						return layer.msg('请选择要删除的选项。',so.default),!0;
					}
					var array = [];
					checkeds.each(function(){
						array.push(this.value);
					});
					return deletedById(array);
				});
				</@shiro.hasPermission>
				
				
				<@shiro.hasPermission name="/huawei/modifyDeviceInfo.shtml">				
				so.id('editAll').on('click',function(){
					var checkeds = $('[check=box]:checked');
					if(!checkeds.length){
						return layer.msg('请选择要删除的选项。',so.default),!0;
					}
					var array = [];
					checkeds.each(function(){
						array.push(this.value);
					});
					return modifyDeviceInfo(array);
				});				
				</@shiro.hasPermission>
			});
			<@shiro.hasPermission name="/huawei/DeleteDirectlyConnectedDevice.shtml">					
			<#--根据ID数组删除角色-->
			function deletedById(deviceIds){			
				var index = layer.confirm("确定这"+ deviceIds.length +"个权限？",function(){
					var load = layer.load();
					$.post('${basePath}/huawei/DeleteDirectlyConnectedDevice.shtml',{deviceIds:deviceIds.join(',')},function(result){
						layer.close(load);
						if(result && result.status != 200){
							return layer.msg(result.message,so.default),!0;
						}else{
							layer.msg(result.resultMsg);
							setTimeout(function(){
								$('#formId').submit();
							},1000);
						}
					},'json');
					layer.close(index);
				});
			}
			</@shiro.hasPermission>
						
						
			function queryDeviceHistoryData(deviceIds){															
				var index = layer.confirm("确定这"+ deviceIds.length +"个权限？",function(){
					var load = layer.load();
					$.post('${basePath}/huawei/QueryDeviceHistoryData.shtml',{deviceIds:deviceIds.join(',')},function(result){
					},'json');
					layer.close(index);
				});
				
				
			}
									
			
			$(function() {
$('#modifyDeviceInfo').on('show.bs.modal', function (event) {
	    console.log("aaaaaaaaaaaaaa");
	     var modal = $(this)	   
        var button = $(event.relatedTarget) // 触发事件的按钮  
        var recipient = button.data('whatever') // 解析出data-whatever内容  
		modal.find('#deviceId').val(recipient);
});
});
			<#--根据ID数组删除角色-->
			function modifyDeviceInfo(ids){
				var name = $('#name').val(),	
					deviceType = $('#deviceType').val(),				
					manufacturerId = $('#manufacturerId').val(),	
					manufacturerName = $('#manufacturerName').val(),	
					model = $('#model').val(),																						
					protocolType  = $('#protocolType').val();
				if($.trim(name) == ''){
					return layer.msg('设备名称不能为空。',so.default),!1;
				}
				if($.trim(deviceType) == ''){
					return layer.msg('设备类型不能为空。',so.default),!1;
				}
				if($.trim(manufacturerId) == ''){
					return layer.msg('厂商ID不能为空。',so.default),!1;
				}
				if($.trim(manufacturerName) == ''){
					return layer.msg('厂商名称不能为空。',so.default),!1;
				}
				if($.trim(model) == ''){
					return layer.msg('设备型号不能为空。',so.default),!1;
				}																
				if($.trim(protocolType) == ''){
					return layer.msg('协议类型不能为空。',so.default),!1;
				}
				<#--loding-->
				var load = layer.load();
				$.post('${basePath}/huawei/modifyDeviceInfo.shtml',{deviceIds:ids.join(','),
				name:name,
				deviceType:deviceType,
				manufacturerId:manufacturerId,
				manufacturerName:manufacturerName,
				model:model,
				protocolType:protocolType},function(result){
					layer.close(load);
					if(result && result.status != 200){
						return layer.msg(result.message,so.default),!1;
					}
					layer.msg('添加成功。');
					setTimeout(function(){
						$('#formId').submit();
					},1000);
				},'json');	
			}
			
						
			<@shiro.hasPermission name="/huawei/RegisterDirectlyConnectedDevice.shtml">
			<#--添加权限-->
			function addPermission(){
				var verifyCode = $('#verifyCode').val(),
					timeout  = $('#timeout').val();
				if($.trim(verifyCode) == ''){
					return layer.msg('设备verifyCode不能为空。',so.default),!1;
				}
				if($.trim(timeout) == ''){
					return layer.msg('设备timeout不能为空。',so.default),!1;
				}
				<#--loding-->
				var load = layer.load();
				$.post('${basePath}/huawei/RegisterDirectlyConnectedDevice.shtml',{verifyCode:verifyCode,timeout:timeout},function(result){
					layer.close(load);
					if(result && result.status != 200){
						return layer.msg(result.message,so.default),!1;
					}
					layer.msg('添加成功。');
					setTimeout(function(){
						$('#formId').submit();
					},1000);
				},'json');
			}
			</@shiro.hasPermission>
		</script>
	</head>
	<body data-target="#one" data-spy="scroll">
	

			
			
			
		<#--引入头部-->
		<@_top.top 3/>
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<div class="row">
				<#--引入左侧菜单-->
				<@_left.role 3/>
				<div class="col-md-10">
					<h2>设备历史数据</h2>
					<hr>
					<form method="post" action="" id="formId" class="form-inline">
						<div clss="well">
					      <div class="form-group">
					        <input type="text" class="form-control" style="width: 300px;" value="${findContent?default('')}" 
					        			name="findContent" id="findContent" placeholder="输入设备id">
					      </div>
					     <span class=""> <#--pull-right -->
				         	<button type="submit" class="btn btn-primary">查询</button>
				         	<@shiro.hasPermission name="/huawei/RegisterDirectlyConnectedDevice.shtml">
				         		<a class="btn btn-success" onclick="$('#addPermission').modal();">增加设备</a>
				         	</@shiro.hasPermission>

			         		<@shiro.hasPermission name="/permission/addPermission.shtml">
				         		<a class="btn btn-success" onclick="$('#modifyDeviceInfo').modal();">编辑设备信息</a>
				         	</@shiro.hasPermission>
				         	
				         	<@shiro.hasPermission name="/huawei/DeleteDirectlyConnectedDevice.shtml">
				         		<button type="button" id="queryDeviceHistoryData" class="btn  btn-success">查询设备历史数据</button>
				         	</@shiro.hasPermission>
				         					         					         	
				         	<@shiro.hasPermission name="/huawei/DeleteDirectlyConnectedDevice.shtml">
				         		<button type="button" id="deleteAll" class="btn  btn-danger">Delete</button>
				         	</@shiro.hasPermission>

				         					         				         	
				         </span>    
				        </div>
					<hr>
					<table class="table table-bordered">
						<tr>
							<th>设备ID</th>
							<th>设备数据</th>
							<th>时间</th>																				
						</tr>
						<#if page?exists && page.list?size gt 0 >
							<#list page.list as it>
								<tr>
									<td>${it.deviceId?default('-')}</td>
									<td>${it.data?default('-')}</td>	
									<td>${it.timestamp?default('-')}</td>																								
								</tr>
							</#list>
						<#else>
							<tr>
								<td class="text-center danger" colspan="4">没有找到历史数据</td>
							</tr>
						</#if>
					</table>
					<#if page?exists>
						<div class="pagination pull-right">
							${page.pageHtml}
						</div>
					</#if>
					</form>
				</div>
			</div><#--/row-->
			
			       
			
			<@shiro.hasPermission name="/huawei/RegisterDirectlyConnectedDevice.shtml">
			<#--弹框-->
			<div class="modal fade" id="addPermission" tabindex="-1" role="dialog" aria-labelledby="addPermissionLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="addPermissionLabel">添加设备</h4>
			      </div>
			      <div class="modal-body">
			        <form id="boxRoleForm">
			          <div class="form-group">
			            <label for="recipient-name" class="control-label">verifyCode:</label>
			            <input type="text" class="form-control" name="verifyCode" id="verifyCode" placeholder="请输入设备verifyCode"/>
			          </div>
			          <div class="form-group">
			            <label for="recipient-name" class="control-label">设备timeout:</label>
			            <input type="text" class="form-control" id="timeout" name="timeout"  placeholder="请输入设备timeout">
			          </div>
			        </form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" onclick="addPermission();" class="btn btn-primary">Save</button>
			      </div>
			    </div>
			  </div>
			</div>
			<#--/弹框-->
			</@shiro.hasPermission>
																								
			<#--弹框-->
			<div class="modal fade" id="modifyDeviceInfo" tabindex="-1" role="dialog" aria-labelledby="modifyDeviceInfoLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="modifyDeviceInfoLabel">编辑设备信息</h4>
			      </div>
			      <div class="modal-body">
			        <form id="boxRoleForm">		        
			          <div class="form-group">
			            <label for="recipient-name" class="control-label">设备名称:</label>
			            <input type="text" class="form-control" name="name" id="name" placeholder="请输入设备名称"/>
			          </div>
			          <div class="form-group">
			            <label for="recipient-name" class="control-label">设备类型:</label>
			            <input type="text" class="form-control" name="deviceType" id="deviceType" placeholder="请输入设备类型"/>
			          </div>
			          <div class="form-group">
			            <label for="recipient-name" class="control-label">厂商ID:</label>
			            <input type="text" class="form-control" name="manufacturerId" id="manufacturerId" placeholder="请输入厂商ID"/>
			          </div>
			          
			          <div class="form-group">
			            <label for="recipient-name" class="control-label">厂商名称:</label>
			            <input type="text" class="form-control" name="manufacturerName" id="manufacturerName" placeholder="请输入厂商名称"/>
			          </div>
			          <div class="form-group">
			            <label for="recipient-name" class="control-label">设备型号:</label>
			            <input type="text" class="form-control" name="model" id="model" placeholder="请输入设备型号"/>
			          </div>
			          <div class="form-group">
			            <label for="recipient-name" class="control-label">协议类型:</label>
			            <input type="text" class="form-control" name="protocolType" id="protocolType" placeholder="请输入协议类型"/>
			          </div>			          
			        </form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" id="editAll" class="btn btn-primary">Save</button>
			      </div>
			    </div>
			  </div>
			</div>
			<#--/弹框-->
			
			
		</div>
			
	</body>
</html>