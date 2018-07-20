<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.ClientDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=GB2312">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>个人资料</title>
		<link rel="stylesheet" href="assets/css/amazeui.css" />
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/core.css" />
		<link rel="stylesheet" href="assets/css/menu.css" />
		<link rel="stylesheet" href="assets/css/index.css" />
		<link rel="stylesheet" href="assets/css/admin.css" />
		<link rel="stylesheet" href="assets/css/page/typography.css" />
		<link rel="stylesheet" href="assets/css/page/form.css" />
</head>
<body>
<!-- Begin page -->
		<header class="am-topbar am-topbar-fixed-top">		
			<div class="am-topbar-left am-hide-sm-only">
                <a href="main.html" class="logo"><span>欢迎<span>您</span></span><i class="zmdi zmdi-layers"></i></a>
            </div>
	
			<div class="contain">
				<ul class="am-nav am-navbar-nav am-navbar-left">

					<li><h4 class="page-title">个人资料</h4></li>
				</ul>
				
				<ul class="am-nav am-navbar-nav am-navbar-right">
					<li class="inform"><i class="am-icon-bell-o" aria-hidden="true" style="margin-right:20px"><font size=2px>您的账户
					        <% 
						      String cname = null;
							   cname = (String)session.getAttribute("cname");
							   session.setAttribute("cname", cname);
							%>
		                    <%=cname %></font></i></li>			
					<li class="hidden-xs am-hide-sm-only"> 
					<a href="logoutServlet"><font size=2px weight=5px><span  onmouseover="this.style.color='#0000FF'" onmouseout="this.style.color='#00CED1'"  style="color:#000000;"> 退出</span></font></a>													                      
                    </li>
				</ul>
			</div>
		</header>
		<!-- end page -->
<div class="admin">
			<!--<div class="am-g">-->
		<!-- ========== Left Sidebar Start ========== -->
		<!--<div class="left side-menu am-hide-sm-only am-u-md-1 am-padding-0">
			<div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 548px;">
				<div class="sidebar-inner slimscrollleft" style="overflow: hidden; width: auto; height: 548px;">-->
                  <!-- sidebar start -->
				  <div class="admin-sidebar am-offcanvas  am-padding-0" id="admin-offcanvas">
				    <div class="am-offcanvas-bar admin-offcanvas-bar">
				    	<!-- User -->
						<div class="user-box am-hide-sm-only">
	                        <div class="user-img">
	                            <img src="assets/img/avatar-1.jpg" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive">
	                            <div class="user-status offline"><i class="am-icon-dot-circle-o" aria-hidden="true"></i></div>
	                        </div>
	                        <h5><a href="#">Mat Helme</a> </h5>
	                        <ul class="list-inline">
	                            <li>
	                                <a href="#">
	                                    <i class="am-icon-cog" aria-hidden="true"></i>
	                                </a>
	                            </li>
	
	                            <li>
	                                <a href="#" class="text-custom">
	                                    <i class="am-icon-cog" aria-hidden="true"></i>
	                                </a>
	                            </li>
	                        </ul>
	                    </div>
	                    <!-- End User -->
	            
						 <ul class="am-list admin-sidebar-list">
						   <li><a href="main.html"><span class="am-icon-home"></span> 首页</a></li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}" href="findTicket"><span class="am-icon-table"></span> 查看机票</a>
						    </li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}" href="findClientTicketServlet"><i class="am-icon-line-chart" aria-hidden="true" ></i> 查看订单</a>
						    </li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav5'}" href="findOneUserInfo" href="findOneUserInfo"><span class="am-icon-file"></span> 个人资料</a>
						  </ul>
				</div>
				  </div>
				  <!-- sidebar end -->
<!--	<div class="am-g">-->
		<!-- ============================================================== -->
		<!-- Start right Content here -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="am-g">
					<!-- Row start -->
						<div class="am-u-sm-12">
							<div class="card-box">
								<ul class="am-nav am-fr">
								  <li class="am-dropdown" data-am-dropdown>
								    <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
								       <span class="am-icon-caret-down"></span>
								    </a>
								    <ul class="am-dropdown-content">
								      <li>1231234</li>
								      <li>1231234</li>
								      <li>1231234</li>
								      <li>1231234</li>
								    </ul>
								  </li>
								</ul>
								
								<form action="updateUserByself" class="am-form" data-am-validator>
								  <fieldset>
								    <legend>个人资料</legend>
								        <%
								            Vector<ClientDTO> v = new Vector<ClientDTO>();
								            v = (Vector<ClientDTO>)session.getAttribute("oneuser");//这里的session与servlet的session一样
								            Iterator it = v.iterator(); //遍历
								            ClientDTO c = null;
								            while(it.hasNext()){
								            	c = (ClientDTO)it.next();
								            	if(c.getStatus()!=1){
								        %>
								        <tr>
								            <div class="am-form-group">
										    <label for="doc-vld-name-2">用户ID</label>
								            <input type="text" readOnly="true" id="doc-vld-name-2" minlength="3" placeholder="" value="<%=c.getCid()%>"required/>
										    </div>
										     <div class="am-form-group">
										    <label for="doc-vld-name-2">用户名</label>
								            <input type="text" id="doc-vld-name-2" minlength="3"  placeholder="" value="<%=c.getCname()%>"required/>
										    </div>
										     <div class="am-form-group">
										    <label for="doc-vld-name-2">电话</label>
								            <input type="text" id="doc-vld-name-2" minlength="3" placeholder="" value="<%=c.getTel()%>"required/>
										    </div>
										     <div class="am-form-group">
										    <label for="doc-vld-name-2">权限</label>
								            <input type="text" id="doc-vld-name-2" minlength="3"  placeholder="" value="<%=c.getSuperpassword()%>"required/>
										    </div>
										     <div class="am-form-group">
										    <label for="doc-vld-name-2" readOnly="true">状态</label>
								            <input type="text" id="doc-vld-name-2" minlength="3" placeholder="" value="<%=c.getStatus()%>"required/>
										    </div>     
								        </tr>
								        <%
								            }}
								        %>                                            
								  </fieldset>
								</form>
								
								
							</div>
						</div>
					<!-- Row end -->
				</div>
			
			
			
			
			</div>
		</div>
		<!-- end right Content here -->				  

		<!-- navbar -->
		<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>
		
		<script type="text/javascript" src="assets/js/jquery-2.1.0.js" ></script>
		<script type="text/javascript" src="assets/js/amazeui.min.js"></script>
		<script type="text/javascript" src="assets/js/app.js" ></script>
		<script type="text/javascript" src="assets/js/blockUI.js" ></script>
		<script type="text/javascript" src="assets/js/charts/echarts.min.js" ></script>
		<script type="text/javascript" src="assets/js/charts/indexChart.js" ></script>				  

</body>
</html>