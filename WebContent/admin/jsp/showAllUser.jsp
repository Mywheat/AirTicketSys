<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.ClientDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
	<title>查看所有用户</title>
	<meta charset="GB2312" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="../assets/css/amazeui.css" />
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="../assets/css/core.css" />
	<link rel="stylesheet" href="../assets/css/menu.css" />
	<link rel="stylesheet" href="../assets/css/index.css" />
	<link rel="stylesheet" href="../assets/css/admin.css" />
	<link rel="stylesheet" href="../assets/css/page/typography.css" />
	<link rel="stylesheet" href="../assets/css/page/form.css" />
	<script>
    function allcheck(){
    	var checkObj = document.getElementsByName("check");
    	for(var i=0;i<checkObj.length;i++)
    		checkObj[i].checked = true;
    }
    function allnotcheck(){
    	var checkObj = document.getElementsByName("check");
    	for(var i=0;i<checkObj.length;i++)
    		checkObj[i].checked = false;
    }
    function backcheck(){
    	var checkObj = document.getElementsByName("check");
    	for(var i=0;i<checkObj.length;i++){
    		if(checkObj[i].checked == true)
    			checkObj[i].checked = false;
    		else
    			checkObj[i].checked = true;
    	}
    }
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
  		alert(arr);
	   	if(flag == true){
	   	    if(confirm("您确定要删除就这些记录吗?"))
	   		    location.href="../deleteCheckServlet?arr="+arr;
	   	}else
	   		alert("您至少选择一条记录，再进行删除");
   	}
  	function deleteOneCheck(){
  		var checkObj = document.getElementsByName("check");
  		var arr = [];
  		var flag = false;
  		for(var i=0; i<checkObj.length; i++){
      		if(checkObj[i].checked == true){
      			arr.push(checkObj[i].value);
      			flag = true;
      		}
  		}
  		alert(arr);
	   	if(flag == true){
	   	    if(confirm("您确定要删除这条记录吗?")){
	   		    location.href="../deleteClientServlet?arr="+arr;}
	   	}else
	   		alert("请您选择一条记录，再进行删除");
   	}
</script>
</head>
<body>
<!-- Begin page -->
		<header class="am-topbar am-topbar-fixed-top">		
			<div class="am-topbar-left am-hide-sm-only">
                <a href="index.html" class="logo"><span>您的账户<span><% 
						      String cname = null;
							   cname = (String)session.getAttribute("cname");
							   session.setAttribute("cname", cname);
							%>
		                    <%=cname %></span></span><i class="zmdi zmdi-layers"></i></a>
            </div>
	
			<div class="contain">
				<ul class="am-nav am-navbar-nav am-navbar-left">
					<li><h4 class="page-title"><font size=6px>机票订购后台管理系统</font></h4></li>
				</ul>
				
				<ul class="am-nav am-navbar-nav am-navbar-right">
					<li class="inform"><i class="am-icon-bell-o" aria-hidden="true" style="margin-right:20px"><font size=2px>欢迎 admin</font></i></li>
					<li class="hidden-xs am-hide-sm-only"> 
					<a href="../../logoutServlet"><font size=2px weight=5px><span  onmouseover="this.style.color='#0000FF'" onmouseout="this.style.color='#00CED1'"  style="color:#000000;"> 退出</span></font></a>													                      
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
						 <ul class="am-list admin-sidebar-list">
						    <li><a href="../index.jsp"><span class="am-icon-home"></span> 首页</a></li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-table"></span> 用户管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
						        <li><a href="../findAllUser" class="am-cf"> 查看用户</span></a></li>
						        <li><a href="insertUser.jsp">添加用户</a></li>
						      </ul>
						    </li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><i class="am-icon-line-chart" aria-hidden="true"></i> 机票管理<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
						        <li><a href="../findAllTicket" class="am-cf"> 查看机票</span></a></li>
						        <li><a href="insertTicket.jsp" class="am-cf"> 添加机票</span></a></li>
						      </ul>
						    </li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav5'}"><span class="am-icon-file"></span> 机票订单<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav5">
						        <li><a href="../findAllTicketpurchase" class="am-cf">查看机票订单</a></li>
						        <li><a href="insertTicketpurchase.jsp">增加订单</a></li>   
						      </ul>
						    </li>
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
				<p style="margin-bottom:20px;margin-left:20px"><font size=4px>所有用户</font></p>
					<!-- Row start -->
					<div class="am-g">					
						<div class="am-u-sm-12 am-u-md-6">
				          <div class="am-btn-toolbar">		                                    
				            <div class="am-btn-group am-btn-group-xs">
				              <button type="button" class="am-btn am-btn-default" onClick="window.open('insertUser.jsp')"><span class="am-icon-plus"></span> 新增</button>				       				           
				            </div>
				          </div>
				        </div>	
				        
						<div class="am-u-sm-12 am-u-md-3">
						<form action="../searchOneUserByAdmin">
				          <div class="am-input-group am-input-group-sm">				          
				            <input type="text" class="am-form-field" placeholder="请输入cid" value="" name="cid">
				           <span class="am-input-group-btn">
				            <button class="am-btn am-btn-default" type="submit">搜索</button>
				          </span>		         
				          </div>
				       </form>
				        </div>
				        
				     </div>
					  <!-- Row end -->
					  
					  <!-- Row start -->
