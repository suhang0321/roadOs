
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>edit</title>
    <script type="text/javascript">
        function editeItemsListSubmit() {
            document.itemsform.action="<c:url value="/caoping/editCaoPingsSubmit.action"/>";
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

<form name="itemsform"  onsubmit="return dosubmit()" method="post" action="<c:url value="/caoping/editCaoPingsSubmit.action"/>">
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
    <c:forEach items="${itemsList}" var="item" varStatus="Status">
        <tr>
            <input type="hidden" name="itemsList[${Status.index}].cp_id" value="${item.cp_id}"/>
            <td><input type="text" name="itemsList[${Status.index}].cp_logo" value="${item.cp_logo}"/></td>
            <td><input type="text" name="itemsList[${Status.index}].cp_name" value="${item.cp_name}"/></td>
            <td><input type="text" name="itemsList[${Status.index}].cp_location" value="${item.cp_location}"/></td>
            <td><input type="text" name="itemsList[${Status.index}].cp_direction" value="${item.cp_direction}"/></td>
            <td><input type="text" name="itemsList[${Status.index}].cp_length" value="${item.cp_length}"/></td>
            <td><input type="text" name="itemsList[${Status.index}].cp_width" value="${item.cp_width}"/></td>
            <td><input type="text" name="itemsList[${Status.index}].cp_area" value="${item.cp_area}"/></td>
            <input type="hidden" name="itemsList[${Status.index}].cp_block" value="${item.cp_block}"/>
        </tr>
    </c:forEach>
</table>
</form>
<div style="float:left; width: 100%; text-align: center;">
    <hr/>
    <br/>
    <%@include file="/jsps/pager/pager.jsp" %>
</div>
<input type="button" value="批量修改提交" onclick="editeItemsListSubmit()"/>
<input type="button" value="取消" onclick="history.go(-1)"/>


</body>
</html>
