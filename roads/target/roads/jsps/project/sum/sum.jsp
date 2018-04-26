<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>list</title>


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
校园数据汇总表
<table width="100%" border=1>
    <tr>
        <td>序号</td>
        <td>名称</td>
        <td>数量</td>
        <td>面积</td>
        <td>类别</td>
        <td>备注</td>
    </tr>
        <tr>
            <td>1</td>
            <td>沥青道路</td>
            <td>${baiyounum}条</td>
            <td>${baiyouarea}㎡</td>
            <td></td>
            <td></td>
        </tr>
    <tr>
        <td>2</td>
        <td>方砖道路</td>
        <td>${fangzhuannum}条</td>
        <td>${fangzhuanarea}㎡</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>3</td>
        <td>甬路</td>
        <td>${yongdaonum}条</td>
        <td>${yongdaoarea}㎡</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>4</td>
        <td>草坪</td>
        <td>${caopingnum}块</td>
        <td>${caopingarea}㎡</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>5</td>
        <td>绿地</td>
        <td>${lvdinum}块</td>
        <td>${lvdiarea}㎡</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>6</td>
        <td>常绿乔木</td>
        <td>${qiaomunum}棵</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>7</td>
        <td>落叶乔木</td>
        <td>${luoyenum}棵</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>8</td>
        <td>行道树</td>
        <td>${xingdaoshunum}棵</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>9</td>
        <td>灌木</td>
        <td>${guanmunum}株</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>10</td>
        <td>应季花卉</td>
        <td>${huahuinum}棵</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>11</td>
        <td>自行车架</td>
        <td>${zixingjianum}个</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>12</td>
        <td>果皮箱</td>
        <td>${guopixiangnum}个</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>13</td>
        <td>建筑物占地面积</td>
        <td>㎡</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>14</td>
        <td>垃圾桶</td>
        <td>${lajinum}个</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>15</td>
        <td>假山</td>
        <td>${jiashannum}个</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>16</td>
        <td>亭廊</td>
        <td>${tinglangnum}个</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>17</td>
        <td>2017年道路清雪</td>
        <td>${qingxuenum}处</td>
        <td>${qingxueunit}㎡</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>18</td>
        <td>水系</td>
        <td>${shuixinum}处</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>19</td>
        <td>珍贵树种</td>
        <td>${zhenguinum}棵</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>20</td>
        <td>二次供水</td>
        <td>${ercinum}处</td>
        <td>${erciunit}㎡</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>21</td>
        <td>绿篱</td>
        <td>${lvlinum}M</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>22</td>
        <td>停车场</td>
        <td>${tingchenum}处</td>
        <td>${tingcheunit}㎡</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>23</td>
        <td>运动场</td>
        <td></td>
        <td>${yundongunit}㎡</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>24</td>
        <td>荒地</td>
        <td>㎡</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>25</td>
        <td>裸地</td>
        <td>㎡</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
</table>

</body>
</html>