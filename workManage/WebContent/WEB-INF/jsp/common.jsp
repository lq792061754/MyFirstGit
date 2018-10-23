<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#time{
     color:red;
	 height:30px;
	 line-height:30px;
	 font-size:18px;
	 width:400px;
	 text-align:center;
	 margin:0 auto;
	 }
</style>
</head>
<body>
	<div id="wrapper">

		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
	
	<!-- 头部布局  -->		
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
			<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home">后台管理系统 v1.0</a>
		</div>
		<ul class="nav navbar-top-links navbar-right">
        <li><br><font color="black">&nbsp;&nbsp;欢迎您！&nbsp;${USERNAME }</font></li>	
		<li><div id="time"></div>
	<script type="text/javascript"> 
	 setInterval(function(){
		  var time=new Date();
		  var year=time.getFullYear();  //获取年份
		  var month=time.getMonth()+1;  //获取月份
		  var day=time.getDate();   //获取日期
		  var hour=checkTime(time.getHours());   //获取时
		  var minite=checkTime(time.getMinutes());  //获取分
		  var second=checkTime(time.getSeconds());  //获取秒
		  /****当时、分、秒、小于10时，则添加0****/
		  function checkTime(i){
			  if(i<10) return "0"+i;
			  return i;
		  }
		  var box=document.getElementById("time");
		  box.innerHTML="当前日期："+year+"年"+month+"月"+day+"日  "+hour+":"+minite+":"+second;		  
		},1000);     //setInterval(fn,i) 定时器，每隔i秒执行fn
</script>
</li>
		</ul>

<!-- 导航栏  -->
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					
					<li><a href="allUser"><i
							class="fa fa-dashboard fa-fw"></i>人员管理</a></li>
					<li><a href="allDuty"><i
							class="fa fa-dashboard fa-fw"></i>排班管理</a></li>
					<li><a href="allDuty3"><i
							class="fa fa-dashboard fa-fw"></i>排班查询</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
</body>
</html>