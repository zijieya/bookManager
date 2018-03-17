<%--
  Created by IntelliJ IDEA.
  User: zijieya
  Date: 2017/12/25
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="../../img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${user.username}</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- search form (Optional) -->
        <!--  <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                  <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                  </button>
                </span>
            </div>
          </form>-->
        <!-- /.search form -->

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu" data-widget="tree">
            <!--  <li class="header">HEADER</li>-->
            <!-- Optionally, you can add icons to the links -->
            <!--   <li class="active"><a href="#"><i class="fa fa-link"></i> <span>Link</span></a></li>
               <li><a href="#"><i class="fa fa-link"></i> <span>Another Link</span></a></li>
               <li class="treeview">
                 <a href="#"><i class="fa fa-link"></i> <span>Multilevel</span>
                   <span class="pull-right-container">
                       <i class="fa fa-angle-left pull-right"></i>
                     </span>
                 </a>
                 <ul class="treeview-menu">
                   <li><a href="#">Link in level 2</a></li>
                   <li><a href="#">Link in level 2</a></li>
                 </ul>
               </li>-->
            <li ><a  href="${pageContext.request.contextPath }/admin/index"><i class="fa fa-search"></i> 首页</a></li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>图书管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu ">
                    <li><a href="${pageContext.request.contextPath }/admin/booklist"><i class="fa fa-circle-o"></i> 图书列表</a></li>
                    <li ><a  href="${pageContext.request.contextPath }/admin/addbook"><i class="fa fa-search"></i> 增加图书</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-user"></i> <span>用户管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath }/admin/listuser"><i class="fa fa-circle-o"></i> 用户列表</a></li>
                    <li><a href="${pageContext.request.contextPath }/admin/adduser"><i class="fa fa-circle-o"></i> 增加用户</a></li>
                    <li><a href="${pageContext.request.contextPath }/admin/blacklistuser"><i class="fa fa-circle-o"></i> 用户黑名单</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-user"></i> <span>借阅管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath }/admin/rebookmanage"><i class="fa fa-circle-o"></i> 续借管理</a></li>
                    <li><a href="${pageContext.request.contextPath }/admin/overduemanage"><i class="fa fa-circle-o"></i> 超期管理</a></li>
                </ul>
            </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>
