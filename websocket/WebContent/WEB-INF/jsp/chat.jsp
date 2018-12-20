<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>web聊天室</title>
<script type="text/javascript">
      var websocket = null;
      //判断当前浏览器是否支持WebSocket
      if('WebSocket' in window){
          websocket = new WebSocket("ws://localhost:8080/websocket/mychat");
      }
      else{
          alert('浏览器不支持 ！')
      }

      websocket.onerror = function(){
          setMessageInnerHTML("连接失败！");
      };

      //连接成功建立的回调方法 
      websocket.onopen = function(event){
          alert("登录成功,欢迎加入聊天室！");
      }

      //接收到消息的回调方法 
      websocket.onmessage = function(event){
          //分割字符串为三段
          var arr = event.data.split("|", 3);
          setMessageInnerHTML('<div style="float:left;margin-left:4px"><img style="border-radius:50%" src="images/head.jpg"></div>'
          +'<div style="font-family:楷体; background-color: #FFEC8B;width:790px; height:50px;'
          +'border: 1px dashed orange; border-radius: 3px; line-height:50px; margin-left:4px">'
          +arr[0] +':&nbsp;&nbsp;'+arr[1]+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
          +'<div style="float:right; margin-right:3px; color:#EE2C2C; font-family:宋体">'+arr[2]+'</div>'+ '</div><br>');
      }

      //连接关闭的回调方法 
      websocket.onclose = function(){
          var username=document.getElementById('username').value;
          setMessageInnerHTML(username+" 退出了聊天室！");
      }
      //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。 
      window.onbeforeunload = function(){
          websocket.close();
      }

      //将消息显示在网页上  
      function setMessageInnerHTML(innerHTML){
          document.getElementById('message').innerHTML += innerHTML;
      }

      //关闭连接 
      function closeWebSocket(){
          websocket.close();
      }

      //发送消息 
      function send(){
          var id = document.getElementById('id').value;
          var username=document.getElementById('username').value;
          var message = document.getElementById('text').value;
          websocket.send(id+":"+username+":"+message);
          //发送消息后，发送消息框自动清空
          document.getElementById('text').value="";
      }
  </script>
</head>
<body>
         <div class="container" style="text-align: center">
         <h1 style="text-align: center; color: blue">聊天室 </h1>
           <div id="message" style="width:800px; height:400px; border: 3px solid #E5EEFF; margin-left: 280px;
            text-align: left; overflow: auto">
           </div>
    <input id="id" type="hidden" value="${ID }" />
昵称： <input id="username" type="text" value="${USERNAME }" readonly="readonly" />
内容： <input id="text" type="text" style="width:320px"/>
        <button onclick="send()" style="background-color: #BCD2EE; border-radius: 3px;
        border-color: #BCD2EE">发送</button>
        <button onclick="closeWebSocket()" style="background-color: #CD3700; border-radius: 3px;
        border-color: #CD3700">退出</button>
        </div>
</body>
</html>