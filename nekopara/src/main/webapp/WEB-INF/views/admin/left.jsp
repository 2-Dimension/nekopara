<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!-- left side start-->
 <div class="left-side sticky-left-side">

        <!--logo and iconic logo start-->
        <div class="logo">
            <a href="index.html"><img src="images/logo.jpg" class="img-responsive" alt=""></a>
        </div>

        <div class="logo-icon text-center">
            <a href="index.html"><img src="images/logo_icon.png" alt=""></a>
        </div>
        <!--logo and iconic logo end-->


        <div class="left-side-inner">

            <!-- visible to small devices only -->
            <div class="visible-xs hidden-sm hidden-md hidden-lg">
                <div class="media logged-user">
                    <img alt="" src="images/photos/user-avatar.png" class="media-object">
                    <div class="media-body">
                        <h4><a href="#">John Doe</a></h4>
                        <span>"Hello There..."</span>
                    </div>
                </div>

                <h5 class="left-nav-title">Account Information</h5>
                <ul class="nav nav-pills nav-stacked custom-nav">
                    <li><a href="#"><i class="fa fa-user"></i> <span>Profile</span></a></li>
                    <li><a href="#"><i class="fa fa-cog"></i> <span>Settings</span></a></li>
                    <li><a href="#"><i class="fa fa-sign-out"></i> <span>Sign Out</span></a></li>
                </ul>
            </div>

            <!--sidebar nav start-->
            <ul class="nav nav-pills nav-stacked custom-nav">
                <li><a href="index.html"><i class="fa fa-home"></i> <span>主页</span></a></li>
                <li class="menu-list ${menu eq 'articleList' || menu eq 'articleEdit'? 'nav-active':'' } "><a href=""><i class="fa fa-book"></i> <span>文章管理</span></a>
                    <ul class="sub-menu-list">
                        <li class="${menu eq 'articleList'?'active':'' }"><a href="/admin/articleList.do"> 文章列表</a></li>
                        <li class="${menu eq 'articleEdit'?'active':'' }"><a href="/admin/articleEditPage.do?cmd=save"> 文章添加</a></li>

                    </ul>
                </li>
                <li class="menu-list ${menu eq 'systemMenuList'||menu eq 'systemMenuEdit' ? 'nav-active':'' }"><a href=""><i class="fa fa-cogs"></i> <span>菜单管理</span></a>
                    <ul class="sub-menu-list">
                        <li class="${menu eq 'systemMenuList'?'active':'' }"><a href="/admin/systemMenuList.do"> 菜单列表</a></li>
                        <li class="${menu eq 'systemMenuEdit'?'active':'' }"><a href="/admin/systemMenuEditPage.do?cmd=save"> 菜单添加</a></li>
                    </ul>
                </li>
                <c:if test="${sessionScope.USER_IN_SESSION.username eq 'admin' }">
                <li class="menu-list ${menu eq 'userList' || menu eq 'userEdit' ? 'nav-active':'' }"><a href=""><i class="fa fa-cogs"></i> <span>用户管理</span></a>
                    <ul class="sub-menu-list">
                        <li class="${menu eq 'userList'?'active':'' }"><a href="/admin/userList.do"> 用户列表</a></li>
                        <li class="${menu eq 'userEdit'?'active':'' }"><a href="/admin/userEditPage.do?cmd=save"> 用户添加</a></li>
                    </ul>
                </li>
				</c:if>
			 <li class="menu-list ${menu eq 'indexSEOEdit' ? 'nav-active':'' }"><a href=""><i class="fa fa-cogs"></i> <span>SEO管理</span></a>
                    <ul class="sub-menu-list">
                        <li class="${menu eq 'indexSEOEdit' ? 'active':'' }"><a href="/admin/indexSEOEditPage.do"> 首页SEO添加/编辑</a></li>
                    </ul>
                </li>
			 <li class="menu-list ${menu eq 'advertPositionList'||menu eq 'advertPositionEdit' ? 'nav-active':'' }"><a href=""><i class="fa fa-cogs"></i> <span>广告管理</span></a>
                    <ul class="sub-menu-list">
                        <li class="${menu eq 'advertList' ? 'active':'' }"><a href="/admin/advertList.do"> 广告列表</a></li>
                    </ul>
                    <ul class="sub-menu-list">
                        <li class="${menu eq 'advertEdit' ? 'active':'' }"><a href="/admin/advertEditPage.do?cmd=save"> 广告添加</a></li>
                    </ul>
                     <ul class="sub-menu-list">
                        <li class="${menu eq 'advertPositionList' ? 'active':'' }"><a href="/admin/advertPositionList.do"> 广告位列表</a></li>
                    </ul>
                     <ul class="sub-menu-list">
                        <li class="${menu eq 'advertPositionEdit' ? 'active':'' }"><a href="/admin/advertPositionEditPage.do?cmd=save"> 广告位添加</a></li>
                    </ul>
                </li>
			 <li class="menu-list ${menu eq 'albumList'||menu eq 'albumEdit' ? 'nav-active':'' }"><a href=""><i class="fa fa-cogs"></i> <span>相册管理</span></a>
                    <ul class="sub-menu-list">
                        <li class="${menu eq 'albumList' ? 'active':'' }"><a href="/admin/albumList.do"> 相册列表</a></li>
                    </ul>
                    <ul class="sub-menu-list">
                        <li class="${menu eq 'albumEdit' ? 'active':'' }"><a href="/admin/albumEditPage.do?cmd=save"> 相册添加</a></li>
                    </ul>
                </li>
			 <li class="menu-list ${menu eq 'tagList'||menu eq 'tagEdit' ? 'nav-active':'' }"><a href=""><i class="fa fa-cogs"></i> <span>标签管理</span></a>
                    <ul class="sub-menu-list">
                        <li class="${menu eq 'tagList' ? 'active':'' }"><a href="/admin/tagList.do"> 标签列表</a></li>
                    </ul>
                    <ul class="sub-menu-list">
                        <li class="${menu eq 'tagEdit' ? 'active':'' }"><a href="/admin/tagEditPage.do?cmd=save"> 标签添加</a></li>
                    </ul>
                </li>

            </ul>
            <!--sidebar nav end-->

        </div>
    </div>
    <!-- left side end-->