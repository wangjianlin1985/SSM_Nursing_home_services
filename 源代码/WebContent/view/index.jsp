<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>智慧养老服务系统</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@include file="common.jsp"%>
<link rel="stylesheet" type="text/css" href="css/body.css">

</head>

<style type="text/css">
</style>
<body>
	<!-- Top content -->

	<div class="container">
		<div class="row">

			<div class="col-sm-6 col-sm-offset-3 text"
				style="padding-top: 100px;">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<center>
							<h1>
								<strong>智慧养老服务系统</strong>
							</h1>
						</center>
					</div>
					<div class="panel-body">
						<div class="form-bottom contact-form">
						<form id="loginForm" class="form-horizontal">
								<div class="form-group">
									<label for="username" class="col-lg-3 control-label"></label>
									<div class="col-lg-6">
										<input type="text" class="form-control" id="username" name="username"  placeholder="用户名">
									</div>
									<div id="username_tip" class="col-lg-3 " ></div>
								</div>
								<div class="form-group">
									<label for="password" class="col-lg-3 control-label"></label>
									<div class="col-lg-6">
										<input type="password" class="form-control" id="password" name="password" placeholder="密码">
									</div>
									<div id="password_tip" class="col-lg-3 " ></div>
								</div>
							 <!-- 	<div class="form-group">
									<label for="role" class="col-lg-3 control-label" ></label>
								 	<div class="col-lg-6">
										<select id="role" name="role" class="form-control">
										  <option value="0">--请选择--</option>
										  <option value="1">学生</option>
										  <option value="2">辅导员</option>
										  <option value="3">管理员</option>
										</select>
									</div> 
									<div  id="role_tip" class="col-lg-3" ></div>
								</div> --> 
							
							</form>
						</div>
					</div>
					<div class="panel-footer">
       <center>
					<button type="button" class="btn btn-lg btn-primary"
						data-toggle="button" onclick="login()">登录</button>
					<button type="button" class="btn btn-lg btn-default"
						data-toggle="button" onclick="formReset()">重置</button>
				</center>
					</div>

				</div>



			</div>
		</div>
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3 form-box"></div>
		</div>
	</div>

	<!-- container -->


<script type="text/javascript">

$(function(){
	$("#username").focus(function(){
		$("#username_tip").empty();
		$("#password_tip").empty();
		$("#role_tip").empty();
	});
	$("#password").focus(function(){
		$("#username_tip").empty();
		$("#password_tip").empty();
		$("#role_tip").empty();
	});
	$("#role").change(function(){
		$("#username_tip").empty();
		$("#password_tip").empty();
		$("#role_tip").empty();
	});
})

function loginPage(){
	$('#setModel').modal('show');
}

function formReset(){
	$('#loginForm')[0].reset();
}


function login(){
	var temp = getFormJson("loginForm");
	if(temp.username == ""){
		$("#username_tip").html("<font color='red'>* 请输入用户名！</font>");
		return;
	}
	if(temp.password == ""){
		$("#password_tip").html("<font color='red'>* 请输入密码！</font>");
		return;
	}
	/* if(temp.role == 0){
		$("#role_tip").html("<font color='red'>* 请选择角色！</font>");
		return;
	} */
	temp.role=1;
	$.post("login/login.htm", temp ,function(data) {
		var val = eval('(' +data+ ')')
		if(val.isFlag == 0){
			window.location.href="login/main.htm";
		}else if(val.isFlag == 1){
			$("#password_tip").html("<font color='red'>* 密码输入不正确！</font>");
		}else if(val.isFlag == 2){
			$("#username_tip").html("<font color='red'>* 用户名输入不正确！</font>");
		}
		
	});
}




</script>


</body>
</html>