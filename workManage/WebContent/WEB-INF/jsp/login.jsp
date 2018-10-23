<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>登录页面</title>
        <script src="js/jquery.min.js"></script>
		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/font-awesome/4.2.0/css/font-awesome.min.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="assets/fonts/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.min.css" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
	</head>
<script type="text/javascript">
 function sub(){
	   var uValue = document.getElementById("username").value;
	   var pValue = document.getElementById("password").value;
	     if(uValue == "" || pValue == ""){
				 alert("用户名或密码不能为空，请重新输入");
				 return false;
		}	
	     var inputCode = document.getElementById("input1").value.toUpperCase();
	     if (inputCode.length <= 0) {
	         alert("请输入验证码！");
	         return false;
	     } else if (inputCode != code) {
	         alert("验证码输入错误！");
	         createCode();
	         return false;
	     } else {
	         return true;
	     }
   }
 
 window.onload=function(){
	 createCode();
	 if('${FLAG}' == 1){
		 alert("用户名或密码错误");
	     window.location='login';
	     }	 
   }

</script>
	<body class="login-layout light-login">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<span class="red"><img src="images/logo.jpg"></span>
								</h1>
								<h4 class="blue" id="id-company-text">排班信息管理系统</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-lock green"></i>
												请输入您的登录信息
											</h4>

											<div class="space-6"></div>

											<form  action="loginCheck"  method="post" onsubmit="return sub()">
												<fieldset>
												<label class="inline" style="margin-right:30px;">
	                                                    <input type="radio" name="radio" id="radio" value="1" class="ace" checked><span class="lbl"> 管理员登录</span>
                                                    </label>
                                                    <label class="inline">
                                                        <input type="radio" name="radio" id="radio" value="2" class="ace" ><span class="lbl"> 用户登录</span>
                                                    </label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="username" name="loginName" type="text" class="form-control" placeholder="用户名" />
															<i class="ace-icon fa fa-user"></i>
													  </span>
												  </label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="password" name="pwd" type="password" class="form-control" placeholder="密码" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label> 
													
													<label class="block clearfix">
													<span class="block input-icon input-icon-right">
													<input type="text" id="input1" placeholder="请输入验证码"> <input
													type="button" id="checkCode"
													style="width: 60px" onclick="createCode()">
                                                     </span>
													</label>
													<script>
var code; //在全局 定义验证码
function createCode() {
    code = new Array();
    var codeLength = 4; //验证码的长度
    var checkCode = document.getElementById("checkCode");
    checkCode.value = "";
    var selectChar = new Array(2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
    for (var i = 0; i < codeLength; i++) {
        var charIndex = Math.floor(Math.random() * 32);
        code += selectChar[charIndex];
    }
    if (code.length != codeLength) {
        createCode();
    }
    checkCode.value = code;
}
</script>
												<div class="space"></div>

													<div class="clearfix">
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													&nbsp;&nbsp;&nbsp;
											            <button type="submit" >
															<span class="bigger-110">登录</span>
														</button>
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<button type="reset" >
															<span class="bigger-110">重置</span>
														</button>
														
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>											
										</div>
									</div>
								</div>
							</div>	
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--[if !IE]> -->
		<script src="assets/js/jquery.2.1.1.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets/js/jquery.1.11.1.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
	</body>
</html>
