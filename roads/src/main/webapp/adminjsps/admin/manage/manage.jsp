<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>manage</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/jsps/pager/pager.css'/>" />
    <script type="text/javascript" src="<c:url value='/jsps/pager/pager.js'/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/list.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/css.css'/>" />
    <style type="text/css">
        body{
            background-image: url(/images/bgp1.jpg);
            background-size:cover;
        }
    </style>
</head>

<body>
<div style="text-align:center;">
</div>
<span style="color:red">${msg}</span></br>
<div class="divMain">
    <br/>
    <table align="center" border="0" width="100%" cellpadding="0" cellspacing="0">
        <tr style="padding-top: 10px; padding-bottom: 10px; font-size: 17px">
            <td colspan="2" width="50" height="60">管理员id</td>
            <td width="115px">
                <span >管理员用户名</span>
            </td>
            <td width="142px">
                管理员密码
            </td>
            <td>
                操作
            </td>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr class="tt">
                <td width="320px">管理员id：${user.uid}</td>
                <td width="200px">所属校区：
                    <c:if test="${user.block eq 'admin'}">总管理员</c:if>
                    <c:if test="${user.block eq 'east'}">东区</c:if>
                    <c:if test="${user.block eq 'nanhu'}">南湖</c:if>
                    <c:if test="${user.block eq 'west'}">西区</c:if>
                    <c:if test="${user.block eq 'north'}">北区</c:if>
                    <c:if test="${user.block eq 'center'}">中心校区(含净月大学创业园和兴城教学基地)</c:if>
                    <c:if test="${user.block eq 'mingde'}">明德物业</c:if>
                    <c:if test="${user.block eq 'admin2'}">后勤服务集团</c:if>
                </td>
                <td width="178px">&nbsp;</td>
                <td width="205px">&nbsp;</td>
                <td>&nbsp;</td>

            </tr>

            <tr style="padding-top: 10px; padding-bottom: 10px;">
                <td colspan="2">
                            <img border="0" width="70" src="${user.head}"/>
                </td>
                <td width="115px">
                    <span class="price_t">${user.loginname }</span>
                </td>
                <td width="142px">
                    ${user.loginpass}
                </td>
                <td>
                   <c:choose>
                       <c:when test="${user.uid eq '1'}">
                           —
                       </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/user/getUid.action?uid=${user.uid}'/>">修改密码</a><br/>
                    </c:otherwise>
                   </c:choose>
                </td>
            </tr>
        </c:forEach>

    </table>
    <br/>
</div>
</body>
</html>
