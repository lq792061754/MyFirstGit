<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>LOGIN</title>
  </head>
  <style type="text/css">
    .error {
      color: red;
    }
  </style>
  <script type="text/javascript">
    function login() {
      var loginFormObj = document.getElementById("loginForm");//获取表单对象带.value，否则提交不上去！！！
      var isEmpty = true;
      var userNameValue = document.getElementById("userName").value;
      var passwordValue = document.getElementById("password").value;
      if (!userNameValue) {
        document.getElementById("userNameError").innerHTML="userName is required";
        isEmpty = false;
      }
      if (!passwordValue) {
        document.getElementById("passwordError").innerHTML="password is required";
        isEmpty = false;
      }
      if (isEmpty) {
      loginFormObj.submit();
      }
    }
    function clearText1() {
      document.getElementById("userNameError").innerHTML="";
    }
    function clearText2() {
      document.getElementById("passwordError").innerHTML="";
    }
  </script>
  <body>
    <c:if test="${WRONG_MESSAGE != null}">${WRONG_MESSAGE}</c:if>
    <form action="login" method="post" id="loginForm">
      userName:<input type="text" name="userName" id="userName" onchange="clearText1()" />
      <label id="userNameError" class="error"><c:if test="${ERROR_FILED['errorUser'] != null}">${ERROR_FILED['errorUser']}</c:if></label><br>
      password:<input type="password" name="password" id="password" onchange="clearText2()" />
      <label id="passwordError" class="error"><c:if test="${ERROR_FILED['errorPassword'] != null}">${ERROR_FILED['errorPassword']}</c:if></label><br>
      <input type="button" value="Login" onclick="login()" />
    </form>
  </body>
</html>