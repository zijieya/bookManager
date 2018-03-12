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
    <title>图书借阅系统</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <!--bootstrap table-->
    <link rel="stylesheet" href="../../css/bootstrap-table.css">
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
                <li><a href="#"><i class="fa fa-dashboard"></i>用户</a></li>
                <li class="active">已借图书</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">

            <!--------------------------
              | Your Page Content Here |
              -------------------------->
            <h3>已借图书</h3>
            <div class="box  box-primary">
                <div class="row">
                    <div class="col-md-12">
                        <table id="table2"></table>
                    </div>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <jsp:include page="foot.jsp"></jsp:include>
    <!-- /.tab-pane -->
</div>
</aside>


<!-- jQuery 3 -->
<script src="../../js/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../../js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="../../js/adminlte.min.js"></script>
<script src="../../js/bootstrap-table.js"></script>
<script src="../../js/bootstrap-table-zh-CN.js"></script>
<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
<script>
    $('#table2').bootstrapTable({
        method:"get",
        url: "/user/borrowedbooks",
        dataType: "json",
        striped: true,
        smartDisplay:true,
        queryParamsType:'limit',
        pagination: true,
        sidePagination: "server",
        pageNumber:1,
        pageSize:1,
        pageList:[5,10],
       // toolbar: '#toolbar',
        clickToSelect: true,
        classes:'table table-hover table-no-bordered',
        columns: [{
            field: 'borrowId',
            title: '借阅编号'
        }, {
            field: 'bookId',
            title: '图书编号'
        },{
            field:'borrowTime',
            title:'借阅时间'
        },{
            field:'returnTime',
            title:'还书时间'
        },{
            field:'reBorrowTimes',
            title:'续借次数'
        },{
            field:'reBorrow',
            title:'续借',
            formatter :function operateFormatter(value, row, index) {
                return [
                    '<button name="borrow" type="button" class="btn btn-primary ">续借</button>']
                    .join('');

            }
        },{
            field:'returnBook',
            title:'还书',
            formatter :function operateFormatter(value, row, index) {
                return [
                    '<button name="borrow" type="button" class="btn btn-danger ">还书</button>']
                    .join('');

            }
        }
        ],
        queryParams:function (params) {
             return {
                pageSize:params.limit,
                pageNumber:params.offset/params.limit+1
            }


        },
        onClickCell:function(field, value, row, $element){
            if(field=="reBorrow"){
                if(row.reBorrowTimes==3){//借阅次数等于三次 则不予许续借
                    alert("超过续借次数！")
                }
                else
                    window.location.href="/user/reborrow/"+row.borrowId;//跳转到借书页面
            }
            if(field=="returnBook"){
                window.location.href="/user/returnbook?borrowId="+row.borrowId+"&bookId="+row.bookId;//
            }
        }
    })
</script>
    </body>
</html>
