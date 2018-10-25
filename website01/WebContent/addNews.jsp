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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>黄山醉温泉</title>
</head>
<body>
<h2>添加新闻</h2>
<form action="InsertArt" enctype="multipart/form-data" method="post">
					<input type="text" name="picname" placeholder="请输入图片标题"><br>
					<input type="file" name="word"/><br>
					<textarea name="content" rows="10px" cols="60px"></textarea><br>
					<input type="submit" value="添加">
					</form>
</body>
</html>