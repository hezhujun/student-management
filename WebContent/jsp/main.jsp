<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理系统</title>
<link type="text/css" rel="stylesheet" href="./../css/style.css" />
<script type="text/javascript" src="./../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="./../js/menu.js"></script>
</head>
<body>

<div class="top"></div>
<div id="header">
	<div class="logo">学生管理系统</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您！</li>
			<li><a href="">张山</a></li>
			<li><a href="">修改密码</a></li>
			<li><a href="">设置</a></li>
			<li><a href="">退出</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="left_menu">
		<ul id="nav_dot">
    		<li>
          		<h4 class="M1"><span></span>系统公告</h4>
          		<div class="list-item none">
            		<a href='#'>系统公告</a>
          		</div>
        	</li>
        	<li>
          		<h4 class="M2"><span></span>学生</h4>
          		<div class="list-item none">
            		<a href='#'>添加学生</a>
            		<a href='#'>批量添加学生</a>
            		<a href='#'>查找、修改学生信息</a>
            		<a href='#'>签到情况</a>
        		</div>
        	</li>
        	<li>
          		<h4 class="M3"><span></span>教师</h4>
          		<div class="list-item none">
            		<a href='#'>添加教师账号</a>
            		<a href='#'>查询、修改教师信息</a>
          		</div>
        	</li>
        	<li>
          		<h4 class="M4"><span></span>新闻</h4>
          		<div class="list-item none">
            		<a href='#'>添加新闻</a>
            		<a href='#'>查询、修改新闻</a>
          		</div>
        	</li>
  		</ul>
	</div>
	<div class="m-right">
		<div class="right-nav">
			<ul>
				<li><img src="./../images/home.png"></li>
				<li style="margin-left:25px;">您当前的位置：</li>
				<li><a href="#">系统公告</a></li>
				<li>></li>
				<li><a href="#">最新公告</a></li>
			</ul>
		</div>
		<div class="main">
				
		</div>
	</div>
</div>
<div class="bottom"></div>
<div id="footer"><p>Copyright©  2015 版权所有 京ICP备05019125号-10  </p></div>
<script>navList(12);</script>
</body>
</html>