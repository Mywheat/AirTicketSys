<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.TicketDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Insert title here</title>
</head>
<body>
<form action="insertTicketpurchase">
    <table border=1>
        <tr>
            <td></td>tid</td><td>航班号</td><td>目的地</td><td>起飞时间</td><td>价格</td><td>余量</td><td>状态</td><td></td>     
        </tr>
        <%
            Vector<TicketDTO> v = new Vector<TicketDTO>();
            v = (Vector<TicketDTO>)session.getAttribute("allticket");//这里的session与servlet的session一样
            Iterator it = v.iterator(); //遍历
            TicketDTO c = null;
            while(it.hasNext()){
            	c = (TicketDTO)it.next();
            	if(c.getStatus()!=1){
        %>
        <tr>
            <td><%=c.getTid()%></td>
            <td><%=c.getFlightNumber()%></td>
            <td><%=c.getDestination()%></td>
            <td><%=c.getOffDate()%></td>
            <td><%=c.getPrice()%></td>
            <td><%=c.getAllowance()%></td>
            <td><%=c.getStatus()%></td>
        </tr>
        <%
            }}
        %>
    </table>
</form>
</body>
</html>