<div class="am-g">
		<div class="am-u-sm-12">
          <form class="am-form">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
	              <tr>
	                <th></th><th class="table-id">ID</th><th class="table-title">姓名</th><th class="table-type">电话</th><th class="table-author am-hide-sm-only">密码</th><th class="table-date am-hide-sm-only">权限</th><th class="table-set">状态</th><th class="table-set">操作</th>
	              </tr>
              </thead>
	              <tbody>
			            <%
				            Vector<ClientDTO> v = new Vector<ClientDTO>();
				            v = (Vector<ClientDTO>)session.getAttribute("alluser");//这里的session与servlet的session一样
				            String id = null;
				            id = (String)session.getAttribute("exceptid");
				            Iterator it = v.iterator(); //遍历
				            ClientDTO c = null;
				            while(it.hasNext()){
				            	c = (ClientDTO)it.next();
				            	if(c.getStatus()!=1 && !c.getCid().equals(id) ){
			           %>
				        <tr>
				            <td><input type="checkbox" name="check" value=<%=c.getCid()%>/></td>
				            <td><%=c.getCid()%></td>
				            <td class="am-hide-sm-only"><%=c.getCname()%></td>
				            <td class="am-hide-sm-only"><%=c.getTel()%></td>
				            <td class="am-hide-sm-only"><%=c.getPassword()%></td>
				            <td class="am-hide-sm-only"><%=c.getSuperpassword()%></td>
				            <td class="am-hide-sm-only"><%=c.getStatus()%></td>  
				      <!--        <td><a href="../deleteClientServlet?cid=<%=c.getCid() %>">删除</a></td>--> 
				            <td>
				                  <div class="am-btn-toolbar">
				                    <div class="am-btn-group am-btn-group-xs">
				                      <button onClick="window.open('updateClientInfo.jsp?cid=<%=c.getCid()%>')"class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span>修改</button>
				                      <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onClick="deleteOneCheck();"><span class="am-icon-trash-o"></span>删除</button>
				                    </div>
				                  </div>	                  
				            </td>
				            
				        </tr>
				        <%
				            }}
				        %>
	              </tbody>
              </table>
        
              <button style="font-size:12px;" type="button"  onclick="allcheck();">全选</button>
              <button style="font-size:12px" type="button" onclick="allnotcheck();">不选</button>
              <button style="font-size:12px" type="button" onclick="backcheck();"> 反选</button>
              <button style="font-size:12px" type="button" onclick="deleteCheck();">批量删除</button> 
         
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
</html>