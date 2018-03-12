<%--
  Created by IntelliJ IDEA.
  User: jakson
  Date: 2017/12/25
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="user" value="${sessionScope.user}"/>
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

            <li ><a  href="${pageContext.request.contextPath }/user/searchbook"><i class="fa fa-search"></i> 查找图书</a></li>
            <li ><a  href="${pageContext.request.contextPath }/user/borrowedbook"><i class="fa fa-search"></i> 已借图书</a></li>
            <li><a href="${pageContext.request.contextPath }/user/bookhistory"><i class="fa fa-circle-o"></i> 借阅历史</a></li>
            <li ><a href="${pageContext.request.contextPath }/user/password"><i class="fa fa-search"></i> 修改密码</a></li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>
