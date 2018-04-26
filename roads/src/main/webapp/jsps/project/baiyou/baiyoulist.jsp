<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>柏油马路列表</title>
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
校园柏油马路统计表
<table width="100%" border=1>
    <tr>
        <td>符号</td>
        <td>道路名称</td>
        <td>方向</td>
        <td>长度</td>
        <td>宽度</td>
        <td>面积</td>
    </tr>
    <c:forEach items="${itemsList}" var="item">
        <tr>
            <td>${item.by_logo}</td>
            <td>${item.by_name} </td>
            <td>${item.by_direction} </td>
            <td>${item.by_length} </td>
            <td>${item.by_width} </td>
            <td>${item.by_area} </td>
        </tr>
    </c:forEach>

</table>
<div style="float:left; width: 100%; text-align: center;">
    <hr/>
    <br/>
    <%@include file="/jsps/pager/pager.jsp" %>
</div>
<%--<c:when test="${user.block eq block}"><a href="<c:url value="/baiyou/deleteBaiYous.action" />">删除页面</a></c:when>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
<c:choose>
    <c:when test="${user.block eq 'admin'}">
        <a href="<c:url value="/baiyou/deleteBaiYous.action" />">删除页面 </a>&nbsp;&nbsp;&nbsp;
        <a href="<c:url value="/baiyou/editBaiYou.action"/>"> 编辑页面 </a>&nbsp;&nbsp;&nbsp;
        <a href="<c:url value="/jsps/project/baiyou/baiyouadd.jsp"/>"> 添加新增柏油马路页面</a>
    </c:when>
</c:choose>
<%--<a href="<c:url value="/baiyou/editBaiYou.action"/>">编辑页面</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--<a href="<c:url value="/jsps/project/baiyou/baiyouadd.jsp"/>">添加新增柏油马路页面</a>--%>

</body>
</html>