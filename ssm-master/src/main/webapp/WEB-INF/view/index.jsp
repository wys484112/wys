<jsp:include page="common/global.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1>这是WEB-INF/view/目录下的index.jsp</h1>
<p><span>requestHashCode = </span><span id="requestHashCode"></span>
<p><a href="">游客页面</a></p>
<p><a href="guest/login">登录页面</a></p>
<p><a href="activeMQTest">activeMq测试页面</a></p>
</body>
<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/common/jquery-1.12.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $.ajax({
            type: "POST",
            url: $ctx + "/testRequestHashCode",
            data: {
            },
            success: function (data) {
                var dataMsg = eval("("+data.msg+")");
                $("#requestHashCode").html(dataMsg.requestHashCode);
            }
        });

    });
</script>
</html>