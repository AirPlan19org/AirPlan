<%@page import="java.util.ArrayList"%>
<%@page import="DoMain.Order"%>
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
				<li><c:if var="eu" test="${sessionScope.usermail!=null}"
						scope="session">
						<a
							href="/AirPlan/HKProject/user.jsp?usermail=${sessionScope.usermail }">用户：${sessionScope.usermail }${sessionScope.userstatus }</a>
					</c:if> <c:if test="${!eu }">
						<a href="/AirPlan/HKProject/login.jsp">登陆</a>
					</c:if></li>
				<li><a href="#">|</a></li>
				<li>${sessionScope.usermail==null? '<a href="/AirPlan/HKProject/reg.jsp">注册</a>':'<a href="/AirPlan/logout.user">退出</a>' }</li>
			</ul>

		</div>
		<!--/.navbar-collapse -->
	</div>
	</nav>

	<div class="container">
	<form action='/AirPlan/HKProject/query.order' method='get'>
		<div class="row" style="margin-top: 3%; margin-bottom: 2%;">
			<div class="col-md-5">
				<select size="1" name='querytype'
					style="float: left; height: 26px; border-right: none; width: 30%;">
					<option value="1" ${requestScope.querytype=='1' ? 'selected':null }>订单号</option>
					<option value="2" ${requestScope.querytype=='2' ? 'selected':null }>票号</option>
					<option value="3" ${requestScope.querytype=='3' ? 'selected':null }>身份证号</option>
				</select> <input type="text" name='queryinfo' value='${requestScope.queryinfo }' style="float: left; height: 26px; width: 70%;" " />
			</div>
			<div class="col-md-2">
				<input style="width: 100%;" type="submit" id="" value="查询订单" />
			</div>
		</div>
		</form>
		<hr />
		<div class="row" style="margin-top: 1%; margin-bottom: 1%;">
			<div class="col-md-1">
				<a href="/AirPlan/HKProject/query.order?querytype=${requestScope.querytype }&queryinfo=${requestScope.queryinfo }">全部订单</a>
			</div>
			<div class="col-md-1">
				<a href="/AirPlan/HKProject/query.order?querytype=${requestScope.querytype }&queryinfo=${requestScope.queryinfo }&orderStatus=0">等待支付</a>
			</div>
			<div class="col-md-1">
				<a href="/AirPlan/HKProject/query.order?querytype=${requestScope.querytype }&queryinfo=${requestScope.queryinfo }&orderStatus=1">等待出票</a>
			</div>
			<div class="col-md-1">
				<a href="/AirPlan/HKProject/query.order?querytype=${requestScope.querytype }&queryinfo=${requestScope.queryinfo }&orderStatus=2">出票完成</a>
			</div>
			<div class="col-md-1">
				<a href="/AirPlan/HKProject/query.order?querytype=${requestScope.querytype }&queryinfo=${requestScope.queryinfo }&orderStatus=3">已取消订单</a>
			</div>
		</div>
		<table class="table table-bordered table-hover table-striped">
			<tr>
				<th>订单ID</th>
				<th>航班编号</th>
				<th>出发城市</th>
				<th>到达城市</th>
				<th>舱位ID</th>
				<th>舱位名称</th>
				<th>票面价格</th>
				<th>机场建设费</th>
				<th>燃油附加税</th>
				<th>旅客身份证号</th>
				<th>支付ID</th>
				<th>订单状态</th>
				<th>票号</th>
				<th>管理</th>
			</tr>
			<%
			if(request.getAttribute("orderlist")!=null){
			for(Order order:(ArrayList<Order>)request.getAttribute("orderlist")){%>
				<tr>
					<td><%=order.getOrderId() %></td>
					<td><%=order.getFlightNum() %></td>
					<td><%=order.getStartCity() %></td>
					<td><%=order.getArriveCity() %></td>
					<td><%=order.getSpaceId() %></td>
					<td><%=order.getSpaceName() %></td>
					<td><%=order.getSpacePrice() %></td>
					<td><%=order.getAirportprice() %></td>
					<td><%=order.getOilPrice() %></td>
					<td><%=order.getUserIdno() %></td>
					<td><%=order.getPayId() %></td>
					<td>
					<%=order.getOrderStatus().equals("0") ? "待支付":"" %>
					<%=order.getOrderStatus().equals("1") ? "待出票":"" %>
					<%=order.getOrderStatus().equals("2") ? "已出票":"" %>
					<%=order.getOrderStatus().equals("3") ? "已取消":"" %>
					</td>
					<td><%=order.getDraftNum() %></td>
					<td>
					<%if(order.getOrderStatus().equals("0")) {%>
						<a href=/AirPlan/HKProject/modify.order?orderId=<%=order.getOrderId() %>&querytype=<%=request.getAttribute("querytype") %>&queryinfo=<%=request.getAttribute("queryinfo") %>&orderStatus=1>支付</a>
					<%}%>
					<%if(order.getOrderStatus().equals("1")) {%>
						<a href=/AirPlan/HKProject/modify.order?orderId=<%=order.getOrderId() %>&querytype=<%=request.getAttribute("querytype") %>&queryinfo=<%=request.getAttribute("queryinfo") %>&orderStatus=2>出票</a>
					<%}%>
					<%if(order.getOrderStatus().equals("0")||order.getOrderStatus().equals("1")) {%>
						<a href=/AirPlan/HKProject/modify.order?orderId=<%=order.getOrderId() %>&querytype=<%=request.getAttribute("querytype") %>&queryinfo=<%=request.getAttribute("queryinfo") %>&orderStatus=3>取消</a>
					<%}%>
					</td>
				</tr>
			<%} %><%}%>
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

</body>

</html>