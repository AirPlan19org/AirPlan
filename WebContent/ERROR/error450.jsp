<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>index</title>
<link href="css/jumbotron.css" rel="stylesheet">
<link href="css/carousel.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/signin.css" />
<link rel="stylesheet" href="libs/bootstrap3/css/bootstrap.min.css">
<script src="libs/jquery-3.3.1.min.js"></script>
<script src="libs/bootstrap3/js/bootstrap.min.js"></script>
<style type="text/css">
#navtop {
	width: 60%;
}

#order {
	
}
</style>
</head>

<body>
	<!-- 头部 -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<img style="float: left; width: 16%;" src="img/HKlogo.png" /><img
					style="float: right; padding-right: 1.2%; padding-top: 1%;"
					src="img/mfyjp.png" />
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
				<li><a href="reservation.html">预定行程</a></li>
				<li><a href="#">新闻动态</a></li>
				<li><a href="OrderQuery.html">订单查询</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><c:if var="eu" test="${sessionScope.usermail!=null}" scope="session" ><a href="/AirPlan/HKProject/user.jsp?usermail=${sessionScope.usermail }">用户：${sessionScope.usermail }</a></c:if>
				<c:if test="${!eu }" ><a href="/AirPlan/HKProject/login.jsp">登陆</a></c:if>
				</li>
				<li><a href="#">|</a></li>
				<li>${sessionScope.usermail==null? '<a href="/AirPlan/HKProject/reg.jsp">注册</a>':'<a href="/AirPlan/logout.user">退出</a>' }</li>
			</ul>

		</div>
		<!--/.navbar-collapse -->
	</div>
	</nav>
<h1 style="text-align:center">450：服务未找到</h1>
	<!--footer -->
	<div style="background-color: rgb(247, 247, 249);">
		<hr>
		<footer class="container page-footer">
		<br>
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
					<li><img style="width: 36%;" src="img/815556919.png" /></li>

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