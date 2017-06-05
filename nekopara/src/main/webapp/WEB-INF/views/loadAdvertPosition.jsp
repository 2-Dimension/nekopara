<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 普通广告单张图片 -->
<c:if test="${advertPosition.type eq 0 }">
<a href="${advertList[0].url }" >
	<img alt="" src="${advertList[0].image }"  style="margin-bottom: 10px; width: 100%;height: auto;" >
</a>
</c:if>
<c:if test="${advertPosition.type eq 1 }">

</c:if>
<c:if test="${advertPosition.type eq 2 }">
	<!-- 轮播条 -->
					
					<div class="slider">
					<div class="callbacks_wrap">
						<ul class="rslides" id="slider">
						<c:forEach items="${advertList }" var="advert">
							<li>
								<img src="${advert.image }" alt="" width="${advertPosition.width }" height="${advertPosition.height }">
								<div class="caption">
									<a href="#"></a>
								</div>
							</li>
						</c:forEach>
							
						</ul>
					</div>
				</div>
</c:if>
