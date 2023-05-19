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
		<!-- basic styles -->
		<link href="plugins/ace/css/font-awesome.min.css" rel="stylesheet" />
		<!-- ace styles -->
		<link rel="stylesheet" href="plugins/ace/css/ace.min.css" />
		<!-- 自定义js -->
		<script src="plugins/ace/js/sidebar-menu.js"></script>
		<!-- ace scripts -->
		<script src="plugins/ace/js/ace-elements.min.js"></script>
		<script src="plugins/ace/js/ace.min.js"></script>



<style type="text/css">
			
body {
	overflow: hidden;
}
.tab-content {
	border: none;
	padding: 10px 0px;
}

#menu_li_0 {
	display: none;
}
.ace-nav>li {
 height: 50px;
 
}
</style>

	</head>

	<body>
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="fa fa-envira"></i>
							智慧养老服务系统
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">

						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<!-- <img class="nav-user-photo" src="images/user.jpg" alt="Jason's Photo" /> -->
								<span class="user-info">
									<small>欢迎光临,</small>
									${user.username }
								</span>

								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<!-- <li>
									<a href="#">
										<i class="icon-user"></i>
										个人资料
									</a>
								</li> -->
								<li>
									<a href="javascript:void(0)" onclick="editPwd()">
										<i class="icon-cog"></i>
										修改密码
									</a>
								</li>
								<li class="divider"></li>

								<li>
									<a href="javascript:void(0)" onclick="logout()">
										<i class="icon-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<ul class="nav nav-list" id="menu">
					
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>

				<div class="main-content">
					

					<div class="page-content">
						

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<ul class="nav nav-tabs" role="tablist">
			       					<!--<li class="active"><a href="#Index" role="tab" data-toggle="tab">首页</a></li>-->
			      				</ul>
			      				<div class="tab-content">
			       					<!--<div role="tabpanel" class="tab-pane active" id="Index"></div>-->
			      				</div>
								
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->

				<!-- /#ace-settings-container -->
			</div><!-- /.main-container-inner -->
		</div><!-- /.main-container -->

		<!-- basic scripts -->



<!-- 第一个model 开始 -->
<div id="setModal" class="modal fade" tabindex="-1" role="dialog" data-backdrop="static" data-keybord="false">
	<div class="modal-dialog" style="width:700px">
		<div class="modal-content">
			<div class="modal-header">
				修改密码
			</div>
			<!-- modal-body 开始 -->
			<div class="modal-body">
				<form id="setForm" class="form-horizontal">
					<input type="hidden" name="id">
					<div class="form-group">
						<label class="col-sm-4 control-label" for="class_name">新密码</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" id="password" name = "password" placeholder="请输入新密码">
						</div>
					</div>
				</form>	
			</div>
			<!-- modal-body 结束 -->
			<div class="modal-footer">
				<button id="edit_save_btn" type="button" class="btn btn_info" onclick = "editPassword()" style="background-color:#438EB9!important;border-color:#438EB9;">
					<span class="glyphicon glyphicon-ok"></span>保存
				</button>
				<button id="delete_save_btn" type="button" class="btn btn_warning" onclick = "closeMoal()"  style="background-color:#438EB9!important;border-color:#438EB9;">
					<span class="glyphicon glyphicon-remove"></span>关闭
				</button>
			</div>
			
		</div>
	</div>

