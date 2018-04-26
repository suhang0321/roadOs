<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	/*body {*/
		/*background: #15B69A;*/
		/*margin: 0px;*/
		/*color: #ffffff;*/
	/*}*/
	/*a {*/
		/*text-decoration:none;*/
		/*color: #ffffff;*/
		/*font-weight: 900;*/
	/*}*/
	a:hover {
		text-decoration: underline;
		color: #ffffff;
		font-weight: 900;
	}
</style>
	  <style type="text/css">
		  body{
			  background-image: url(/images/bgp1.gif);
			  background-size:cover;
		  }
	  </style>
  </head>
  
  <body>
<h1 style="text-align: center;">吉林大学后勤资产管理</h1>
<div style="font-size: 10pt; line-height: 10px;">

<%-- 根据用户是否登录，显示不同的链接 --%>
<c:choose>
	<c:when test="${empty sessionScope.sessionUser }">
		  <a href="<c:url value='/index.jsp'/>" target="_parent">选择校区登陆</a> |&nbsp;
		  <%--<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">注册狗宝会员</a>--%>
	</c:when>
	<c:otherwise>
		      管理员用户：${sessionScope.sessionUser.loginname }&nbsp;&nbsp;你好&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="<c:url value='/user/quick.action'/>" target="_parent">退出</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<c:if test="${sessionScope.sessionUser.loginname eq 'admin'}">
			<a href="<c:url value='/adminjsps/admin/main.jsp'/>" target="_top">返回管理信息</a>
		</c:if>
	</c:otherwise>
</c:choose>
</div>
  </body>
</html>
