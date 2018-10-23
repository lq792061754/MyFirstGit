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
	   var l = document.getElementById("loginName").value;
	   var u = document.getElementById("userName").value;
	   var p = document.getElementById("pwd").value;
	   var r = document.getElementById("repwd").value;
	   var t = document.getElementById("tel").value;
	   var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
	     if(l == ""){
			 alert("用户名不能为空，请重新输入");
			 return false;
		}
	     if(u == ""){
			 alert("姓名不能为空，请重新输入");
			 return false;
	    }	
        if (!myreg.test(t)) {
        	 alert("请输入有效的手机号");
             return false;
        }
	     if(p == ""){
			 alert("密码不能为空，请重新输入");
			 return false;
	    }	
	     if(p != r){
			 alert("两次密码不一致，请重新输入");
			 return false;
	    }
	    return true;
  }

window.onload=function(){
	 if('${FLAG}' == 1){
		 alert("添加成功");
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
						<div class="panel-heading">当前位置>><strong>新增人员</strong>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="allUser">返回</a>
						</div>		
						<form action="insertUser" method="post" onsubmit="return sub()">
						用户名：<input type="text" name="loginName" id="loginName"><br>
						姓&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="userName" id="userName"><br>
						手&nbsp;&nbsp;&nbsp;&nbsp;机：<input type="text" name="tel" id="tel"><br>
						职&nbsp;&nbsp;&nbsp;&nbsp;务：<input type="text" name="job"><br>
						密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="pwd" id="pwd"><br>
						确认密码：<input type="password" name="repwd" id="repwd"><br>					
						<input type="submit" value="保存">
						</form>
						<div class="page_btn" id="wrap"></div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>