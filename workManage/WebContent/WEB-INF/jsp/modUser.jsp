<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>后台管理系统</title>
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" />
<link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet" />
<link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet" />
<link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet" />
<link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet" />
<link href="<%=basePath%>css/boot-crm.css" rel="stylesheet" />
<link href="<%=basePath%>css/page.css" rel="stylesheet" />

</head>
<script type="text/javascript">
 function sub(){
	   var uValue = document.getElementById("username").value;
	   var pValue = document.getElementById("password").value;
	     if(uValue == "" || pValue == ""){
			 alert("用户名或密码不能为空，请重新输入");
			 return false;
		 }	 
   }
 window.onload=function(){
	 if('${FLAG}' == 1){
		 alert("修改成功");
		 window.location='allUser';
	     }	 
   }

</script>

<body>
<jsp:include  page="common.jsp"/> 

<!-- 中间布局  -->
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">人员管理</h1>
				</div>
			</div>		
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">当前位置>><strong>修改人员</strong>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="allUser">返回</a>
						</div>		
						<form action="updateUser" method="post">
						用户名：<input type="text" name="loginName" value="${USER.loginName }"><br>
						姓&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="userName" value="${USER.userName }"><br>
						手&nbsp;&nbsp;&nbsp;&nbsp;机：<input type="text" name="tel" value="${USER.tel }"><br>
						职&nbsp;&nbsp;&nbsp;&nbsp;务：<input type="text" name="job" value="${USER.job }"><br>
						<input type="hidden" name="id" value="${USER.id }">			
						<input type="submit" value="保存">
						</form>
						<div class="page_btn" id="wrap"></div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>