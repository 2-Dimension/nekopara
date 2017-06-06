<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>${seo.seoTitle }</title>
<link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<script src="js/duoshuo.js"></script>
<!-- Custom Theme files -->
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- for bootstrap working -->
	<script type="text/javascript" src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<!-- web-fonts -->
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
<script src="js/responsiveslides.min.js"></script>
	<script>
		$(function () {
		  $("#slider").responsiveSlides({
			auto: true,
			nav: true,
			speed: 500,
			namespace: "callbacks",
			pager: true,
		  });
		});
	</script>
	<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<!--/script-->
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});
</script>
</head>
<body>

	<%@include file="head.jsp" %>

	
	<!-- content-section-starts-here -->
	<div class="main-body">
		<div class="wrap">
		<ol class="breadcrumb">
			  <li><a href="index.html">主页</a></li>
			  <li><a href="articleList.htm?systemMenuId=${article.systemMenu.id }">${article.systemMenu.name }</a></li>
			  <li class="active">正文</li>
			</ol>
			<div class="single-page">
			
			<div class="col-md-8 content-left single-post">
				<div class="blog-posts">
				<h3 class="post" align="center"> ${article.title }</h3><br>
			
				<div class="last-article">
					${article.content }		
					<!-- 文章标签 -->			
					<ul class="categories">
					<c:forEach items="${article.tagList }" var="tag">
						<li><a href="findArticleByTag.htm?tagid=${tag.id }">${tag.tagname }</a></li>
					</c:forEach>
					</ul>
					<div class="clearfix"></div>
					<!--related-posts-->
				<div class="row related-posts">
					<h4>你可能喜欢的文章</h4>
					<c:forEach items="${hotArticleList }" var="article">
					<div class="col-xs-6 col-md-3 related-grids">
						<a href="article.htm?id=${article.id }" class="thumbnail">
							<img src="${article.image }" alt=""/>
						</a>
						<h5><a href="article.htm?id=${article.id }">${article.title }</a></h5>
					</div>
					</c:forEach>	
				</div>
				<!--//related-posts-->
				<!-- 评论 -->
				<div class="ds-share" data-thread-key="${article.id }" data-title="${article.title }" data-images="${article.image }" data-content="${article.intro }" data-url="www.user5u.com">
				    <div class="ds-share-aside-right">
				      <div class="ds-share-aside-inner">
				      </div>
				      <div class="ds-share-aside-toggle">分享到</div>
				     </div>
				</div>
		  	 <%@include file="comments.jsp" %>
		  	  
				
				<div class="clearfix"></div>
			</div>
		</div>

		</div>
		
		<!-- 网页右侧内容 -->
			<div class="col-md-4 side-bar">
			<div class="first_half">
				<div class="categories">
					<header>
						<h3 class="side-title-head">文章分类</h3>
					</header>
					<ul>
					<c:forEach items="${firstSystemMenu_in_session }" var="systemMenu">
						 <li ><a href="articleList.htm?systemMenuId=${systemMenu.id }">${systemMenu.name }</a></li>
					</c:forEach>
					</ul>
				</div>
				
				
					 <div class="side-bar-articles">
					 <c:forEach items="${topArticleList }" var="article">
					 
						<div class="side-bar-article">
							<a href="article.htm?id=${article.id }"><img src="${article.image }" alt="" /></a>
							<div class="side-bar-article-title">
								<a href="article.htm?id=${article.id }">${article.title }</a>
							</div>
						</div>
					 </c:forEach>
					 </div>
					  </div>
					 <div class="secound_half">
					  <!-- 标签 -->
					 <div class="tags">
						<header>
							<h3 class="title-head">Tags</h3>
						</header>
						<p>
						<c:forEach items="${tagList_in_session }" var="tag" varStatus="status">
							<a class="tag${status.index+1 }" href="findArticleByTag.htm?tagid=${tag.id }">${tag.tagname }</a>
						</c:forEach>
						</p>
					 </div>		 
					 <div class="popular-news">
						<header>
							<h3 class="title-popular">最新文章</h3>
						</header>
						<div class="popular-grids">
						<c:forEach items="${newArticleList }" var="article">
							<div class="popular-grid">
								<a href="article.htm?id=${article.id }"><img src="${article.image }" alt="" /></a>
								<a class="title" href="article.htm?id=${article.id }">${article.title }</a>
								<p><fmt:formatDate value="${article.publishTime }" pattern="yyyy-MM-dd"/> <a class="span_link" href="#">浏览量：${article.pageView } </a></p>
							</div>
						</c:forEach>
							
						</div>
					</div>
					</div>
					<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
		</div>
	</div>
	<!-- content-section-ends-here -->
	<%@include file="footer.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
				/*
				var defaults = {
				wrapID: 'toTop', // fading element id
				wrapHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
				*/
		$().UItoTop({ easingType: 'easeOutQuart' });
});
</script>
<a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!---->
</body>
</html>