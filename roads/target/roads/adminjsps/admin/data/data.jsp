<%--
  Created by IntelliJ IDEA.
  User: suhang
  Date: 2018/4/9
  Time: 下午6:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>data</title>
    <script type="text/javascript">
        function beifen() {
            document.itemsform.action="<c:url value="/data/beifen.action"/>";
            document.itemsform.submit();
        }
    </script>
    <script type="text/javascript">
        function huanyuan() {
            document.itemsform.action="<c:url value="/data/huanyuan.action"/>";
            document.itemsform.submit();
        }
    </script>
    <style type="text/css">
        body{
            background-image: url(/images/bgp2.jpg);
            background-size:cover;
        }
    </style>
</head>
<body>
<form  method="post" name="itemsform">
</form>
<span style="color:red">${msg}</span></br>

<input type="button" value="备份当前数据" onclick="beifen()"/>
<input type="button" value="还原" onclick="huanyuan()"/>
</body>
</html>
