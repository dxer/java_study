<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Zlog后台首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href=" css/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}

.divider1 {
	margin: 9px 1px;
	height: 1px;
	margin: 9px 0;
	overflow: hidden;
	background-color: #ebebeb;
	border-bottom: 1px solid #ffffff;
}
</style>
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/todc-bootstrap.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link href="edit/plugins/code/prettify.css" rel="stylesheet" type="text/css" /> 

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src=" js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="img/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="img/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="img/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="img/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href=" ico/favicon.png">


</head>

<body onhashchange="setCurByHash();">

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="#">Project name</a>
				<div class="nav-collapse collapse">
					<p class="navbar-text pull-right">
						Logged in as <a href="#" class="navbar-link">Username</a>
					</p>
					<ul class="nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#about">About</a></li>
						<li><a href="#contact">Contact</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span2">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li><a href="#main"><i class="icon-home"></i>后台首页</a></li>
					</ul>
					<div class="divider1"></div>
					<ul class="nav nav-list">
						<li class="nav-header"><i class="icon-list-alt"></i>文章</li>
						<li class="active"><a href="#article/article">&nbsp<i class="icon-pencil"></i> 发布文章</a></li>
						<li><a href="#article/article-list">&nbsp <i class="icon-file"></i>文章管理</a></li>
						<li><a href="#article/draft-list">&nbsp <i class="icon-folder-open"></i>草稿夹</a></li>
					</ul>
					<div class="divider1"></div>
					<ul class="nav nav-list">
						<li><a href="#comment-list"><i class="icon-comment"></i>评论管理</a></li>
					</ul>
					<div class="divider1"></div>
					<ul class="nav nav-list">
						<li class="nav-header"><i class="icon-wrench"></i>工具</li>
						<li><a href="#tools/preference">&nbsp<i class="icon-heart"></i>偏好设定</a></li>
						<li><a href="#tools/page-list">&nbsp<i class="icon-th"></i>导航管理</a></li>
						<li><a href="#tools/link-list">&nbsp<i class="icon-share"></i>链接管理</a></li>
						<li><a href="#tools/user-list">&nbsp<i class="icon-user"></i>用户管理</a></li>
						<li><a href="#tools/user-list">&nbsp<i class="icon-plus-sign"></i>插件管理</a></li>
						<li><a href="#tools/plugin-list">&nbsp<i class="icon-folder-close"></i>缓存管理</a></li>
						<li><a href="#tools/others">&nbsp<i class="icon-cog"></i>其他</a></li>
					</ul>
					<div class="divider1"></div>
					<ul class="nav nav-list">
						<li><a href="#about"><i class="icon-hand-right"></i>关于</a></li>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<div class="span10" id="tabsPanel">
                <section id="tabsPanel_main" class="none"></section>
                <section id="tabsPanel_article" class="none"></section>
                <section id="tabsPanel_article-list" class="none"></section>
                <section id="tabsPanel_draft-list" class="none"></section>
                <section id="tabsPanel_link-list" class="none"></section>
                <section id="tabsPanel_preference" class="none"></section>
                <section id="tabsPanel_page-list" class="none"></section>
                <section id="tabsPanel_others" class="none"></section>
                <section id="tabsPanel_user-list" class="none"></section>
                <section id="tabsPanel_comment-list" class="none"></section>
                <section id="tabsPanel_plugin-list" class="none"></section>
                <section id="tabsPanel_about" class="none"></section>
			</div>
			<!--/span-->
		</div>
		<!--/row-->

		<hr>

		<footer>
			<p>&copy; Company 2013</p>
		</footer>

	</div>
	<!--/.fluid-container-->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap-transition.js"></script>
	<script src="js/bootstrap-alert.js"></script>
	<script src="js/bootstrap-modal.js"></script>
	<script src="js/bootstrap-dropdown.js"></script>
	<script src="js/bootstrap-scrollspy.js"></script>
	<script src="js/bootstrap-tab.js"></script>
	<script src="js/bootstrap-tooltip.js"></script>
	<script src="js/bootstrap-popover.js"></script>
	<script src="js/bootstrap-button.js"></script>
	<script src="js/bootstrap-collapse.js"></script>
	<script src="js/bootstrap-carousel.js"></script>
	<script src="js/bootstrap-typeahead.js"></script>
	<script src="js/jquery.json-2.2.min.js"></script>
	<script src="edit/plugins/code/prettify.js" type="text/javascript"></script> 

	
	<script src=" js/admin.js"></script>
	<script src=" js/user.js"></script>
	<script src=" js/article.js"></script>
	
	<script language="javascript" for="window" event="onload">   
	var hash = window.location.hash;
	if(hash == ''){
		$.ajax({
			url : 'admin-main.html',
			success : function(HTML) {
				$('#tabsPanel_main').html(HTML);
			}
		});
	}else{
			
	}
	
	window.location.hash = '#main';
</script>  
</script>
</body>
</html>
