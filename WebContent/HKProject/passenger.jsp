<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			
			#order {}
		</style>
	</head>

	<body>
		<!-- 头部 -->
		<div class="container">
			<div class="row">
				<div class="col-md-12"><img style="float: left;width: 16%;" src="img/HKlogo.png" /><img style="float: right;padding-right: 1.2%;padding-top: 1%;" src="img/mfyjp.png" /></div>
			</div>
		</div>

		<!-- 导航栏 -->
		<nav class="navbar navbar-default" style="margin-bottom: 0;border-radius: 0;">

			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
					<a class="navbar-brand" href="#">飞哪儿航空官网</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-left">
						<li>
							<a href="index.html">首页<span class="sr-only">(current)</span></a>
						</li>
						<li>
							<a href="reservation.html">预定行程</a>
						</li>
						<li>
							<a href="#">新闻动态</a>
						</li>
						<li>
							<a href="#">订单查询</a>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="active">
							<a href="login.html">登陆</a>
						</li>
						<li>
							<a href="#">|</a>
						</li>
						<li>
							<a href="sign.html">注册</a>
						</li>
					</ul>

				</div>
				<!--/.navbar-collapse -->
			</div>
		</nav>

		<!-- /container -->
		<div class="container" style="padding-top: 3%; padding-bottom: 3%;">
			<div class="row">
				<div class="col-md-7" style="border:1px solid #CCCCCC;">
					<h6><strong>乘机人信息</strong></h6>
					<ul class="list-unstyled">
						<li style="margin-top: 3%;">
							<div class="row">
								<div class="col-md-3 " style="line-height: 32px;">
									<span style="float: right;">乘机人姓名:</span>
								</div>
								<div class="col-md-9">
									<input style="width: 100%; border: none;border-bottom:1px solid #888888; ;" type="text" name="" id="" value="" />
								</div>
							</div>
						</li>
						<li style="margin-top: 3%;">
							<div class="row">
								<div class="col-md-3 " style="line-height: 32px;">
									<span style="float: right;">证件号码:</span>
								</div>
								<div class="col-md-3">
									<select size="1" style="float: left; height: 24px;border: none;border-bottom:1px solid #888888;width: 100%;">
										<option value="1">护照</option>
										<option value="2">户口簿</option>
										<option value="3" selected="selected">身份证</option>
									</select>
								</div>
								<div class="col-md-6">
									<input style="width: 100%; border: none;border-bottom:1px solid #888888; ;" type="text" name="" id="" value="" />
								</div>
							</div>
						</li>
						<li style="margin-top: 3%; margin-bottom: 4%;">
							<div class="row">
								<div class="col-md-3 " style="line-height: 32px;">
									<span style="float: right;">联系方式:</span>
								</div>
								<div class="col-md-3">
									<select size="1" style="float: left; height: 24px;border: none;border-bottom:1px solid #888888;width: 100%;">
										<option value="1">固定电话</option>
										<option value="2">其他</option>
										<option value="3" selected="selected">移动电话</option>
									</select>
								</div>
								<div class="col-md-6">
									<input style="width: 100%; border: none;border-bottom:1px solid #888888; ;" type="text" name="" id="" value="" />
								</div>
							</div>
						</li>
						
					</ul>
				</div>
				<div class="col-md-4 col-md-offset-1" style="border:1px solid #269ABC;">
					<h6><strong>行程详情</strong></h6>
					<ul class="list-unstyled">
						<li style="background-color:#D4D4D4; padding:2% 6% ;">
							<p> 去程 02月08日 成都 - 上海 周四</p>
							<p> MU5416 公务舱 Q舱 </p>
							<p> 16:55 - - -20:00 </p>
							<p> 双流机场 T2- - - 直达 - - -浦东机场 T1</p>
						</li>
						<li  style="background-color:#F5E79E; padding:2% 6% ;">
							<span>
									总计：
								</span>
							<span>
									￥：1700.00
								</span>
							<p><span>成人￥1,850 * 1</span> <span>	机建 (总计)￥50 燃油 (总计)0
								</span></p>
						</li>
					</ul>
				</div>
			</div>
			<button style=" border: 0; width: 30%; margin: 0 auto;"  class="btn btn-lg btn-primary btn-block" type="submit">确认订单</button>
		</div>
		<!-- /container -->

		<!--footer -->
		<div style="background-color: rgb(247, 247, 249);">
			<hr>
			<footer class="container page-footer"><br>
				<div class="row">
					<div class="col-md-3">
						<h6><strong>关于我们</strong></h6>
						<ul class="list-unstyled">
							<li>
								<a href="/">走进我们</a>
							</li>
							<li>
								<a href="#">新闻资讯</a>
							</li>
							<li>
								<a href="#">法律条款</a>
							</li>
							<li>
								<a href="#">运输条件</a>
							</li>
						</ul>
					</div>
					<div class="col-md-3">
						<h6><strong>互动支持</strong></h6>
						<ul class="list-unstyled">
							<li>
								<a href="#">联系我们</a>
							</li>
							<li>
								<a href="#">常见问题</a>
							</li>
							<li>
								<a href="#">网站导航</a>
							</li>
						</ul>
					</div>
					<div class="col-md-3">
						<h6><strong>友情链接</strong></h6>
						<ul class="list-unstyled">
							<li>
								<a href="#">西藏航空</a>
							</li>
							<li>
								<a href="#">中国东方航空</a>
							</li>
							<li>
								<a href="#">四川航空</a>
							</li>
							<li>
								<a href="#">上海航空</a>
							</li>
						</ul>
					</div>
					<div class="col-md-3">
						<h6><strong>关注我们</strong></h6>
						<ul class="list-unstyled">
							<li>
								<img style="width: 36%;" src="img/815556919.png" />
							</li>

						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<hr>
					</div>
					<div class="col-md-6 text-xs-left"><small><span>© Copyright 2018 飞哪儿航空</span></small></div>

				</div>
			</footer><br></div>

	</body>

</html>