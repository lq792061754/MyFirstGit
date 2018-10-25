<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<style>
.txt{
    width:150px;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
}
</style>
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
<!--HEADER-->
<div class="header">
	<div class="mar1000 clearfix">
        <div class="logo"></div>
        <div class="header_right">
            <div class="homeinfo">
                <label><span>免费预订电话：<strong>400-0559-700</strong></span>&nbsp;&nbsp;&nbsp;&nbsp;|</label>
                <label><a href="">会员登录</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;|</label>
                <label><a href="">设为首页</a></label>
            </div>
            <div class="nav">
                <a href="" class="hover">首  页</a>
                <a href="">温泉预定</a>
                <a href="">酒店预定</a>
                <a href="">醉悦旅居</a>
                <a href="">养生餐饮</a>
                <a href="">会议中心</a>
                <a href="">促销活动</a>
                <a href="">企业文化</a>
            </div>
        </div>
    </div>
</div>
<!--HEADER-->


<!--BIG PIC-->
<div class="banners">
&nbsp;
</div>
<!--BIG PIC-->


<!--CONTENT-->
<div class="content">
	<div class="mar1000 clearfix">
    	
        
		<div class="lefts">
        	<div class="tree">
            	<label>促销活动</label>
                <a href="" class="hover">促销活动</a>
                <a href="">促销活动</a>
                <a href="">促销活动</a>
            </div>
        </div>
      <div class="rights">
      		<div class="path path_nomar"><label>促销活动</label><span>当前位置：首页 &gt; 促销活动</span></div>
      <c:forEach items="${pageUtil.list }" var="list">
        	<div class="news_item">
            	<a href="ArtDetail?id=${list.id }"><img src="${list.newspic }" width="180" height="122"  alt=""/></a>
            	<div class="news_info">
                	<h2><span>${list.time }</span><a href="ArtDetail?id=${list.id }">${list.newsname }</a></h2>
                    <p class="txt">${list.content }</p>
                </div>
            </div>           
          </c:forEach>
            <div class="page">
            <c:choose> 
            <c:when test="${pageUtil.pageNumber == 0 }">    <!--如果 --> 
               <h5>当前还没有留言信息...</h5>
            </c:when>      
            <c:otherwise>  <!--否则 -->    
                                              共${pageUtil.pageNumber}条,当前第<span><strong><font color="red" size="3px">${pageUtil.pageIndex}</font></strong></span>页
               
            <c:choose> 
            <c:when test="${pageUtil.pageNumber <= 5}">    <!--如果 -->              
            </c:when>
             <c:otherwise>
               <a href="${pageContext.request.contextPath}/ShowArt?pIndex=1">首页</a> 
                <a href="${pageContext.request.contextPath}/ShowArt?pIndex=${pageUtil.pageIndex>1?pageUtil.pageIndex-1:1}">上一页</a>
                <c:forEach begin="1" end="${pageUtil.pageCount}" var="i">  
                <a href="${pageContext.request.contextPath}/ShowArt?pIndex=${i}" class="btn">${i}</a>
                </c:forEach>
                    <a href="${pageContext.request.contextPath}/ShowArt?pIndex=${pageUtil.pageIndex<pageUtil.pageCount?pageUtil.pageIndex+1:pageUtil.pageCount}">下一页</a>
                <a href="${pageContext.request.contextPath}/ShowArt?pIndex=${pageUtil.pageCount}">末页</a>            
             </c:otherwise>
            </c:choose>              
            </c:otherwise> 
            </c:choose>
</div>
            
        </div>
    </div>
</div>
<!--CONTENT-->


<!--FOOTER-->
<div class="bottom">
<a href="">网站首页</a>|
<a href="">温泉预定</a>|
<a href="">酒店预定</a>|
<a href="">醉悦旅居</a>|
<a href="">养生餐饮</a>|
<a href="">会议中心</a>|
<a href="">促销活动</a>|
<a href="">企业文化</a>
</div>
<div class="footer">
地址：黄山市屯溪区花山路新徽天地醉温泉国际度假城&nbsp;&nbsp;&nbsp;&nbsp;邮编:236010<br/>
电话：0559-2536999&nbsp;&nbsp;2568666&nbsp;&nbsp;&nbsp;&nbsp;免费预订电话：400-0559-700<br/>
Copyright &copy; 2003-2014  黄山 &middot; 醉温泉&nbsp;&nbsp;All rights reserved.&nbsp;&nbsp;皖ICP备11009137号
</div>
<!--FOOTER-->
</body>
</html>