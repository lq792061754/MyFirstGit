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
<body>
<%int i=1; %>
<!-- 中间布局  -->
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">排班查询</h1>
				</div>
			</div>		
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">当前位置><strong>查询结果列表</strong>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="allDuty2">返回</a>
						</div>						
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>序号</th>
									<th>值班日期</th>
									<th>值班人</th>
									<th>手机号码</th>
									<th>职务</th>	
								</tr>
							</thead>
							<tbody id="content_page">
								<c:forEach items="${LIST}" var="list">
									<tr>
										<td><%=i %></td>
										<td>${list.dutyDates}</td>
										<td>${list.userName}</td>
										<td>${list.tel}</td>
										<td>${list.job}</td>
									</tr>
									<%i++; %>
								</c:forEach>															
							</tbody>
						</table>
					</div>
			</div>
			</div>
		</div>
<script src="<%=basePath%>js/jquery.min.js"></script>
	<script src="<%=basePath%>js/bootstrap.min.js"></script>
	<script src="<%=basePath%>js/metisMenu.min.js"></script>
	<script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>
	<script src="<%=basePath%>js/sb-admin-2.js"></script>
	<script src="<%=basePath%>js/page.js"></script>
</body>
</html>