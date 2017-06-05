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
  <!--pickers css-->
<!--   <link rel="stylesheet" type="text/css" href="js/bootstrap-datepicker/css/datepicker-custom.css" />
  <link rel="stylesheet" type="text/css" href="js/bootstrap-timepicker/css/timepicker.css" />
  <link rel="stylesheet" type="text/css" href="js/bootstrap-colorpicker/css/colorpicker.css" />
  <link rel="stylesheet" type="text/css" href="js/bootstrap-daterangepicker/daterangepicker-bs3.css" />
  <link rel="stylesheet" type="text/css" href="js/bootstrap-datetimepicker/css/datetimepicker-custom.css" /> -->
  
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
		String menu="articleList"; 
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
					<form role="form" action="/admin/articleList.do" method="post" id="searchForm">
					<input type="hidden" name="currentPage" value="1" id="currentPage">
					<div class="col-md-3">
					<div class="form-group">
					<input id="exampleInputEmail1" class="form-control" type="text" placeholder="关键字" name="keywords" value="${qo.keywords}">
					</div>
					</div>
					<div class="col-md-3">
					<select class="form-control" name="systemMenuId">
						<option value="">所有菜单</option>
						<c:forEach items="${firstSysetmMenuList }" var="systemMenu">
						<option value="${systemMenu.id }" ${qo.systemMenuId eq systemMenu.id?'selected':'' }>${systemMenu.name }</option>
						</c:forEach>
					</select>
					</div>
					<div class="col-md-4">
					<div class="input-group input-large custom-date-range" data-date-format="yyyy-mm-dd" data-date="">
					<input id="beginDate" class="form-control" type="text" name="beginDate" value="<fmt:formatDate value="${qo.beginDate}" pattern="yyyy-MM-dd"/>">
					<span class="input-group-addon">To</span>
					<input id="endDate" class="form-control" type="text" name="endDate" value="<fmt:formatDate value="${qo.endDate}" pattern="yyyy-MM-dd"/> ">
					</div>
					</div>
					
					<button class="btn btn-primary" type="submit">查询</button>
					</form>
					</div>
                    <div class="panel-body">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>id</th>
                                <th>文章名称</th>
                                <th>文章作者</th>
                                <th>文章来源</th>
                                <th>浏览量</th>
                                <th>所属菜单</th>
                                <th>发布时间</th>
                                <th>编辑</th>
                                <th>删除</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageResult.listData}" var="article">
                            <tr>
                                <td>${article.id }</td>
                                <td>${article.title }</td>
                                <td>${article.authorName }</td>
                                <td>${article.sourceDisplay }</td>
                                <td>${article.pageView }</td>
                                <td>${article.systemMenu.name }</td>
                                <td><fmt:formatDate value="${article.publishTime}" pattern="yyyy-MM-dd"/> </td>
                                <td><a href="/admin/articleEditPage.do?cmd=edit&id=${article.id }">编辑</a></td>
                                <td><a href="/admin/articleMenuDelete.do?id=${article.id }">删除</a></td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    
                    <!-- 分页 -->
					<div style="text-align: center;">
						<ul id="pagination" class="pagination"></ul>
					</div>
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

<!-- <script type="text/javascript" src="js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="js/bootstrap-daterangepicker/moment.min.js"></script>
<script type="text/javascript" src="js/bootstrap-daterangepicker/daterangepicker.js"></script>
<script type="text/javascript" src="js/bootstrap-colorpicker/js/bootstrap-colorpicker.js"></script>
<script type="text/javascript" src="js/bootstrap-timepicker/js/bootstrap-timepicker.js"></script> -->
<!-- <script src="js/pickers-init.js"></script> -->
<script src="js/My97DatePicker/WdatePicker.js"></script>
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
		onPageClick:function(event,page){
			$("#currentPage").val(page);
			$("#searchForm").submit();
		}
	}); 
	$("#beginDate").click(function(){
		WdatePicker();
	})
	$("#endDate").click(function(){
		WdatePicker();
	})
})
</script>
</body>
</html>
