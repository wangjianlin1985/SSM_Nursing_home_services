<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">


<!-- jquery 插件 -->
<script type="text/javascript" src="plugins/jquery/jquery.min.js"></script>

<!-- bootstrap插件 -->
<link rel="stylesheet" type="text/css" href="plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="plugins/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="plugins/bootstrap/css/bootstrap-table.min.css">
<link rel="stylesheet" type="text/css" href="plugins/bootstrap/css/bootstrapValidator.min.css">
<link rel="stylesheet" type="text/css" href="plugins/bootstrap/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="plugins/bootstrap/css/bootstrap-select.min.css">
<link rel="stylesheet" type="text/css" href="plugins/fileinput/css/fileinput.min.css">

<!-- confirm -->
<link rel="stylesheet" type="text/css" href="plugins/confirm/jquery-confirm.css">

<!-- <link rel="stylesheet" type="text/css" href="webapp/interactiveServiceView/plugins/bootstrap/css/font-awesome.min.css"> -->

<script type="text/javascript" src="plugins/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="plugins/bootstrap/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="plugins/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="plugins/bootstrap/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="plugins/bootstrap/js/bootstrapValidator_zh_CN.min.js"></script>
<script type="text/javascript" src="plugins/bootstrap/js/bootbox.min.js"></script>
<script type="text/javascript" src="plugins/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="plugins/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="plugins/bootstrap/js/bootstrap-tab.js"></script>
<script type="text/javascript" src="plugins/bootstrap/js/bootstrap-select.min.js"></script>

<script type="text/javascript" src="plugins/fileinput/js/fileinput.min.js"></script>

<script type="text/javascript" src="plugins/jquery/ajaxfileupload.js"></script>
<script type="text/javascript" src="plugins/fileinput/js/locales/zh.js"></script>

<!-- confirm -->
<script type="text/javascript" src="plugins/confirm/jquery-confirm.js"></script>


<!-- form插件 -->
<!-- <script type="text/javascript" src="plugins/form/easyloader.js"></script>
<script type="text/javascript" src="plugins/form/jquery.form.js"></script>
<script type="text/javascript" src="plugins/form/jquery.parser.js"></script> -->

<!-- 自定义 -->
<script type="text/javascript" src="js/common.js"></script>

