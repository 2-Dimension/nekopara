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
		String menu="advertPositionList"; 
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
                                <th>广告位名称</th>
                                <th>广告位类型</th>
                                <th>广告位状态</th>
                                <th>宽度</th>
                                <th>高度</th>
                                <th>编辑</th>
                                <th>广告管理</th>
                                <th>代码调用</th>
                                <th>删除</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageResult.listData}" var="advertPosition">
                            <tr>
                                <td>${advertPosition.id }</td>
                                <td>${advertPosition.name }</td>
                                <td>${advertPosition.typeDisplay}</td>
                                <td>${advertPosition.statueDisplay }</td>
                                <td>${advertPosition.width }px</td>
                                <td>${advertPosition.height}px</td>
                                <td><a href="/admin/advertPositionEditPage.do?cmd=edit&id=${advertPosition.id }">编辑</a></td>
                                <td><a href="/admin/advertList.do?apid=${advertPosition.id }">广告管理</a></td>
                                <td><a href="#" class="showModal" data-id="${advertPosition.id }">代码调用</a></td>
                                <td><a href="/admin/advertPositionDelete.do?id=${advertPosition.id }">删除</a></td>
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
<!-- 模态框 -->
<div class="modal fade" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">调用代码</h4>
      </div>
      <div class="modal-body">
        <p>&hellip;</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary">确认</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
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
	//分页
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
	
	//模态框调用
	$(".showModal").click(function(){
		var id = $(this).data('id');
		var url = "\<jsp\:include page='\/loadAdvertPosition.do\?id="+id+"'\/\>";
		$(".modal-body p").text(url);
		$('#myModal').modal("show")
	})
	
})
</script>
</body>
</html>
