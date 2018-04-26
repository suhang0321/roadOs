
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>delete</title>
    <script type="text/javascript">
    function deleteItems() {
    document.itemsform.action="<c:url value="/erci/deleteErCisSubmit.action"/>";
    document.itemsform.submit();
    }
    </script>
    <script type="text/javascript">
        var isCommitted = false;//表单是否已经提交标识，默认为false
        function dosubmit(){
            if(isCommitted==false){
                isCommitted = true;//提交表单后，将表单是否已经提交标识设置为true
                return true;//返回true让表单正常提交
            }else{
                return false;//返回false那么表单将不提交
            }
        }
    </script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/jsps/pager/pager.css'/>" />
    <script type="text/javascript" src="<c:url value='/jsps/pager/pager.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
</head>
<body>
&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
<span style="color:red">${msg}</span>
<form name="itemsform"   onsubmit="return dosubmit()" method="post"action="<c:url value=""/>">
<table width="100%" border=1>
    <tr>
        <td>选择</td>
        <td>符号</td>
        <td>名称</td>
        <td>位置</td>
        <td>单位</td>
        <td>类别</td>
        <td>数量</td>
        <td>年代</td>
    </tr>
    <c:forEach items="${itemsList}" var="item" varStatus="Status">
        <tr>
            <%--<input type="hidden" name="itemsList[${Status.index}].by_id" value="${item.by_id}"/>--%>
            <td><input type="checkbox" name="sj_id" value="${item.sj_id}"/></td>
                <td><input type="text" name="itemsList[${Status.index}].sj_logo" value="${item.sj_logo}"/></td>
            <td><input type="text" name="itemsList[${Status.index}].sj_name" value="${item.sj_name}"/></td>
                <td><input type="text" name="itemsList[${Status.index}].sj_location" value="${item.sj_location}"/></td>
                <td><input type="text" name="itemsList[${Status.index}].sj_unit" value="${item.sj_unit}"/></td>
            <td><input type="text" name="itemsList[${Status.index}].sj_type" value="${item.sj_type}"/></td>
            <td><input type="text" name="itemsList[${Status.index}].sj_num" value="${item.sj_num}"/></td>
            <td><input type="text" name="itemsList[${Status.index}].sj_year" value="${item.sj_year}"/></td>
            <input type="hidden" name="itemsList[${Status.index}].sj_block" value="${item.sj_block}"/>
        </tr>
    </c:forEach>
</table>
</form>
<div style="float:left; width: 100%; text-align: center;">
    <hr/>
    <br/>
    <%@include file="/jsps/pager/pager.jsp" %>
</div>
<input type="button" value="删除选中项" onclick="deleteItems()"/>
<input type="button" value="取消" onclick="history.go(-1)"/>

</body>
</html>
