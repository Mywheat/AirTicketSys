	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="aa" uri="/mytagstest" %>
<%@ taglib prefix="c" uri="/jstlc" %>
<%@ taglib prefix="sql" uri="/jstlsql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <aa:hello/>
  <br>
  <c:set var="a" value="aaa"/>
  <c:out value="${a}"/>
  <c:remove var="a"/>
  <c:out value="${a}"/>
  <c:catch var="b">
      <%=9/0%>
  </c:catch>
  <c:out value="${b}"/>
  <%
      String[] str= new String[5];
      str[0] = "aaaaa";
      str[1] = "bbbbb";
      str[2] = "ccccc";
      str[3] = "ddddd";
      str[4] = "eeeee";
      request.setAttribute("st", str);
  %>
  <c:out value="${st[2]}"/>
  <c:if test="${st[2]=='ccccc'}">
      ccccccccccccccc
  </c:if>
  <br>
  <c:forEach var="c" items="${st}">
      <c:out value="${c}"/>
  </c:forEach>
  <c:choose>
      <c:when test="${st[2]=='ccacc'}">
          dddddddddddddddddddddddd
      </c:when>
      <c:otherwise>
          eeeeeeeeeeeeeeeeeeeeeeee
      </c:otherwise>
  </c:choose>
  
  
  <br>
  <c:forEach var="c" items="${st}">
      <c:out value="${c}"/>
  </c:forEach>
  <c:forEach var="d" begin="1" end="4">
      <c:out value="${d}"/>
  </c:forEach>
  <br>
  <c:forTokens var="e" items="zhangsan,lisi,wangwu,zhaolu" delims=",">
      <c:out value="${e}"/>
  </c:forTokens>
  <a href="<c:url value="http://www.qq.com"/>">
      qqqqqq
  </a>
  <a href="http://www.qq.com">
      wwwww
  </a>
  <br>
  <c:url var="f" value="http://www.qq.com">
    <c:param name="sname" value="zhangshan"/>
  </c:url>
  <a href="${f}">
      nnnnn
  </a>
  <br>
  <c:import url="/Ok.html"/>
  <br><br>
  
  <sql:setDataSource
      driver="com.mysql.jdbc.Driver"
      url="jdbc:mysql://localhost:3306/plane"
      user="root"
      password="123456"
      var="aaa"
  />
  <sql:query var="result" dataSource="${aaa}"
      sql="select * from client"
  />
  <table border="1">
      <c:forEach var="g" items="${result.rows}">
      <tr>
       <td><c:out value="${g.cid}"/></td>
       <td><c:out value="${g.cname}"/></td>
       <td><c:out value="${g.tel}"/></td>
       <td><c:out value="${g.password}"/></td>
       <td><c:out value="${g.superpassword}"/></td>
       <td><c:out value="${g.status}"/></td>
      </tr>
      </c:forEach>
  </table>
  <sql:update dataSource="${aaa}"
      sql="update client set tel='555' where cid='c03'"
  />
  <sql:query var="result" dataSource="${aaa}"
      sql="select * from client"
  />
  <table border="1">
      <c:forEach var="h" items="${result.rows}">
      <tr>
       <td><c:out value="${h.cid}"/></td>
       <td><c:out value="${h.cname}"/></td>
       <td><c:out value="${h.tel}"/></td>
       <td><c:out value="${h.password}"/></td>
       <td><c:out value="${h.superpassword}"/></td>
       <td><c:out value="${h.status}"/></td>
      </tr>
      </c:forEach>
  </table>
</body>
</html>