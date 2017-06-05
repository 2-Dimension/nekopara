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
		String menu="advertEdit"; 
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
                       <form class="form-horizontal"  action="/admin/advertEdit.do" method="post" enctype="multipart/form-data">
					<input type="hidden" name="cmd" value="${cmd}">
					<input type="hidden" name="id" value="${advert.id }">
						<div class="form-group">
							<label for="exampleInputPassword1" class="col-sm-2 control-label">广告名称</label> 
							<div class="col-md-4" >
							<input type="text" class="form-control" id="exampleInputPassword1"
								placeholder="" name="name" value="${advert.name }">
								</div>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1" class="col-sm-2 control-label">广告url</label> 
							<div class="col-md-4" >
							<input type="text" class="form-control" id="exampleInputPassword1"
								placeholder="" name="url" value="${advert.url }">
								</div>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1" class="col-sm-2 control-label">广告位置</label> 
							<div class="col-md-4" >
							<select class="form-control" name="advertPositionId">
							<c:forEach items="${aps }" var="advertPosition">
							<option value="${advertPosition.id }" ${advertPosition.id eq ap.id?'selected':'' }>${advertPosition.name }</option>
							</c:forEach>
							</select>
							</div>
						</div>
						<div class="form-group">
						<label for="exampleInputFile" class="col-sm-2 control-label">广告图片</label> 
						<div class="col-md-2" >
						<input type="file"
							id="exampleInputFile" name="file">
						</div>
						<p>图片大小不要超过2M.首页轮播图建议大小636*331</p>
					</div>
					<div class="form-group ">
							<label for="exampleInputPassword1" class="col-sm-2 control-label">开始时间</label> 
							<div class="col-md-4" >
							<input type="text" class=" form-control advert_date" id="exampleInputPassword1"
								placeholder="" name="beginDate" value="<fmt:formatDate value="${advert.endDate}" pattern="yyyy-MM-dd"/>">
							</div>
						</div>
						<div class="form-group" >
							<label for="exampleInputPassword1" class="col-sm-2 control-label">结束时间</label> 
							<div class="col-md-4" >
							<input type="text" class="form-control advert_date" id="exampleInputPassword1"
								placeholder="" name="endDate" value="<fmt:formatDate value="${advert.endDate}" pattern="yyyy-MM-dd"/>">
							</div>
						</div>
						 <div class="form-group">
						    <div class="col-sm-offset-2 col-sm-10">
						      <button type="submit" class="btn btn-default">编辑</button>
						    </div>
						  </div>

					</form>
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
<script src="js/My97DatePicker/WdatePicker.js"></script>
<!--common scripts for all pages-->
<script src="js/scripts.js"></script>
<script type="text/javascript">
	$(function(){
		$(".advert_date").click(function(){
			WdatePicker();
		})
		
	})
</script>
</body>
</html>
