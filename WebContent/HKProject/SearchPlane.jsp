<%@page import="Util.FormatUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DoMain.Flight"%>
<%@page import="DAO.SpaceDAO"%>
<%@page import="DAO.CityDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<% String path=request.getContextPath()+"/HKProject/"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>index</title>
<link href="<%=path %>css/jumbotron.css" rel="stylesheet">
<link href="<%=path %>css/carousel.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=path %>css/signin.css" />
<link rel="stylesheet" href="<%=path %>libs/bootstrap3/css/bootstrap.min.css">
<script src="<%=path %>libs/jquery-3.3.1.min.js"></script>
<script src="<%=path %>libs/bootstrap3/js/bootstrap.min.js"></script>
<style type="text/css">
#navtop {
	width: 60%;
}

#order {
	
}
</style>
${requestScope.notice }
</head>

<body>
	<!-- 头部 -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<img style="float: left; width: 16%;" src="<%=path %>img/HKlogo.png" /><img
					style="float: right; padding-right: 1.2%; padding-top: 1%;"
					src="<%=path %>img/mfyjp.png" />
			</div>
		</div>
	</div>

	<!-- 导航栏 -->
	<nav class="navbar navbar-default"
		style="margin-bottom: 0;border-radius: 0;">

	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/AirPlan/HKProject/index.jsp">飞哪儿航空官网</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-left">
				<li class="active"><a href="/AirPlan/HKProject/index.jsp">首页<span
						class="sr-only">(current)</span></a></li>
				<li><a href="/AirPlan/HKProject/SearchPlane.jsp">预定行程</a></li>
				<li><a href="#">新闻动态</a></li>
				<li><a href="/AirPlan/HKProject/orderquery.jsp">订单查询</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><c:if var="eu" test="${sessionScope.usermail!=null}" scope="session" ><a href="/AirPlan/HKProject/user.jsp?usermail=${sessionScope.usermail }">用户：${sessionScope.usermail }${sessionScope.userstatus }</a></c:if>
				<c:if test="${!eu }" ><a href="/AirPlan/HKProject/login.jsp">登陆</a></c:if>
				</li>
				<li><a href="#">|</a></li>
				<li>${sessionScope.usermail==null? '<a href="/AirPlan/HKProject/reg.jsp">注册</a>':'<a href="/AirPlan/logout.user">退出</a>' }</li>
			</ul>

		</div>
		<!--/.navbar-collapse -->
	</div>
	</nav>

	<div class="container">
		<ul class="nav nav-tabs" role="tablist" id="tab-list"
			style="padding-top: 3%;">
			<li class="active"><a href="#tab-single" role="tab"
				data-toggle="tab">单程</a></li>
			<li><a href="#tab-round" role="tab" data-toggle="tab">往返</a></li>
		</ul>
		<div class="tab-content" style="padding-top: 2%; padding-bottom: 2%;">
			<div class="tab-pane active" id="tab-single">
				<div class="row">
					<span class="col-md-2"> 出发地 </span> <span class="col-md-2">
						目的地 </span> <span class="col-md-2 col-md-offset-1"> 出发时间 </span> <span
						class="col-md-2" style="color: #ADADAD;"> 返程时间 </span>
				</div>
				<form class="row" action='/AirPlan/HKProject/search.plane' method='post'>
					<div class="col-md-2">
						<input type="text" placeholder="出发地" list='fromlist' name='startcity'  value='${requestScope.startcity }' required />
						<%request.setAttribute("citylist", CityDAO.getCityList()); %>
						<datalist id='fromlist' ><c:forEach var='city' items='${requestScope.citylist }' >
						<option value="${city.cityname }">${city.citycode }</option>
						</c:forEach></datalist>
					</div>
					<div class="col-md-2">
						<input type="text" list='tolist' placeholder="目的地" name='arrivecity'  value='${requestScope.arrivecity }' required />
						<datalist id='tolist' ><c:forEach var='city' items='${requestScope.citylist }' >
						<option value="${city.cityname }">${city.citycode }</option>
						</c:forEach></datalist>
					</div>
					<div class="col-md-2 col-md-offset-1">
						<input type="date" name='startdate'  value="${requestScope.startdate }" min='<%=FormatUtil.getNow()%>' required />
					</div>
					<div class="col-md-2">
						<input style="color: #ADADAD;" type="date" name='returndate' readonly="readonly">
					</div>
					<div class="col-md-2 col-md-offset-1">
						<button style="border: 0;"
							class="btn btn-primary btn-sm btn-block" type="submit">搜索</button>
					</div>
				</form>
			</div>

			<div class="tab-pane " id="tab-round">
				<div class="row">
					<span class="col-md-2"> 出发地 </span> <span class="col-md-2">
						目的地 </span> <span class="col-md-2 col-md-offset-1"> 出发时间 </span> <span
						class="col-md-2"> 返程时间 </span>
				</div>
				<form class="row">
					<div class="col-md-2">
						<input type="text" placeholder="出发地">
					</div>
					<div class="col-md-2">
						<input type="text" placeholder="目的地">
					</div>
					<div class="col-md-2 col-md-offset-1">
						<input type="date">
					</div>
					<div class="col-md-2">
						<input type="date">
					</div>
					<div class="col-md-2 col-md-offset-1">
						<button style="border: 0;"
							class="btn btn-primary btn-sm btn-block" type="submit">搜索</button>
					</div>
				</form>
			</div>
		</div>

		<table class="table table-bordered table-hover table-striped">
			<tr>
				<th>航班ID</th>
				<th>航班编号</th>
				<th>出发时间</th>
				<th>到达时间</th>
				<th>航班状态</th>
				<th>飞机型号</th>
				<th>餐食</th>
				<th>经济舱</th>
				<th>公务舱</th>
				<th>头等舱</th>
			</tr>
	<p style="color:red">${requestScope.noflight }</p>
	<% int i=0; %>
			<%
			if(request.getAttribute("flightlist")!=null){
			for(Flight flight:(ArrayList<Flight>)request.getAttribute("flightlist")){
			%>
			<tr>
				<td><%=flight.getFlightId() %></td>
				<td><%=flight.getFlightNum() %></td>
				<td><%=flight.getStartDate() %></td>
				<td><%=flight.getArriveDate() %></td>
				<td><%=flight.getFlightStatus().equals("0") ? "异常":"正常" %></td>
				<td><%=flight.getPlaneType() %></td>
				<td><%=flight.getMeal() %></td>
			<%request.setAttribute("spacelist", SpaceDAO.getSpaceList(flight.getFlightNum())); %>
			<%i++; %>
			<c:forEach var='space' items='${spacelist }' varStatus='vss'>
				<td id="th<%=i %>${vss.count }"><label><input type="radio" name="price"
						value="4000" /> ${space.spacePrice+space.airportPrice+space.oilPrice }</label></td>
			</c:forEach>
			</tr>
			<c:forEach var='space' items='${spacelist }' varStatus='vss'>
			<tr id="tr<%=i %>${vss.count }" style="display: none;">
				<td colspan=10>
					<div class="row">
						<span class="col-md-1"> 航班编号：${space.flightNum  }</span> <span class="col-md-1">
							舱位ID：${space.spaceId } </span> <span class="col-md-2"> 舱位名称：${space.spaceName }舱 </span> <span
							class="col-md-4"> 机场建设费:${space.airportPrice } 燃油附加税:${space.oilPrice } 舱位状态:${space.spaceStatus } </span> <span class="col-md-3">
							舱位票面价格:${space.spacePrice } </span> <a class="col-md-1" href="/AirPlan/HKProject/passenger.plane?spaceId=${space.spaceId }&flightId=<%=flight.getFlightId() %>"> 立即预定 </a>
					</div>
				</td>
			</tr>
			</c:forEach>
		<%} %><%} %>
		</table>
	</div>

	<!--footer -->
	<div style="background-color: rgb(247, 247, 249);">
		<hr>
		<footer class="container page-footer"> <br>
		<div class="row">
			<div class="col-md-3">
				<h6>
					<strong>关于我们</strong>
				</h6>
				<ul class="list-unstyled">
					<li><a href="/">走进我们</a></li>
					<li><a href="#">新闻资讯</a></li>
					<li><a href="#">法律条款</a></li>
					<li><a href="#">运输条件</a></li>
				</ul>
			</div>
			<div class="col-md-3">
				<h6>
					<strong>互动支持</strong>
				</h6>
				<ul class="list-unstyled">
					<li><a href="#">联系我们</a></li>
					<li><a href="#">常见问题</a></li>
					<li><a href="#">网站导航</a></li>
				</ul>
			</div>
			<div class="col-md-3">
				<h6>
					<strong>友情链接</strong>
				</h6>
				<ul class="list-unstyled">
					<li><a href="#">西藏航空</a></li>
					<li><a href="#">中国东方航空</a></li>
					<li><a href="#">四川航空</a></li>
					<li><a href="#">上海航空</a></li>
				</ul>
			</div>
			<div class="col-md-3">
				<h6>
					<strong>关注我们</strong>
				</h6>
				<ul class="list-unstyled">
					<li><img style="width: 36%;" src="<%=path %>img/815556919.png" /></li>

				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<hr>
			</div>
			<div class="col-md-6 text-xs-left">
				<small><span>© Copyright 2018 飞哪儿航空</span></small>
			</div>

		</div>
		</footer>
		<br>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#demo-navbar .dropdown-menu a").click(function() {
				var href = $(this).attr("href");
				$("#tab-list a[href='" + href + "']").tab("show");
			});
		});
	</script>
	<script>
		$(document).ready(function() {
			$("#th11").click(function() {
				$("#tr13").hide();
				$("#tr12").hide();
				$("#tr11").show();
			});
			$("#th12").click(function() {
				$("#tr13").hide();
				$("#tr11").hide();
				$("#tr12").show();
			});
			$("#th13").click(function() {
				$("#tr11").hide();
				$("#tr12").hide();
				$("#tr13").show();
			});
			$("#th21").click(function() {
				$("#tr23").hide();
				$("#tr22").hide();
				$("#tr21").show();
			});
			$("#th22").click(function() {
				$("#tr23").hide();
				$("#tr21").hide();
				$("#tr22").show();
			});
			$("#th13").click(function() {
				$("#tr21").hide();
				$("#tr22").hide();
				$("#tr23").show();
			});
			$("#th31").click(function() {
				$("#tr33").hide();
				$("#tr32").hide();
				$("#tr31").show();
			});
			$("#th32").click(function() {
				$("#tr33").hide();
				$("#tr31").hide();
				$("#tr32").show();
			});
			$("#th33").click(function() {
				$("#tr31").hide();
				$("#tr32").hide();
				$("#tr33").show();
			});
			$("#th41").click(function() {
				$("#tr43").hide();
				$("#tr42").hide();
				$("#tr41").show();
			});
			$("#th42").click(function() {
				$("#tr43").hide();
				$("#tr41").hide();
				$("#tr42").show();
			});
			$("#th43").click(function() {
				$("#tr41").hide();
				$("#tr42").hide();
				$("#tr43").show();
			});
		});
	</script>
</body>

</html>