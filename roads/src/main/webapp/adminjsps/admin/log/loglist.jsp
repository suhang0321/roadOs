<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>日志列表</title>
    <script type="text/javascript">
        function findByMulty() {
            document.opertionform.action="<c:url value='/log/findLogsByMulty.action'/>";
            document.opertionform.submit();
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
    <style type="text/css">
        table {
            color: #404040;
            font-size: 10pt;
        }
    </style>
    <style type="text/css">
        body{
            background-image: url(/images/bgp6.jpg);
            background-size:cover;
        }
    </style>
</head>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
<span style="color:red">${msg}</span></br>
<form action="<c:url value=''/>" method="get" name="opertionform" onsubmit="return dosubmit()">
    <table align="center">
        <tr>
            <td>操作：</td>
            <td>
                <select name="l_operation">
                    <option value="">全部操作</option>
                    <option value="修改">修改</option>
                    <option value="添加">添加</option>
                    <option value="删除">删除</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>校区：</td>
            <td>
                <select name="l_block">
                    <option value="">全部校区</option>
                    <option value="east">东区</option>
                    <option value="nanhu">南湖</option>
                    <option value="west">西区</option>
                    <option value="north">北区</option>
                    <option value="center">中心校区</option>
                    <option value="mingde">明德物业</option>
                </select>
            </td>
        </tr>
        <tr>
            <td> 表：</td>
            <td>
                <select name="l_table">
                    <option value="">全部表</option>
                    <option value="柏油马路表">柏油马路表</option>
                    <option value="校园草坪表">校园草坪表</option>
                    <option value="二次供水表">二次供水表</option>
                    <option value="方砖道路表">方砖道路表</option>
                    <option value="花灌木表">花灌木表</option>
                    <option value="果皮箱表">果皮箱表</option>
                    <option value="花卉表">花卉表</option>
                    <option value="假山表">假山表</option>
                    <option value="垃圾桶表">垃圾桶表</option>
                    <option value="路灯表">路灯表</option>
                    <option value="落叶乔木表">落叶乔木表</option>
                    <option value="绿地表">绿地表</option>
                    <option value="绿篱表">绿篱表</option>
                    <option value="常绿乔木表">常绿乔木表</option>
                    <option value="道路清雪表">道路清雪表</option>
                    <option value="其他类土地表">其他类土地表</option>
                    <option value="水系表">水系表</option>
                    <option value="停车场表">停车场表</option>
                    <option value="亭廊表">亭廊表</option>
                    <option value="行道树表">行道树表</option>
                    <option value="甬道表">甬道表</option>
                    <option value="运动场表">运动场表</option>
                    <option value="珍贵树种表">珍贵树种表</option>
                    <option value="自行架表">自行架表</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>
                <input type="submit" value="搜　　索" onclick="findByMulty()"/>
                <input type="reset" value="重新选择"/>
            </td>
        </tr>
    </table>
</form>


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
日志统计表
<table width="100%" border=1>
    <tr>
        <td>时间</td>
        <td>操作</td>
        <td>校区</td>
        <td>操作的表</td>
        <td>操作明细</td>
    </tr>
    <c:forEach items="${itemsList}" var="item">
        <tr>
            <td>${item.l_time}</td>
            <td>${item.l_operation} </td>
            <td>
                <c:choose>
                    <c:when test="${item.l_block eq 'east'}">东区</c:when>
                    <c:when test="${item.l_block eq 'nanhu'}">南湖</c:when>
                    <c:when test="${item.l_block eq 'west'}">西区</c:when>
                    <c:when test="${item.l_block eq 'north'}">北区</c:when>
                    <c:when test="${item.l_block eq 'center'}">中心校区</c:when>
                    <c:when test="${item.l_block eq 'mingde'}">明德物业</c:when>
                </c:choose>
            </td>
            <td>${item.l_table} </td>
            <td>${item.l_content} </td>
        </tr>
    </c:forEach>

</table>
<div style="float:left; width: 100%; text-align: center;">
    <hr/>
    <br/>
    <%@include file="/jsps/pager/pager.jsp" %>
</div>


</body>
</html>