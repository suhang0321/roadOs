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
        function addItem() {
            document.itemsform.action="<c:url value="/xingdao/addXingDao.action"/>";
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
</head>
<body>
<h1>行道树添加页面</h1>

<form action="<c:url value="/xingdao/addXingDao.action"/>" name="itemsform" onsubmit="return dosubmit()" method="post">
    <table>
        <tr>
            <td colspan="3">
                符 号：　　<input type="text"  name="xd_logo"  style="width:150px;"/>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                名  称：　　<input type="text"  name="xd_name"  style="width:150px;"/>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                位 置：　　<input type="text"  name="xd_location"  style="width:150px;"/>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                方 向：　　<select name="xd_direction">
                <option value="error">====请选择方向====</option>
                <option value="东西">东西</option>
                <option value="南北">南北</option>
                <option value="其他">其他</option>
            </select>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                品 种：　　<select name="xd_kind">
                <option value="error">====请选择行道树品种====</option>
                <option value="柳树">柳树</option>
                <option value="杨树">杨树</option>
                <option value="垂榆">垂榆</option>
                <option value="杏树">杏树</option>
                <option value="黑松">黑松</option>
                <option value="梓树">梓树</option>
                <option value="稠李">稠李</option>
                <option value="水曲柳">水曲柳</option>
                <option value="樟子松">樟子松</option>
                <option value="黄波萝">黄波萝</option>

            </select>
            </td>
        </tr>
            <td colspan="3">
                数 量：　　<input type="text"  name="xd_num"  style="width:150px;"/>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                年 代：　　<input type="text"  name="xd_year"  style="width:150px;"/>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                校 区：　　<select name="xd_block">
                <option value="error">============请选择校区============</option>
                <option value="center"  >中心校区(包含净月大学生创业园和兴城教学基地)</option>
                <option value="east">东区</option>
                <option value="north">北区</option>
                <option value="west">西区</option>
                <option value="nanhu">南湖校区</option>
                <option value="mingde">山东明德物业</option>

            </select>
            </td>
        </tr>
    </table>
</form>
<input type="button" value="添加新数据" onclick="addItem()"/>
<input type="button" value="取消" onclick="history.go(-1)"/>
</body>
</html>
