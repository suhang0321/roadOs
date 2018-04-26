<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <br>
    <title>left</title>
  <style type="text/css">
      body{
          background-image: url(/images/bgp1.jpg);
          background-size:cover;
      }
  </style>
    <base target="body"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/menu/mymenu.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='/menu/mymenu.css'/>" type="text/css" media="all">
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/left.css'/>">
<%--<script language="javascript">--%>
<%--var bar = new Q6MenuBar("bar", "信息列表");--%>
<%--$(function() {--%>
	<%--bar.colorStyle = 2;//指定配色样式，一共0,1,2,3,4--%>
	<%--bar.config.imgDir = "<c:url value='/menu/img/'/>";//小工具所需图片的路径--%>
	<%--bar.config.radioButton=true;//是否排斥，多个一级分类是否排斥--%>
    <%--bar.add("校园柏油马路", "查询柏油马路信息", "/roads/baiyou/findBaiyousByBlock.action", "body");--%>
    <%--bar.add("方砖道路", "查询方砖道路信息", "/roads/fangzhuan/findFangZhuansByBlock.action", "body");--%>
    <%--bar.add("校园甬道", "查询甬道信息", "/roads/yongdao/findYongDaosByBlock.action", "body");--%>
    <%--bar.add("校园草坪", "查询草坪信息", "/roads/caoping/findCaoPingsByBlock.action", "body");--%>
    <%--bar.add("校园绿地", "查询绿地信息", "/roads/lvdi/findLvDisByBlock.action", "body");--%>
    <%--bar.add("校园行道树", "查询行道树信息", "/roads/xingdao/findXingDaosByBlock.action", "body");--%>
    <%--bar.add("校园常绿乔木", "查询常绿乔木信息", "/roads/qiaomu/findQiaoMusByBlock.action", "body");--%>
    <%--bar.add("校园落叶乔木", "查询落叶乔木信息", "/roads/luoye/findLuoYesByBlock.action", "body");--%>
    <%--bar.add("花灌木", "查询花灌木信息", "/roads/guanmu/findGuanMusByBlock.action", "body");--%>
    <%--bar.add("花卉", "查询花卉信息", "/roads/huahui/findHuaHuisByBlock.action", "body");--%>
    <%--bar.add("自行架", "查询自行架信息", "/roads/zixingjia/findZiXingJiasByBlock.action", "body");--%>
    <%--bar.add("果皮箱", "查询果皮箱信息", "/roads/guopixiang/findGuoPiXiangsByBlock.action", "body");--%>
    <%--bar.add("垃圾桶", "查询垃圾桶信息", "/roads/laji/findLaJisByBlock.action", "body");--%>
    <%--bar.add("路灯", "查询路灯信息", "/roads/ludeng/findLuDengsByBlock.action", "body");--%>
    <%--bar.add("庭廊", "查询庭廊信息", "/roads/tinglang/findtinglangsByBlock.action", "body");--%>
    <%--bar.add("假山", "查询假山信息", "/roads/jiashan/findJiaShansByBlock.action", "body");--%>
    <%--bar.add("水系统", "查询水系统信息", "/roads/shuixi/findShuiXisByBlock.action", "body");--%>
    <%--bar.add("珍贵树种", "查询珍贵树种信息", "/roads/zhengui/findZhenGuisByBlock.action", "body");--%>
    <%--bar.add("二次供水", "查询二次供水信息", "/roads/erci/findErCisByBlock.action", "body");--%>
    <%--bar.add("停车场", "查询停车场信息", "/roads/tingche/findTingChesByBlock.action", "body");--%>
    <%--bar.add("2017年道路清雪", "查询道路清雪信息", "/roads/qingxue/findQingXuesByBlock.action", "body");--%>
    <%--bar.add("绿篱", "查询绿篱信息", "/roads/lvli/findLvLisByBlock.action", "body");--%>
    <%--bar.add("运动场系列", "查询运动场信息", "/roads/yundong/findYunDongsByBlock.action", "body");--%>
    <%--bar.add("其他类土地", "查询其他土地信息", "/roads/qita/findQiTasByBlock.action", "body");--%>

    <%--$("#menu").html(bar.toString());--%>
<%--});--%>
<%--</script>--%>
  <div><a href="<C:url value='/baiyou/findBaiyousByBlock.action'/>" style="color: #018BD3" target="body">查询柏油马路信息</a> </div> </br>
  <div><a href="<C:url value='/fangzhuan/findFangZhuansByBlock.action'/>" style="color: #018BD3"target="body">查询方砖信息</a></div> </br>
  <div> <a href="<C:url value='/yongdao/findYongDaosByBlock.action'/>" style="color: #018BD3"target="body">查询校园甬道信息</a></div> </br>
  <div><a href="<C:url value='/caoping/findCaoPingsByBlock.action'/>" style="color: #018BD3"target="body">查询草坪信息</a> </div></br>
  <div><a href="<C:url value='/lvdi/findLvDisByBlock.action'/>" style="color: #018BD3"target="body">查询绿地信息</a> </div></br>
  <div><a href="<C:url value='/xingdao/findXingDaosByBlock.action'/>" style="color: #018BD3"target="body">查询行道树信息</a></div> </br>
  <div> <a href="<C:url value='/qiaomu/findQiaoMusByBlock.action'/>" style="color: #018BD3"target="body">查询常绿乔木信息</a></div> </br>
  <div> <a href="<C:url value='/luoye/findLuoYesByBlock.action'/>" style="color: #018BD3"target="body">查询落叶乔木信息</a></div> </br>
  <div><a href="<C:url value='/guanmu/findGuanMusByBlock.action'/>"style="color: #018BD3"target="body">查询花灌木信息</a></div> </br>
  <div> <a href="<C:url value='/huahui/findHuaHuisByBlock.action'/>"style="color: #018BD3"target="body">查询花卉信息</a></div> </br>
  <div><a href="<C:url value='/zixingjia/findZiXingJiasByBlock.action'/>"style="color: #018BD3"target="body">查询自行架信息</a></div> </br>
  <div> <a href="<C:url value='/guopixiang/findGuoPiXiangsByBlock.action'/>"style="color: #018BD3"target="body">查询果皮箱信息</a></div>  </br>
  <div> <a href="<C:url value='/laji/findLaJisByBlock.action'/>"style="color: #018BD3"target="body">查询垃圾桶信息</a></div> </br>
  <div><a href="<C:url value='/ludeng/findLuDengsByBlock.action'/>"style="color: #018BD3"target="body">查询路灯信息</a> </div></br>
  <div> <a href="<C:url value='/tinglang/findtinglangsByBlock.action'/>"style="color: #018BD3"target="body">查询庭廊信息</a></div> </br>
  <div> <a href="<C:url value='/jiashan/findJiaShansByBlock.action'/>"style="color: #018BD3"target="body">查询假山信息</a></div> </br>
  <div> <a href="<C:url value='/shuixi/findShuiXisByBlock.action'/>"style="color: #018BD3"target="body">查询水系统信息</a> </div></br>
  <div> <a href="<C:url value='/zhengui/findZhenGuisByBlock.action'/>"style="color: #018BD3"target="body">查询珍贵树种信息</a></div> </br>
  <div><a href="<C:url value='/erci/findErCisByBlock.action'/>"style="color: #018BD3"target="body">查询二次供水信息</a></div> </br>
  <div><a href="<C:url value='/tingche/findTingChesByBlock.action'/>"style="color: #018BD3"target="body">查询停车场信息</a></div> </br>
  <div> <a href="<C:url value='/qingxue/findQingXuesByBlock.action'/>"style="color: #018BD3"target="body">查询2017年清雪信息</a></div> </br>
  <div> <a href="<C:url value='/lvli/findLvLisByBlock.action'/>"style="color: #018BD3"target="body">查询绿篱信息</a></div> </br>
  <div><a href="<C:url value='/yundong/findYunDongsByBlock.action'/>"style="color: #018BD3"target="body">查询运动场信息</a></div> </br>
  <div><a href="<C:url value='/qita/findQiTasByBlock.action'/>"style="color: #018BD3"target="body">查询其他类土地信息</a> </div></br>
</head>
  
<body>  
  <div id="menu"></div>
</body>
</html>
