<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=0.95, user-scalable=no" />
<title>黄山醉温泉</title>
<link href="css/base.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<!--[if IE 6]><script type="text/javascript" src="js/DD_belatedPNG.js"></script>
<script type="text/javascript">
    window.onload = function(){
        DD_belatedPNG.fix("img, div, a");
    }
</script>
<![endif]-->
<!--[if lt IE 9]>
   <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
</head>
<body>
<h2>留言管理</h2>
<table>
							<thead>
								<tr>
								    <th>编号</th>
									<th>昵称</th>
									<th>邮箱</th>
									<th>时间</th>
									<th>内容</th>
									<th>操作</th>									
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${LIST}" var="list">
									<tr>
										<td>00${list.id}&nbsp;&nbsp;&nbsp;&nbsp;</td>
										<td>${list.user}&nbsp;&nbsp;&nbsp;&nbsp;</td>
										<td>${list.email}&nbsp;&nbsp;&nbsp;&nbsp;</td>
										<td>${list.time}&nbsp;&nbsp;&nbsp;&nbsp;</td>
										<td>
										<textarea style="width:400px; height:60px" disabled="disabled">${list.content}</textarea>
										</td>										
										<td> 
										<a href="DelMsg?id=${list.id}">删除</a>
										</td>
									</tr>
								</c:forEach>															
							</tbody>
						</table>
</body>
</html>