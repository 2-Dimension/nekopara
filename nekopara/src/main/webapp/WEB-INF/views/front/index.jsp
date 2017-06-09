<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Express News a Entertainment Category Flat Bootstarp responsive Website Template | Home :: w3layouts</title>
<link href="/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- for bootstrap working -->
	<script type="text/javascript" src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<!-- web-fonts -->
<script src="/js/responsiveslides.min.js"></script>
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
	<script type="text/javascript" src="/js/move-top.js"></script>
<script type="text/javascript" src="/js/easing.js"></script>
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
<!-- 网站头 -->
	<%@include file="head.jsp" %>
	
	<!-- content-section-starts-here -->
	<div class="main-body">
		<div class="wrap">
			<div class="col-md-8 content-left">
			<!-- 轮播图 -->
				<jsp:include page='/loadAdvertPosition.do?id=1'/>
				<!-- 文章 -->
				<div class="articles">
					<header>
						<h3 class="title-head">推荐文章</h3>
					</header>
					<c:forEach items="${topArticleList }" var="article">
					<div class="article">
						<div class="article-left">
							<a href="article.htm?id=${article.id }"><img src="${article.image }"></a>
						</div>
						<div class="article-right">
							<div class="article-title">
								<p><fmt:formatDate value="${article.publishTime }" pattern="yyyy-MM-dd"/> <a class="span_link" href="#">浏览量:${article.pageView } </a></p>
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
				
				<c:if test="${systemMenuList.size() >= 1 }">
				<div class="life-style">
					<header>
						<h3 class="title-head">${systemMenuList[0].name }</h3>
					</header>
					<c:forEach items="${systemMenuList[0].articleList }" var="article" varStatus="status">
						<div class="life-style-right-grid" style="padding-left: 10px;padding-right: 10px;">
							<a href="article.htm?id=${article.id }"><img src="${article.image }" alt="" /></a>
							<a class="title" href="article.htm?id=${article.id }">${article.title }</a>
						</div>
					</c:forEach>
					
				</div>
				</c:if>   
				<c:if test="${systemMenuList.size() >=3 }"> 
					<div class="sports-top">
							<div class="s-grid-left">
								<div class="cricket">
									<header>
										<h3 class="title-head">${systemMenuList[1].name }</h3>
									</header>
									<c:forEach items="${systemMenuList[1].articleList }" var="article" varStatus="status">
									<c:if test="${status.index eq 0 }">
									
									<div class="c-sports-main">
										<div class="c-image">
											<a href="article.htm?id=${article.id }"><img src="${article.image }" alt="" /></a>
										</div>
										<div class="c-text">
											<a class="power" href="single.html">${article.intro }</a>
											<h6>来源：${article.sourceDisplay }</h6>
											<p class="date"><fmt:formatDate value="${article.publishTime }" pattern="yyyy-MM-dd"/>  </p>
											<a class="reu" href="article.htm?id=${article.id }"><img src="images/more.png" alt="" /></a>
											<div class="clearfix"></div>
										</div>
										<div class="clearfix"></div>
									</div>
									</c:if>
									<c:if test="${status.index > 0 }">
										<div class="s-grid-small">
											<div class="sc-image">
												<a href="article.htm?id=${article.id }"><img src="${article.image }" alt="" /></a>
											</div>
										<div class="sc-text">
											<a class="power" href="article.htm?id=${article.id }">${article.intro }</a>
											<h6>来源：${article.sourceDisplay }</h6>
											<p class="date"><fmt:formatDate value="${article.publishTime }" pattern="yyyy-MM-dd"/></p>
											<a class="reu" href="article.htm?id=${article.id }"><img src="images/more.png" alt="" /></a>
												<div class="clearfix"></div>
										</div>
										<div class="clearfix"></div>
										</div>
										</c:if>
									</c:forEach>
									</div>
								</div>
							<div class="s-grid-right">
								<div class="cricket">
									<header>
										<h3 class="title-popular">${systemMenuList[2].name }</h3>
									</header>
									<c:forEach items="${systemMenuList[2].articleList }" var="article" varStatus="status">
										<c:if test="${status.index eq 0 }">
									<div class="c-sports-main">
											<div class="c-image">
												<a href="article.htm?id=${article.id }"><img src="${article.image }" alt="" /></a>
											</div>
											<div class="c-text">
												<a class="power" href="article.htm?id=${article.id } }">${article.title }</a>
												<h6>来源：${article.sourceDisplay }</h6>
												<p class="date"><fmt:formatDate value="${article.publishTime }" pattern="yyyy-MM-dd"/></p>
												<a class="reu" href="article.htm?id=${article.id }"><img src="images/more.png" alt="" /></a>
												<div class="clearfix"></div>
											</div>
											<div class="clearfix"></div>
										</div>
										</c:if>
										<c:if test="${status.index > 0 }">
										<div class="s-grid-small">
											<div class="sc-image">
												<a href="article.htm?id=${article.id }"><img src="${article.image }" alt="" /></a>
											</div>
										<div class="sc-text">
											<a class="power" href="article.htm?id=${article.id }">${article.title }</a>
											<h6>来源：${article.sourceDisplay }</h6>
											<p class="date"><fmt:formatDate value="${article.publishTime }" pattern="yyyy-MM-dd"/></p>
											<a class="reu" href="article.htm?id=${article.id }"><img src="images/more.png" alt="" /></a>
												<div class="clearfix"></div>
										</div>
										<div class="clearfix"></div>
										</div>
										</c:if>
										</c:forEach>
										
										
									</div>
								</div>
								<div class="clearfix"></div>
							</div>
							</c:if>
				</div>
				
			<!-- 网站右侧 -->
			<div class="col-md-4 side-bar">
			<div class="first_half">
			<!-- 轮播图右侧广告位 -->
			<jsp:include page='/loadAdvertPosition.do?id=2'/>
			<jsp:include page='/loadAdvertPosition.do?id=3'/>
			
				
					 <div class="popular-news">
						<header>
							<h3 class="title-popular">热门文章</h3>
						</header>
						<div class="popular-grids">
						<c:forEach items="${hotArticleList }" var="article">
							<div class="popular-grid">
								<a href="article.htm?id=${article.id }"><img src="${article.image }" alt="" /></a>
								<a class="title" href="article.htm?id=${article.id }">${article.title }</a>
								<p><fmt:formatDate value="${article.publishTime }" pattern="yyyy-MM-dd"/><a class="span_link" href="#">浏览量:${article.pageView } </a></p>
							</div>
						</c:forEach>
							
						</div>
					</div>
					 
					
					 
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

					 <!-- 图片 -->
					 <div class="side-bar-articles">
					 <c:forEach items="${newArticleList }" var="article">
					 
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