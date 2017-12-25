<%@page import="com.study.domain.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
		<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>商城首页</title>

		<!-- 引入Bootstrap核心样式文件 -->
		<link rel="stylesheet" href="css/bootstrap.css" />
		<!-- 引入jQuery核心js文件 -->
		<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
		<!-- 引入BootStrap核心js文件 -->
		<script type="text/javascript" src="js/bootstrap.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
			<div class="col-md-4">
				<img src="img/header/logo2.png" />
			</div>
			<div class="col-md-5">
				<img src="img/header/header.png" />
			</div>
			<div class="col-md-3" style="padding-top:20px">
				<ol class="list-inline">
					<li>
						<a href="#">登录</a>
					</li>
					<li>
						<a href="#">注册</a>
					</li>
					<li>
						<a href="#">购物车</a>
					</li>
				</ol>
			</div>
		</div>
		<!--
         	描述：导航条
         -->
		<div class="container-fluid" style="margin-top: 10px;">
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
						<a class="navbar-brand" href="#">首页</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav category">
						<%
							List<Category> list=(List<Category>)request.getAttribute("allCategory");
							if(list==null||list.size()==0){
								out.print("<span style='color:red;'>没有商品种类</span>");
							}else{
								for(Category cat:list){
						%>
							<li class="active">
								<a href="#"><%=cat.getCname() %><span class="sr-only">(current)</span></a>
							</li>
						<%
								}
							}
						%>
						</ul>
						<form class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Search">
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</form>

					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</div>
		<script type="text/javascript">
			$(function(){
				if($(".category>.active").size()==0){
					window.location="http://localhost:8080/day38_homework/showAll";	
				}
			});
		</script>
</body>
</html>