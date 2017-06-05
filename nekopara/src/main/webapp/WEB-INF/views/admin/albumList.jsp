<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="ThemeBucket">
  <link rel="shortcut icon" href="#" type="image/png">

  <title>Basic Table</title>

  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>

<body class="sticky-header">
      
	<%
		String menu="albumList"; 
		request.setAttribute("menu", menu); 
	%>
<section>
   <!-- 左侧导航栏 -->
   <%@include file="left.jsp" %>
    
    <!-- main content start-->
    <div class="main-content" >

      <!-- 顶部栏 -->
       <%@include file="header.jsp" %>

        <!-- page heading start-->
        <div class="page-heading">
            <h3>
                Basic Table
            </h3>
            <ul class="breadcrumb">
                <li>
                    <a href="#">Dashboard</a>
                </li>
                <li>
                    <a href="#">Data Table</a>
                </li>
                <li class="active"> Basic Table </li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">
          
            <div class="row">
           
            <div class="col-sm-12">
                <section class="panel">
                    <header class="panel-heading">
                        Hover Table
                            <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                                <a href="javascript:;" class="fa fa-times"></a>
                             </span>
                    </header>
                    <div class="panel-body">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>id</th>
                                <th>相册名称</th>
                                <th>相册图片</th>
                                <th>相册url</th>
                                <th>编辑</th>
                                <th>删除</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageResult.listData}" var="album">
                            <tr>
                                <td>${album.id }</td>
                                <td>${album.name}</td>
                                <td>${album.image }</td>
                                <td><a href="/admin/albumEditPage.do?cmd=edit&id=${album.id }">编辑</a></td>
                                <td><a href="/admin/albumDelete.do?id=${album.id }">删除</a></td>
                            </tr>
                            </c:forEach>
                           
                            </tbody>
                        </table>
                    </div>
                    <!-- 分页 -->
					<div style="text-align: center;">
						<ul id="pagination" class="pagination"></ul>
					</div>
					<a class="btn btn-success" href="/admin/albumEditPage.do?cmd=save" role="button">添加相册</a>
                </section>
            </div>
        </div>
        </div>
        <!--body wrapper end-->

        <!--footer section start-->
        <footer>
            2014 &copy; AdminEx by ThemeBucket
        </footer>
        <!--footer section end-->


    </div>
    <!-- main content end-->
</section>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<script src="/js/jquery.twbsPagination.min.js"></script>
<!--common scripts for all pages-->
<script src="js/scripts.js"></script>
  <script type="text/javascript">
$(function() {
	$("#pagination").twbsPagination({
		totalPages:${pageResult.totalPage},
		visiblePages:5,
		startPage:${pageResult.currentPage},
		first : "首页",
		prev : "上一页",
		next : "下一页",
		last : "最后一页",
		href : '?currentPage={{number}}'
	});
})
</script>
</body>
</html>
