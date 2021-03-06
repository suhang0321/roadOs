<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>校园草坪列表</title>
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
校园草坪统计表
<table width="100%" border=1>
    <tr>
        <td>符号</td>
        <td>名称</td>
        <td>位置</td>
        <td>方向</td>
        <td>长度</td>
        <td>宽度</td>
        <td>面积</td>
    </tr>
    <c:forEach items="${itemsList}" var="item">
        <tr>
            <td>${item.cp_logo}</td>
            <td>${item.cp_name} </td>
            <td>${item.cp_location} </td>
            <td>${item.cp_direction} </td>
            <td>${item.cp_length} </td>
            <td>${item.cp_width} </td>
            <td>${item.cp_area} </td>
        </tr>
    </c:forEach>

</table>
<div style="float:left; width: 100%; text-align: center;">
    <hr/>
    <br/>
    <%@include file="/jsps/pager/pager.jsp" %>
</div>
<c:choose>
    <c:when test="${user.block eq'admin'}">
        <a href="<c:url value="/caoping/deleteCaoPings.action" />">删除页面</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="<c:url value="/caoping/editCaoPings.action"/>">编辑页面</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="<c:url value="/jsps/project/caoping/caopingadd.jsp"/>">添加校园草坪页面</a>
    </c:when>
</c:choose>
</body>
</html>