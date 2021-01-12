<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8" />
		<title>运费查询</title>
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
				so.id('deleteAll').on('click',function(){
					return _delete();
				});					
			});

			function _delete(){
					var index = layer.confirm("确定更新后台运费数据库？",function(){
						var load = layer.load();
						$.post('${basePath}/member/insertPostageValueTable.shtml',function(result){
							layer.close(load);
							if(result && result.status != 200){
								return layer.msg(result.message,so.default),!0;
							}else{
								layer.msg('更新成功');
								setTimeout(function(){
									$('#formId').submit();
								},1000);
							}
						},'json');
						layer.close(index);
					});
				}					
		</script>
	</head>
	<body data-target="#one" data-spy="scroll">
		
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<div class="row">
				<div class="col-md-10">
					<h2>运费查询</h2>
					<hr>
					<form method="post" action="" id="formId" class="form-inline">
						<div clss="well">
					      <div class="form-group">
					        <input type="text" class="form-control" style="width: 300px;" value="${findWeight?default('')}" 
					        			name="findWeight" id="findWeight" placeholder="输入克重">
					      </div>
				      	  <div class="form-group">
					        <input type="text" class="form-control" style="width: 300px;" value="${findCountryCode?default('')}" 
					        			name="findCountryCode" id="findCountryCode" placeholder="输入国家编码">
					      </div>					      
					     <span class=""> <#--pull-right -->
				         	<button type="submit" class="btn btn-primary">查询</button>
				         	<button type="button" id="deleteAll" class="btn  btn-danger">更新后台运费数据库</button>				         	
				         </span>    
				        </div>
					<hr>
					<table class="table table-bordered">
						<tr>
							<th>重量</th>
							<th>国家编码</th>
							<th>服务方式</th>
							<th>物流方式</th>
							<th>邮费</th>
						</tr>
						<#if page?exists && page.list?size gt 0 >
							<#list page.list as it>
								<tr>
									<td>${it.weight?default('')}</td>
									<td>${it.countrycode?default('未设置')}</td>
									<td>${it.servicemode?default('未设置')}</td>									
									<td>${it.logistics?default('未设置')}</td>
									<td>${it.calculation?default('未设置')}</td>
			
								</tr>
							</#list>
						<#else>
							<tr>
								<td class="text-center danger" colspan="6">没有找到</td>
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
		</div>
			
	</body>
</html>