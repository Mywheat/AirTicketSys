<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>ok</title>
</head>
<body>
	OKOKOKOK<a href="logoutServlet">ע��</a>
	<a href="findTicket">�鿴��Ʊ</a>
	
	<%
	   String cid = null;
	   cid = (String)session.getAttribute("cid");
	   session.setAttribute("cid", cid);
	%>
	����,����ID��Ϊ<%=cid %>
    <br>
   <a href="findClientTicketServlet">�ҵĶ���</a> 
   
   
   
    <% 
   //   String cid = null;
	   cid = (String)session.getAttribute("cid");
	   session.setAttribute("cid", cid);
	%>
	����,����ID��Ϊ<%=cid %>
	<a href="findClientTicketServlet">�ҵĶ���</a>
</body>
</html>


 