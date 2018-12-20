<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript">
  function login() {
      var loginForm = document.getElementById("loginForm");
      loginForm.submit();  
  }
  
</script>
</head>
<body>
<h1 style="text-align: center; color: blue">简单聊</h1>
<div class="content">
<form action="login" method="post" id="loginForm" style="text-align: center">
用户:<input type="text" name="userName" /><br>
密码:<input type="password" name="password" /><br>
<input type="button" value="登录" onclick="login()" />
</form>
</div>
</body>
</html>