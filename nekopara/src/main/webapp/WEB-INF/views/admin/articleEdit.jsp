<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="ThemeBucket">
  <link rel="shortcut icon" href="#" type="image/png">

  <title>Editors</title>

  <link rel="stylesheet" type="text/css" href="js/bootstrap-wysihtml5/bootstrap-wysihtml5.css" />

  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">
  
  
   <!--tags input-->
    <link rel="stylesheet" type="text/css" href="js/jquery-tags-input/jquery.tagsinput.css" />
  

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>

<body class="sticky-header">
<%
		String menu="articleEdit"; 
		request.setAttribute("menu", menu); 
	%>
<section>
    <!-- left side start-->
   <%@include file="left.jsp" %>
    <!-- left side end-->
    
    <!-- main content start-->
    <div class="main-content" >
        <!-- header section start-->
       <%@include file="header.jsp" %>
        <!-- header section end-->
        
	
        <!-- page heading start-->
        <div class="page-heading">
            <h3>
                Editors
            </h3>
            <ul class="breadcrumb">
                <li>
                    <a href="#">Forms</a>
                </li>
                <li class="active"> Editors </li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">
        <form action="/admin/articleEdit.do" method="post" enctype="multipart/form-data" id="articleEditForm">
			<input type="hidden" value="${cmd}" name="cmd">
			<!-- id -->
			<input type="hidden" value="${article.id}" name="id">
			<input type="hidden" value="${seo.seoId}" name="seoId">
        <div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="exampleInputEmail1">所属菜单</label> <select
							class="form-control" name="systemMenu.id">
							<c:forEach items="${systemMenuList }" var="systemMenu">
								<option value="${systemMenu.id }" ${systemMenu.id eq article.systemMenu.id ? 'selected':'' }>${systemMenu.name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">文章标题</label> <input name="title"
							type="text" class="form-control" id="exampleInputEmail1" value="${article.title }"
							placeholder="文章标题">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">文章作者</label> <input name="authorName"
							type="text" class="form-control" id="exampleInputEmail1" value="${article.authorName }"
							placeholder="文章标题">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">文章来源(原创不填)</label> <input name="source"
							type="text" class="form-control" id="exampleInputEmail1" value="${article.source }"
							placeholder="文章标题">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">文章来源url(原创不填)</label> <input name="sourceUrl"
							type="text" class="form-control" id="exampleInputEmail1" value="${article.sourceUrl}"
							placeholder="文章标题">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">是否置顶</label> <label
							class="radio-inline"> <input type="radio"
							name="isTop" id="inlineRadio1" value="0" ${article.isTop eq true ?'':'checked'}>
							不置顶
						</label> <label class="radio-inline"> <input type="radio"
							name="isTop" id="inlineRadio2" value="1" ${article.isTop eq true ?'checked':''}>
							置顶
						</label>
					</div>
				
					<div class="form-group">
						<label for="exampleInputFile">文章展示图片</label> <input type="file"
							id="exampleInputFile" name="file">
						<p class="help-block">图片大小不要超过2M.</p>
					</div>
					
					<div class="form-group">
						<label for="exampleInputEmail1">文章seo标题</label> <input name="seoTitle"
							type="text" class="form-control" id="exampleInputEmail1" value="${seo.seoTitle}"
							placeholder="文章seo标题">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">文章seo关键字</label> <input name="seoKeywords"
							type="text" class="form-control" id="exampleInputEmail1" value="${seo.seoKeywords}"
							placeholder="文章seo关键字">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">文章seo描述</label> <input name="seoDescription"
							type="text" class="form-control" id="exampleInputEmail1" value="${seo.seoDescription }"
							placeholder="文章seo描述">
					</div>
					
					<div class="form-group">
						<label for="exampleInputEmail1">文章简介</label>
						<textarea class="form-control" rows="3" name="intro" >${article.intro }</textarea>
					</div>
					<!-- <div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="Password">
					</div> -->
					<div class="form-group">
                          <label for="exampleInputEmail1">所有标签</label>
                            <!--   <input id="tags_1" type="text" class="tags" value="" /> -->
                              <div id="tags_1_tagsinput" class="tagsinput" style="width: auto; min-height: 100px; height: 100%;">
                              <c:forEach items="${tagList }" var="tag">
                              <span class="tag">
								<span class="allTags" data-id="${tag.id }">${tag.tagname }</span>
								</span>
                              </c:forEach>
                              </div>
                              
                      </div>
                      
                      <input  type="hidden" name="tags"  value="" id="tagInput"/> 
					<div class="form-group" id="articleTag">
					 <label for="exampleInputEmail1" >文章标签</label>
					 <c:forEach items="${article.tagList }" var="tag">
					 	<a href='#' class='btn btn-xs btn-info mytag' data-toggle='modal' data-id='${tag.id }'>${tag.tagname }</a>
					 </c:forEach>
					</div>
				</div>

			</div>
			
			
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            CKEditor
                            <span class="tools pull-right">
                                <a class="fa fa-chevron-down" href="javascript:;"></a>
                                <a class="fa fa-times" href="javascript:;"></a>
                             </span>
                        </header>
                        <div class="panel-body">
                            <div class="form">
                             <!--    <form action="#" class="form-horizontal"> -->
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <textarea class="form-control ckeditor" name="content" rows="10">${article.content }</textarea>
                                        </div>
                                    </div>
                                <!-- </form> -->
                            </div>
                        </div>
                    </section>
                </div>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
           </form>
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

<script type="text/javascript" src="js/ckeditor/ckeditor.js"></script>

<script type="text/javascript" src="js/bootstrap-wysihtml5/wysihtml5-0.3.0.js"></script>
<script type="text/javascript" src="js/bootstrap-wysihtml5/bootstrap-wysihtml5.js"></script>
<!-- tag input -->
<script src="js/jquery-tags-input/jquery.tagsinput.js"></script>
<script src="js/tagsinput-init.js"></script>
<!--common scripts for all pages-->
<script src="js/scripts.js"></script>

<script>
    jQuery(document).ready(function(){
         $('.wysihtml5').wysihtml5();
    });
</script>
<script type="text/javascript">
				$(function(){
					
					$(".allTags").click(function(){
						var tagid = $(this).data("id");
						//获取已选择的标签，遍历
						var tagArray = $(".mytag");
						var flag = true;
						$.each(tagArray,function(index,item){
							id=$(item).data("id");
							if(tagid==id){
								alert("该标签已拥有！");
								flag=false;
							}
						});
						if(flag){
							var tagVal=$(this).text();
							var a_tag = $("<a href='#' class='btn btn-xs btn-info mytag' data-toggle='modal' data-id='"+tagid+"'>"+tagVal+"</a>");
							$("#articleTag").append(a_tag);
						}
						
					})
					$(".mytag").live("click",function(){
						$(this).remove();
					})
					$("#articleEditForm").submit(function(){
						var tagArray = $(".mytag");
						var ids="";
						$.each(tagArray,function(index,item){
							if(index==0){
								ids=$(item).data("id")
							}else{
								ids=ids+","+$(item).data("id");
							}
						});
						$("#tagInput").val(ids);
					})
				})
				
			</script>
</body>
</html>
