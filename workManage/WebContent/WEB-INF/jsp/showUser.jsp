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
    /*批量删除  */
    function deleteItems() {
        var cks = document.getElementsByName("items_id");
        var items_id = "";
        var j = 0; //记录所选条目
        //拼接所有的items_id
        for (var i = 0; i < cks.length; i++) {
            if (cks[i].checked) {
                items_id += "items_id=" + cks[i].value + "&";
                j++;
            }
        }
        var sure = window.confirm("确定要批量删除" + j + "个用户吗？");
        if (!sure) {
            return;
        }
        //去掉字符串末尾的‘&’
        items_id = items_id.substring(0, items_id.length - 1);
        location.href = "${pageContext.request.contextPath }/deleteItems.action?"
                + items_id;
    }
</script>
<body>
<jsp:include  page="common.jsp"/> 

<!-- 中间布局  -->
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">人员管理</h1>
				</div>
			</div>		
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">当前位置><strong>人员信息列表</strong>
						<form action="findUser" method="post">
						姓名：<input type="text" name="userName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						手机号码：<input type="text" name="tel">
						<input type="submit" value="查询">
						</form><br>
						<button><a href="add"><font color="black">添加人员</font></a></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button onclick="deleteItems()">批量删除</button>
						</div>						
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
								    <th>选项</th>
									<th>序号</th>
									<th>用户名</th>
									<th>姓名</th>
									<th>手机号码</th>
									<th>职务</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="content_page">
								<c:forEach items="${pageUtil.list}" var="list">
									<tr>
									<td><input name="items_id" type="checkbox" value="${list.id}"/></td>
										<td>${list.id}</td>
										<td>${list.loginName}</td>
										<td>${list.userName}</td>
										<td>${list.tel}</td>
										<td>${list.job}</td>
										<td>
										<a href="oneUser?id=${list.id}" class="btn btn-primary btn-xs">修改</a> 
										<a href="javascript:if(confirm('确实要删除该用户吗?')){location='deleteUser?id=${list.id}'}" class="btn btn-danger btn-xs">删除</a>
										</td>
									</tr>
								</c:forEach>															
							</tbody>
						</table>
					</div>
			</div>
			</div>
			<c:choose> 
            <c:when test="${pageUtil.pageNumber == 0 }">    <!--如果 --> 
               <h5>当前还没有人员信息...</h5>
            </c:when>      
            <c:otherwise>  <!--否则 -->    
                                              共${pageUtil.pageNumber}条,当前第<span><strong><font color="red" size="3px">${pageUtil.pageIndex}</font></strong></span>页
               
            <c:choose> 
            <c:when test="${pageUtil.pageNumber <= 4}">    <!--如果 -->              
            </c:when>
             <c:otherwise>
               <a href="${pageContext.request.contextPath}/allUser?pIndex=1">首页</a> 
                <a href="${pageContext.request.contextPath}/allUser?pIndex=${pageUtil.pageIndex>1?pageUtil.pageIndex-1:1}">上一页</a>
                <c:forEach begin="1" end="${pageUtil.pageCount}" var="i">  
                <a href="${pageContext.request.contextPath}/allUser?pIndex=${i}" class="btn">${i}</a>
                </c:forEach>
                    <a href="${pageContext.request.contextPath}/allUser?pIndex=${pageUtil.pageIndex<pageUtil.pageCount?pageUtil.pageIndex+1:pageUtil.pageCount}">下一页</a>
                <a href="${pageContext.request.contextPath}/allUser?pIndex=${pageUtil.pageCount}">末页</a>            
             </c:otherwise>
            </c:choose>              
            </c:otherwise> 
            </c:choose>
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