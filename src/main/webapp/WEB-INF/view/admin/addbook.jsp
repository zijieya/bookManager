<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>图书借阅系统|管理员</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="../../css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../../css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../../css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../css/AdminLTE.min.css">
  <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect. -->
  <link rel="stylesheet" href="../../css/skin-blue.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

 <jsp:include page="head.jsp"></jsp:include>
  <!-- Left side column. contains the logo and sidebar -->
 <jsp:include page="side.jsp"></jsp:include>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
    <!--  <h1>
        Page Header
        <small>Optional description</small>
      </h1>-->
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 管理员</a></li>
        <li class="active">增加图书</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">
        <h3>增加图书</h3>
        <div class="row">
            <div class="col-md-offset-2 col-md-8">
                <div class="box box-primary">
                    <div class="col-xs-offset-2 col-md-8">
                        <form role="form" action="${pageContext.request.contextPath }/admin/addbook" method="post">
                            <div class="form-group">
                                <label>图书名称</label>
                                <input type="text" class="form-control" id="bookName" name="bookName">
                            </div>
                            <div class="form-group">
                                <label>作者</label>
                                <input type="text" class="form-control" id="bookAuthor" name="bookAuthor">
                            </div>
                            <div class="form-group">
                                <label>出版社</label>
                                <input type="text" class="form-control" id="bookPress" name="bookPress">
                            </div>
                            <div class="form-group">
                                <label>价格</label>
                                <input type="text" class="form-control" id="bookPrice" name="bookPrice">
                            </div>
                            <div class="form-group">
                                <label>图书描述</label>
                                <input type="text" class="form-control" id="bookDiscription" name="bookDiscription">

                            </div>
                            <div class="form-group">
                                <label>剩余数目</label>
                                <input type="text" class="form-control" id="remain" name="remain">
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btn btn-primary" value="确认">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- /.content -->
  </div>
<jsp:include page="foot.jsp"></jsp:include>

      </div>


  </aside>


<!-- jQuery 3 -->
<script src="../../js/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../../js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="../../js/adminlte.min.js"></script>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>