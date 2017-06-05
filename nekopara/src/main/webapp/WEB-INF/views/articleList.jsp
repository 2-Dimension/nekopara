<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>${seo.seoTitle }</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<script src="/js/jquery.twbsPagination.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Express News Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
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
			  <li class="active">${currentSystemMenu.name }</li>
			</ol>
			<div class="col-md-8 content-left">
			<div class="articles sports">
					<header>
						<h3 class="title-head">置顶</h3>
					</header>
					<div class="technology">
						<div class="tech-main">
							<c:forEach items="${topArticleList }" var="article">
							
								<div class="tech" style="padding-left: 10px;padding-right: 10px;">
									<a href="article.htm?id=${article.id }"><img src="${article.image }" alt="" /></a>
									<a class="power" href="article.htm?id=${article.id }">${article.title }</a>
								</div>
								
							</c:forEach>
								
								<div class="clearfix"></div>
						</div>
						
					</div>
					<header>
						<h3 class="title-head">分类文章</h3>
					</header>
					<c:forEach items="${pageResult.listData }" var="article">
					<div class="article">
						<div class="article-left">
							<a href="article.htm?id=${article.id }"><img src="${article.image }"></a>
						</div>
						<div class="article-right">
							<div class="article-title">
								<p><fmt:formatDate value="${article.publishTime }" pattern="yyyy-MM-dd"/><a class="span_link" href="#">浏览量:${article.pageView } </a></p>
								<a class="title" href="article.htm?id=${article.id }"> ${article.title }</a>
							</div>
							<div class="article-text">
								<p>${article.intro }</p>
								<a href="article.htm?id=${article.id }"><img src="images/more.png" alt="" /></a>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
					</c:forEach>
				</div>
				
				<!-- 分页 -->
				<ul id="pagination" class="pagination"></ul>
				
				<div class="latest-articles">
							<div class="main-title-head">
								<header>
									<h3 class="title-head">最热文章</h3>
								</header>
							</div>
							<div class="world-news-grids">
							<c:forEach items="${hotArticleList }" var="article">
								<div class="world-news-grid">
									<img src="${article.image }" alt="" />
									<a href="article.htm?id=${article.id }" class="title">${article.title } </a>
									<p>${article.intro }</p>
									<a class="reu" href="article.htm?id=${article.id }"><img src="images/more.png" alt="" /></a>
								</div>
							</c:forEach>
								
								
								<div class="clearfix"></div>
							</div>
						</div>

			</div>
			
			<!-- 右侧 -->
			<div class="col-md-4 side-bar">
			<div class="first_half">
			<!-- 广告位 -->
				<jsp:include page='/loadAdvertPosition.do?id=5'/>
				
					  </div>
					 <div class="secound_half">
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
								<p><fmt:formatDate value="${article.publishTime }" pattern="yyyy-MM-dd"/> <a class="span_link" href="#">浏览量:${article.pageView } </a></p>
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
	<!-- content-section-ends-here -->
	<%@include file="footer.jsp" %>
	
	<script type="text/javascript">
		$(document).ready(function() {
				/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
				*/
		$().UItoTop({ easingType: 'easeOutQuart' });
});
</script>
<script type="text/javascript">
		$(function(){
			$("#pagination").twbsPagination({
				totalPages:${pageResult.totalPage},
				visiblePages:5,
				startPage:${pageResult.currentPage},
				first : "首页",
				prev : "上一页",
				next : "下一页",
				last : "最后一页",
				onPageClick:function(event,page){
					$("#currentPage").val(page);
					$("#searchForm").submit();
				}
			}); 
		})
	</script>
<a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!---->
</body>
</html>