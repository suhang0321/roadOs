<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>top</title>
	<base target="body">

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
		body {font-size: 10pt;}
		a {color: #aaa;}
	</style>
	<style type="text/css">
		body{
			background-image: url(/images/bgp1.jpg);
			background-size:cover;
		}
	</style>
</head>

<body style="background: rgb(78,78,78);color: #fff;">
<h1 style="text-align: center; line-height: 30px;">校园资产管理后勤处后台管理</h1>
<div style="line-height: 10px;">
	<span>管理员：${sessionScope.sessionUser.loginname }</span>
	<a target="_top" href="<c:url value='/user/quick.action'/>">退出</a>
	<span style="padding-left:50px;">
		<a href="<c:url value='/adminjsps/admin/data/data.jsp'/>">数据的备份还原</a>
		<a href="<c:url value='/log/findLogsAll.action'/>">查看日志</a>
		<a href="<c:url value='/user/findUsersAll.action'/>">用户信息管理</a>
		<a href="<c:url value='/jsps/main.jsp'/>" target="_top">查看校园环境数据</a>
	</span>
</div>
</body>
</html>
