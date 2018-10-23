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
 window.onload=function(){
	 if('${FLAG}' == 1){
		 alert("添加成功");
	     }
   }
//传入年份和月份 获取该年对应月份的天数
 function getDaysInOneMonth(){
	 var dateStr = document.getElementById("yearMonth").value;;
	 var reg = /^(\d{4})-(\d{1,2})$/;
	 dateStr.match(reg);
	 RegExp.$2 = parseInt(RegExp.$2, 10);
     var d= new Date(RegExp.$1, RegExp.$2, 0);
     document.getElementById('dayNum').value = d.getDate();
}
</script>

<body>
<jsp:include  page="common.jsp"/> 

<!-- 中间布局  -->
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">排班管理</h1>
				</div>
			</div>		
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">当前位置>><strong>新增排班</strong>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="allDuty">返回</a>
						</div>		
						<form action="insertDuty" method="post">
						月份：<input type="text" name="yearMonth" id="yearMonth" onchange="getDaysInOneMonth()"><br>
						需要值班天数：<input type="text" name="dayNum" id="dayNum" disabled="disabled"><br>
						参与值班人员：<br><select name="a" multiple="multiple" style="width: 200px">
                                <c:forEach items="${LIST}" var="list">
									<option value="${list.id }">${list.userName }</option>
								</c:forEach>
                                  </select>
                        <br>				
						<input type="submit" value="保存">
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>