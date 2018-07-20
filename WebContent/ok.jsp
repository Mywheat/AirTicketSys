<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>ok</title>
</head>
<body>
	OKOKOKOK<a href="logoutServlet">注销</a>
	<a href="findTicket">查看机票</a>
	
	<%
	   String cid = null;
	   cid = (String)session.getAttribute("cid");
	   session.setAttribute("cid", cid);
	%>
	您好,您的ID号为<%=cid %>
    <br>
   <a href="findClientTicketServlet">我的订单</a> 
   
   
   
    <% 
   //   String cid = null;
	   cid = (String)session.getAttribute("cid");
	   session.setAttribute("cid", cid);
	%>
	您好,您的ID号为<%=cid %>
	<a href="findClientTicketServlet">我的订单</a>
</body>
</html>


 