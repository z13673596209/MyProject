<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="cn">
<head>
<title>ruleEditorSystem</title>
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="lib/bootstrap/js/bootstrap.min.js"></script>
</head>

<body style="background-color:;">
	<nav class="navbar navbar-default" location1=location;>

	<div class="container-fluid" style="background-color: #DCDCDC;">

		<div class="col-md-12 col-md-offset-1">
			<p class="navbar-brand">
			<small style="color:red;font-family:Georgia;font-style:oblique;">TraceBook</small>
			<h1>
				配置文件管理 <small style="font-style: oblique;">ServiceProfileManager</small>
				<div class="col-md-offset-10">
					<h5>
						<a href="#">登录&nbsp&nbsp</a><a href="#">注册&nbsp&nbsp</a><a
							href="#">设置</a>
					</h5>
				</div>
			</h1>
			</p>

		</div>
	</div>
	</div>

	<div class="col-md-6 col-md-offset-2" style="height:70px">
		<h4>
			<ul class="nav navbar-nav" id="1"></ul>
		</h4>
	</div>

	</nav>

	<div class="row">

		<div class="col-md-2 col-md-offset-2"
			style="margin-left: 310px; height: 600px; background-color: #F5F5F5;">
			<div class="row" style="background-color: #DCDCDC;">
				<div class="col-md-offset-3">
					<h3>文件列表</h3>
				</div>
			</div>
			<div id="4"></div>
			<div id="2"></div>
			<div id="3"></div>
		</div>
		<div class="col-md-6">
			<h3>编辑器</h3>
			<textarea id='textarea'
				style='width: 100%; height: 480px; margin-top: 10px'>请编写规则...</textarea>
			<div style='margin-top: 10px;'>
				<button id='btnCreateRule'>保存文件</button>
				<button id="btnTestRule">重置系统配置</button>
			</div>
		</div>
	</div>



	<script type="text/javascript" src="lib/jquery.js"></script>
	<script type="text/javascript" src="lib/bootstrap/"></script>
	<script type="text/javascript" src="js/ruleList.js"></script>

</body>
</html>


