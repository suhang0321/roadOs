<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>校园假山列表</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/jsps/pager/pager.css'/>" />
    <script type="text/javascript" src="<c:url value='/jsps/pager/pager.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
</head>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
<span style="color:red">${msg}</span></br>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
假山统计表
<table width="100%" border=1 >
    <tr>
        <td>符号</td>
        <td>名称</td>
        <td>位置</td>
        <td>单位</td>
        <td>类别</td>
        <td>数量</td>
        <td>年代</td>
    </tr>
    <c:forEach items="${itemsList}" var="item">
        <tr >
            <td>${item.js_logo}</td>
            <td>${item.js_name} </td>
            <td>${item.js_location} </td>
            <td>${item.js_unit} </td>
            <td>${item.js_type} </td>
            <td>${item.js_num} </td>
            <td>${item.js_year} </td>
        </tr>
    </c:forEach>

</table>
<div style="float:left; width: 100%; text-align: center;">
    <hr/>
    <br/>
    <%@include file="/jsps/pager/pager.jsp" %>
</div>
<c:choose><c:when test="${user.block eq 'admin'}">
    <a href="<c:url value="/jiashan/deleteJiaShans.action" />">删除页面</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="<c:url value="/jiashan/editJiaShans.action"/>">编辑页面</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="<c:url value="/jsps/project/jiashan/jiashanadd.jsp"/>">添加假山页面</a>
</c:when></c:choose>

</body>
</html>