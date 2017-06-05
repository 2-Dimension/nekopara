<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!-- header-section-starts-here -->
	<div class="header">
	<!-- 横向导航栏 -->
		<div class="header-top">
			<div class="wrap">
				<div class="top-menu">
					<ul>
						<li><a href="index.htm">主页</a></li>
						<li><a href="#">联系我们</a></li>
					</ul>
				</div>
				<div class="num">
					<p> 联系电话 : 12345678</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="header-bottom">
			<div class="logo text-center">
				<a href="index.html"><img src="images/logo.jpg" alt="" /></a>
			</div>
			<div class="navigation">
				<nav class="navbar navbar-default" role="navigation">
		   <div class="wrap">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				
			</div>
			<!--/.navbar-header-->
		
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					 <li class="active"><a href="index.htm">主页</a></li>
				<c:forEach items="${firstSystemMenu_in_session }" var="systemMenu">
					 <li ><a href="articleList.htm?systemMenuId=${systemMenu.id }">${systemMenu.name }</a></li>
				</c:forEach>
					<div class="clearfix"></div>
				</ul>
				<div class="search">
					<!-- start search-->
				    <div class="search-box">
					    <div id="sb-search" class="sb-search">
							<form action="articleList.htm" method="post" id="searchForm">
								<input type="hidden" name="currentPage" id="currentPage" value="1">
								<input type="hidden" name="systemMenuId" value="${qo.systemMenuId }">
								<input class="sb-search-input" placeholder="输入关键字" type="search" name="keywords" id="search" value="${qo.keywords }">
								<input class="sb-search-submit" type="submit" value="">
								<span class="sb-icon-search"> </span>
							</form>
						</div>
				    </div>
					<!-- search-scripts -->
					<script src="js/classie.js"></script>
					<script src="js/uisearch.js"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
					<!-- //search-scripts -->
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!--/.navbar-collapse-->
	 <!--/.navbar-->
			</div>
		</nav>
		</div>
	</div>
	<!-- header-section-ends-here -->
	
	<div class="wrap">
		<div class="move-text">
			<div class="breaking_news">
				<h2>今日热点</h2>
			</div>
			<div class="marquee">
			<c:forEach items="${todayArticleList_in_session }" var="article">
				<div class="marquee1"><a class="breaking" href="article.htm?id=${article.id }">>>${article.title }</a></div>
			</c:forEach>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
			<script type="text/javascript" src="js/jquery.marquee.min.js"></script>
			<script>
			  $('.marquee').marquee({ pauseOnHover: true });
			  //@ sourceURL=pen.js
			</script>
		</div>
	</div>