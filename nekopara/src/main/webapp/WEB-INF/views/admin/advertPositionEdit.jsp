<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <link href="js/ios-switch/switchery.css" rel="stylesheet">
	<link href="js/iCheck/skins/minimal/yellow.css" rel="stylesheet">
	 <link rel="stylesheet" type="text/css" href="js/jquery-multi-select/css/multi-select.css" />
  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>

<body class="sticky-header">
      
	<%
		String menu="advertPositionEdit"; 
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
                       <form action="/admin/advertPositionEdit.do" method="post" >
					<input type="hidden" name="cmd" value="${cmd}">
					<input type="hidden" name="id" value="${advertPosition.id }">
						<div class="form-group">
							<label for="exampleInputPassword1">广告位名称</label> <input
								type="text" class="form-control" id="exampleInputPassword1"
								placeholder="" name="name" value="${advertPosition.name }">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">广告位类型</label> 
							<select
							class="form-control" name="type">
							<option value="0" ${advertPosition.type eq 0?'selected':'' }>单个图片</option>
							<option value="1" ${advertPosition.type eq 1?'selected':'' }>多个图片</option>
							<option value="2" ${advertPosition.type eq 2?'selected':'' }>轮播图</option>
							</select>
						</div>
						<div class="form-group">
						<label for="exampleInputPassword1">广告位状态</label> 
						 <div class="slide-toggle">
						 	<div>
                                    <input type="checkbox" class="js-switch" ${advertPosition.statue eq true ? 'checked':'' } name="statue"/>
                            </div>
						 </div>
						 </div>
						 <br>
						<div class="form-group">
						<label for="exampleInputEmail1">广告大小</label>
						<div class="col-md-4 input-group m-bot15">
						<span class="input-group-addon">宽度</span>
						<input class="form-control" type="text" name="width" value="${advertPosition.width }">
						<span class="input-group-addon ">px</span>
						</div>
						<div class="col-md-4 input-group m-bot15">
						<span class="input-group-addon">高度</span>
						<input class="form-control" type="text" name="height" value="${advertPosition.height }">
						<span class="input-group-addon ">px</span>
						</div>
					</div>
						<button type="submit" class="btn btn-default">Submit</button>
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

<!--common scripts for all pages-->
<script src="js/scripts.js"></script>

<!--ios7-->
<script src="js/ios-switch/switchery.js" ></script>
<script src="js/ios-switch/ios-init.js" ></script>
</body>
</html>
