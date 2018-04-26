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
    <title>add</title>
    <script type="text/javascript">
        function huanyuanSubmit() {
            document.itemsform.action="<c:url value="/data/huanyuanSubmit.action"/>";
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
    <style type="text/css">
        body{
            background-image: url(/images/bgp1.jpg);
            background-size:cover;
        }
    </style>
</head>
<br>
<form action=""   onsubmit="return dosubmit()" method="post" name="itemsform">
    <span style="color:red">${msg}</span></br>
    <span style="color:red">还原文件按距今时间由近到远排列，即下拉列表中最靠上的文件为最新的备份数据</span></br>

    <table>
        <tr>
            <td colspan="3">
                选择还原文件：　　
            <select name="huanyuanfile">
                <c:forEach items="${itemsList}" var="item">
                    <c:choose>
                    <c:when test="${item eq '.DS_Store'}">
                    </c:when>
                        <c:when test="${item eq 'DS_Store'}">
                        </c:when>
                    <c:otherwise>
                        <option value="${item}">${item}</option>
                    </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            </td>
        </tr>
    </table>
</form>
<input type="button" value="确认还原" onclick="huanyuanSubmit()"/>
<input type="button" value="返回" onclick="history.go(-1)"/>
</br>
<span style="color:red">注：还原文件的命名是备份该文件的时间，如20180424105020 表示将数据还原到2018年4月24日上午10点50分20秒时的数据</span></br>
</body>
</html>
