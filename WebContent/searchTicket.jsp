<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.TicketDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>机票订购系统</title>
<meta charset="GB2312" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="assets/css/amazeui.css" />
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/core.css" />
	<link rel="stylesheet" href="assets/css/menu.css" />
	<link rel="stylesheet" href="assets/css/index.css" />
	<link rel="stylesheet" href="assets/css/admin.css" />
	<link rel="stylesheet" href="assets/css/page/typography.css" />
	<link rel="stylesheet" href="assets/css/page/form.css" />
	<script>
	function deleteCheck(){
  		var checkObj = document.getElementsByName("check");
  		var arr = [];
  		var flag = false;
  		for(var i=0; i<checkObj.length; i++){
      		if(checkObj[i].checked == true){
      			arr.push(checkObj[i].value);
      			flag = true;
      		}
  		}

  		var date = new Date(); //创建时间对象  
   		var year = date.getFullYear(); //获取年   
   		var month = date.getMonth()+1;//获取月
   		var day = date.getDate(); //获取当日  
   		
   		var time = "/"+year+"-"+month+"-"+day; //组合时间  

	   	if(flag == true){
	   	    if(confirm("您确定要购买吗?")){
	   		    location.href="clientTicketpurchaseServlet?arr="+arr+time; //把时间和ID号放一起传进去
	   	    }
	   	}else
	   		alert("您至少选择一条记录，再购买");
   	}
</script>
</head>
<body>
<!-- Begin page -->
		<header class="am-topbar am-topbar-fixed-top">		
			<div class="am-topbar-left am-hide-sm-only">
                <a href="main.html" class="logo"><span>欢迎<span>您</span></span><i class="zmdi zmdi-layers"></i></a>
            </div>
	
			<div class="contain">
				<ul class="am-nav am-navbar-nav am-navbar-left">

					<li><h4 class="page-title">搜索机票</h4></li>
				</ul>
				
				<ul class="am-nav am-navbar-nav am-navbar-right">
					<li class="inform"><i class="am-icon-bell-o" aria-hidden="true" style="margin-right:20px"><font size=2px>欢迎</font></i></li>			
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
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}" href="findClientTicketServlet"><i class="am-icon-line-chart" aria-hidden="true" ></i> 查看订单</a>
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
				<div class="card-box">
					<!-- Row start -->
					<div class="am-g"  style="margin-top:50px">
						<div class="am-u-sm-12 am-u-md-6">
				          <div class="am-btn-toolbar">
				            <div class="am-btn-group am-btn-group-xs">				            
				            </div>
				          </div>
				        </div>	
				        
						<div class="am-u-sm-12 am-u-md-3">
						<form action="searchTicketServlet">
				          <div class="am-input-group am-input-group-sm">
				            <input type="text" name="destination" class="am-form-field" placeholder="目的地" value="">
				          <span class="am-input-group-btn">
				            <input class="am-btn am-btn-default"  type="submit" value="搜索">
				          </span>
				         </form>
				          </div>
				        </div>
				     </div>
					  <!-- Row end -->
					  
					  <!-- Row start -->
					  <br><br>
<div class="am-g">
		<div class="am-u-sm-12">
          <form class="am-form">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
	              <tr>
	                <th></th><th class="table-id">ID</th><th class="table-title">航班号</th><th class="table-type">目的地</th><th class="table-author am-hide-sm-only">起飞时间</th><th class="table-date am-hide-sm-only">价格</th><th class="table-date am-hide-sm-only">余量</th><th class="table-set">状态</th>
	              </tr>
              </thead>
	              <tbody>
			            <%
				            Vector<TicketDTO> v = new Vector<TicketDTO>();
				            v = (Vector<TicketDTO>)session.getAttribute("search");//这里的session与servlet的session一样
				            Iterator it = v.iterator(); //遍历
				            TicketDTO c = null;
				            while(it.hasNext()){
				            	c = (TicketDTO)it.next();
				            	if(c.getStatus()!=1){
			           %>
			           <td>
				            <input type="checkbox" name="check" value=<%=c.getTid()%>></td>
				            <td><%=c.getTid()%></td>
				            <td class="am-hide-sm-only"><%=c.getFlightNumber()%></td>
				            <td class="am-hide-sm-only"><%=c.getDestination()%></td>
				            <td class="am-hide-sm-only"><%=c.getOffDate()%></td>
				            <td class="am-hide-sm-only"><%=c.getPrice()%></td>
				            <td class="am-hide-sm-only"><%=c.getAllowance()%></td>
				            <td class="am-hide-sm-only"><%=c.getStatus()%></td>				
				        <tr>			            
				        </tr>
				        <%
				            }}
				        %>
	              </tbody>
              </table>
              <button style="font-size:12px" type="button" onclick="deleteCheck();">购买</button> 
         
            </form>
           </div>
           </div>
      </div>
     </div>
    </div>
  </div>
	      
            <!-- navbar -->
		<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>
		
		<script type="text/javascript" src="../assets/js/jquery-2.1.0.js" ></script>
		<script type="text/javascript" src="../assets/js/amazeui.min.js"></script>
		<script type="text/javascript" src="../assets/js/app.js" ></script>
		<script type="text/javascript" src="../assets/js/blockUI.js" ></script>
</body>
</body>
</html>