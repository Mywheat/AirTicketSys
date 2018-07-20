<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>首页</title>
        <meta charset="GB2312" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>机票订购系统</title>
		<link rel="stylesheet" href="assets/css/amazeui.css" />
		<link rel="stylesheet" href="assets/css/core.css" />
		<link rel="stylesheet" href="assets/css/menu.css" />
		<link rel="stylesheet" href="assets/css/index.css" />
		<link rel="stylesheet" href="assets/css/admin.css" />
		<link rel="stylesheet" href="assets/css/page/typography.css" />
		<link rel="stylesheet" href="assets/css/page/form.css" />
		<link rel="stylesheet" href="assets/css/component.css" />
</head>
<body>
<!-- Begin page -->
		<header class="am-topbar am-topbar-fixed-top">		
			<div class="am-topbar-left am-hide-sm-only">
                <a href="index.html" class="logo"><span>欢迎<span></span>您</span><i class="zmdi zmdi-layers"></i></a>
                
            </div>
	
			<div class="contain">
			
				<ul class="am-nav am-navbar-nav am-navbar-left">

					<li><h4 class="page-title"><font size=6px>欢迎订购机票</font></h4></li>
				</ul>
				<ul class="am-nav am-navbar-nav am-navbar-right">
				
					<li class="inform">
						<i class="am-icon-bell-o" aria-hidden="true" style="margin-right:20px">
						  <font size=2px>您的账户
						    <% 
						      String cname = null;
							   cname = (String)session.getAttribute("cname");
							   session.setAttribute("cname", cname);
							%>
		                    <%=cname %>
		                  </font>
		                  </i>
		             </li>										    
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
	                                    <i class="fa fa-cog" aria-hidden="true"></i>
	                                </a>
	                            </li>
	
	                            <li>
	                                <a href="#" class="text-custom">
	                                    <i class="fa fa-cog" aria-hidden="true"></i>
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
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}" href="findClientTicketServlet"><i class="am-icon-line-chart" aria-hidden="true" ></i> 机票订单</a>
						    </li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav5'}" href="findOneUserInfo"><span class="am-icon-file"></span> 个人资料</a>
						   
						  </ul>
				</div>
				  </div>
				  <!-- sidebar end -->
    
				<!--</div>
			</div>
		</div>-->
		<!-- ========== Left Sidebar end ========== -->                    
		<!--	<div class="am-g">-->
		<!-- ============================================================== -->
		<!-- Start right Content here -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="am-g">
					<!-- Row start -->
						<div class="am-u-md-3">
							<div class="card-box">
								<h4 class="header-title m-t-0 m-b-30">湛江-广州</h4>
								<div class="widget-chart-1 am-cf">
                                    <img src="images/plane.jpg" height=100>
                                </div>
							</div>
						</div>
						<!-- col end -->
						<div class="am-u-md-3">
							<div class="card-box">
								<h4 class="header-title m-t-0 m-b-30">湛江-深圳</h4>
								<img src="images/p4.jpg" height=100>
							</div>
						</div>
						<!-- col end -->
						<div class="am-u-md-3">
							<div class="card-box">
								<h4 class="header-title m-t-0 m-b-30">湛江-上海</h4>
								<img src="images/p3.jpg" height=100>
							</div>
						</div>
						<!-- col end -->
						<div class="am-u-md-3">
							<div class="card-box">
								<h4 class="header-title m-t-0 m-b-30">湛江-杭州</h4>
								<img src="images/p5.jpg" height=100>
							</div>
						</div>
					<!-- Row end -->
				</div>
				
				<div class="am-g">
					<!-- Row start -->
					<div class="am-u-md-4">
						<div class="card-box">
							<h4 class="header-title m-t-0">湛江-北京</h4>
							<img src="images/p6.jpg" height=100>
						</div>
					</div>
					
					<div class="am-u-md-4">
						<div class="card-box">
							<h4 class="header-title m-t-0">湛江-浙江</h4>
							<img src="images/p7.jpg" height=100>
						</div>
					</div>
					
					<div class="am-u-md-4">
						<div class="card-box">
							<h4 class="header-title m-t-0">湛江-湖南</h4>
							<img src="images/p8.jpg" height=100>
						</div>
					</div>
					<!-- Row end -->
				</div>
				
				
			
				
			</div>
		</div>
		<!-- end right Content here -->
		<!--</div>-->
		</div>
		</div>
		
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