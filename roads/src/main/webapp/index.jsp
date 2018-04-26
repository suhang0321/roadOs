<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<br>
<head>
    <title>吉林大学后勤物业管理</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/list.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/css.css'/>" />
    <style type="text/css">
        body{
            background-image: url(/images/bgp1.jpg);
            background-size:cover;
        }
    </style>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

    <%--<style type="text/css">--%>
        <%--body {--%>
            <%--background: #15B69A;--%>
            <%--margin: 0px;--%>
            <%--color: #ffffff;--%>
        <%--}--%>
        <%--a {--%>
            <%--text-decoration:none;--%>
            <%--color: #ffffff;--%>
            <%--font-weight: 900;--%>
        <%--}--%>
        <%--a:hover {--%>
            <%--text-decoration: underline;--%>
            <%--color: #ffffff;--%>
            <%--font-weight: 900;--%>
        <%--}--%>
    <%--</style>--%>
</head>

<br>
<h1 style="text-align: center;">吉林大学校园环境数据管理平台</h1>
<br style="font-size: 20pt; line-height: 20px;">
<span style="color:red">${msg}</span></br>
<%--<table>--%>
    <%--<div style="text-align:center;">--%>
    <%--<a href="<c:url value='/jsps/user/adminlogin.jsp'/>" target="_parent">管理员登录</a> &nbsp;&nbsp;&nbsp;&nbsp;--%>
    <%--<a href="<c:url value='/jsps/user/eastlogin.jsp'/>" target="_parent">东区登陆入口</a>&nbsp;&nbsp;&nbsp;&nbsp;--%>
    <%--<a href="<c:url value='/jsps/user/nanhulogin.jsp'/>" target="_parent">南湖登陆入口</a>&nbsp;&nbsp;&nbsp;&nbsp;--%>
    <%--<a href="<c:url value='/jsps/user/westlogin.jsp'/>" target="_parent">西区登陆入口</a>&nbsp;&nbsp;&nbsp;&nbsp;--%>
    <%--<a href="<c:url value='/jsps/user/northlogin.jsp'/>" target="_parent">北区登陆入口</a>&nbsp;&nbsp;&nbsp;&nbsp;--%>
    <%--<a href="<c:url value='/jsps/user/centerlogin.jsp'/>" target="_parent">中心校区(含净月大学创业园 兴城教学基地)登陆入口</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
    <%--<a href="<c:url value='/jsps/user/mingdelogin.jsp'/>" target="_parent">山东明德物业登陆入口</a>&nbsp;&nbsp;&nbsp;--%>
      <%--<a href="<c:url value='/jsps/user/admin2login.jsp'/>" target="_parent">后勤服务集团登录入口</a> &nbsp;&nbsp;&nbsp;&nbsp;--%>
    <%--</div>--%>
<%--</table>--%>

        <table align="center" border="0" width="100%" cellpadding="0" cellspacing="0">
        <tr class="tt">
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </td>
            <td >
                <a href="<c:url value='/jsps/user/adminlogin.jsp'/>" target="_parent">管理员登录</a>&nbsp;&nbsp;
            </td>
            <td >
                <a href="<c:url value='/jsps/user/eastlogin.jsp'/>" target="_parent">东区登录入口</a>&nbsp;&nbsp;
            </td>
            <td >
                <a href="<c:url value='/jsps/user/nanhulogin.jsp'/>" target="_parent">南湖登录入口</a>&nbsp;&nbsp;
            </td>
            <td >
                <a href="<c:url value='/jsps/user/westlogin.jsp'/>" target="_parent">西区登录入口</a>&nbsp;&nbsp;
            </td>
            <td>
                <a href="<c:url value='/jsps/user/northlogin.jsp'/>" target="_parent">北区登录入口</a>&nbsp;&nbsp;
            </td>
            <td>
                <a href="<c:url value='/jsps/user/centerlogin.jsp'/>" target="_parent">中心校区(含净月大学创业园 兴城教学基地)登录入口</a>&nbsp;&nbsp;&nbsp;
            </td>
            <td>
                <a href="<c:url value='/jsps/user/mingdelogin.jsp'/>" target="_parent">山东明德物业登录入口</a>&nbsp;&nbsp;&nbsp;
            </td>
            <td>
                <a href="<c:url value='/jsps/user/admin2login.jsp'/>" target="_parent">后勤服务集团登录入口</a>&nbsp;&nbsp;&nbsp;
            </td>
            <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </td>
        </tr>

            <tr style="padding-top: 10px; padding-bottom: 10px;"class="tt">
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td ></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </table>
</br> </br></br>




    <%--<div style="text-align: center; width: 500px; border: green solid 1px;">--%>
        <%--<img alt="" src="/images/jlu.jpg" style="margin: 0 auto;" />--%>
    <%--</div>--%>

<div style="text-align:center;">
    <img src="/images/jlu.jpg" style="vertical-align:middle;" width="880" height="420" />
</div>

<div  id="footer" style="color: #c1c1c1;text-align:center">CopyRight@JLU Hang.Su </div>
</body>
</html>