</div>
<!-- 第一个model 结束 -->












		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			$(window).resize(function() {
			  	$("#sidebar").height($(window).height()-$("#navbar").height());
			  	$("div .tab-pane iframe").height($("#sidebar").height()-60);
			});

			
			
			
			
			$(function () {
				
				
				/* $.post("tMenus/findMenus.htm", {
					//THEME_TYPE : code
				},function(data) {
					$("#sidebar").height($(window).height()-$("#navbar").height()-40);	
					$('#menu').sidebarMenu({
						data:eval('(' + data + ')')
					});
					eval($("#menu_li_0 a").attr("href"));
				}); */
				var data ;
				if(parseInt("${user.role}")==1){ //管理员
					data=[{
					     id: '000',
					     text: '首页',
					     icon: 'fa fa-home fa-lg',
					     url: 'login/home.htm',
					    }, 
					    {id: '02',text: '老人信息管理', icon: 'fa fa-gg',url: 'TOld/TOldHtml.htm'},
					    {id: '03',text: '监护人信息管理', icon: 'fa fa-gg',url: 'TGuardian/TGuardianHtml.htm'},
					    {id: '04',text: '园丁信息管理', icon: 'fa fa-gg',url: 'TGardener/TGardenerHtml.htm'},
					   /*  {id: '05',text: '相关分析', icon: 'fa fa-gg',url: 'TSkill/TSkillHtml.htm'}, */
					    ]	
					
				}
			
				
						
				$("#sidebar").height($(window).height()-$("#navbar").height()-40);	
				   $('#menu').sidebarMenu({
				    data:data
				   }); 
				   eval($("#menu_li_000 a").attr("href"));
				   
				   
			  });
			
			
		/* 	 [{
			     id: '0',
			     text: '首页',
			     icon: 'icon-cog',
			     url: '',
			     menus: [{
			      id: '00',
			      text: '首页',
			      icon: 'icon-glass',
			      close: false,
			      url: 'index.html'
			     }]
			    }, {
			     id: '1',
			     text: '系统设置',
			     icon: 'icon-cog',
			     url: '',
			     menus: [{
			      id: '11',
			      text: '表单示例',
			      icon: 'icon-glass',
			      url: 'tables.html'
			     }]
			    }, {
			     id: '2',
			     text: '基础数据',
			     icon: 'icon-leaf',
			     url: '',
			     menus: [{
			      id: '21',
			      text: 'jqgrid表单',
			      icon: 'icon-glass',
			      url: 'jqgrid.html'
			     }, {
			      id: '22',
			      text: 'treeview',
			      icon: 'icon-glass',
			      url: 'treeview.html'
			     }, {
			      id: '23',
			      text: '物料维护',
			      icon: 'icon-glass',
			      url: '/Model/Index'
			     }, {
			      id: '24',
			      text: '站点管理',
			      icon: 'icon-glass',
			      url: '/Station/Index'
			     }]
			    }, {
			     id: '3',
			     text: '权限管理',
			     icon: 'icon-user',
			     url: '',
			     menus: [{
			      id: '31',
			      text: '用户管理',
			      icon: 'icon-user',
			      url: '/SystemSetting/User'
			     }, {
			      id: '32',
			      text: '角色管理',
			      icon: 'icon-apple',
			      url: '/SystemSetting/Role'
			     }, {
			      id: '33',
			      text: '菜单管理',
			      icon: 'icon-list',
			      url: '/SystemSetting/Menu'
			     }, {
			      id: '34',
			      text: '部门管理',
			      icon: 'icon-glass',
			      url: '/SystemSetting/Department'
			     }]
			    }, {
			     id: '4',
			     text: '订单管理',
			     icon: 'icon-envelope',
			     url: '',
			     menus: [{
			      id: '41',
			      text: '订单查询',
			      icon: 'icon-glass',
			      url: '/Order/Query'
			     }, {
			      id: '42',
			      text: '订单排产',
			      icon: 'icon-glass',
			      url: '/Order/PLANTPRODUCT'
			     }, {
			      id: '43',
			      text: '订单撤排',
			      icon: 'icon-glass',
			      url: '/Order/cancelPRODUCT'
			     }, {
			      id: '44',
			      text: '订单HOLD',
			      icon: 'icon-glass',
			      url: '/Order/hold'
			     }, {
			      id: '45',
			      text: '订单删除',
			      icon: 'icon-glass',
			      url: '/Order/delete'
			     }, {
			      id: '47',
			      text: '订单插单',
			      icon: 'icon-glass',
			      url: '/Order/insertorder'
			     }, {
			      id: '48',
			      text: '订单导入',
			      icon: 'icon-glass',
			      url: '/Order/Import'
			     }, {
			      id: '47',
			      text: '订单插单',
			      icon: 'icon-glass',
			      url: '/Order/insertorder'
			     }]
			    }] */
			    
		function logout(){
			bootbox.confirm({
				size:"small",
				title:"提示",
				message:"确认退出吗？",
				callback:function(result){
					if(result){
						
						window.location.href="login/logout.htm"
					}
				}
			});
			
		}
		
		function editPwd(){
			$('#setModal').modal('show');
		}
		function closeMoal(){
			$('#setModal').modal('hide');
		}  
		
		function editPassword(){
			var password = $('#password').val();
			if(password == ""){
				message.alert("请输入新密码");
				return;
			}
			
			$.post("login/editPassword.htm", {password:password} ,function(data) {
				var obj = eval('('+data+')');
				message.alert(data.showInfo);
				
			});
		} 
		
		</script>
</body>
</html>

