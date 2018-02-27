<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD CONTACT</title>
<link href="static/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<s:url var="url_bg" value="/static/images/download.jpg"></s:url>
<body background= "${url_bg}">
<table border="1" width="80%" align="center">
<tr>
<td height="80px">
<%--Header--%>
<jsp:include page="include/header.jsp"></jsp:include>
</td>
</tr>
<tr>
<td height="25px">

<%--Menu--%>
<jsp:include page="include/Menu.jsp"></jsp:include>
</td>
</tr>
<tr>
<%--Main Body--%>
<td height="350px" valign="top">
<h1>CONTACT LIST</h1>
<table border="1" cellpadding="3">
<tr>
<th>SR</th>
<th>NAME</th>
<th>PHONE</th>
<th>EMAIL</th>
<th>ADDRESS</th>
<th>REMARK</th>
<th>ACTION</th>
</tr>
<c:if test="${empty contactlist}">
<tr>
<td>No records Present</td>
</tr>
</c:if>
<c:forEach items="${contactlist}" var="c" varStatus="st">
<tr>
<td>${st.count}</td>
<td>${c.name}</td>
<td>${c.phone}</td>
<td>${c.email}</td>
<td>${c.address}</td>
<td>${c.remark}</td>
<td>Edit|Delete</td>
</tr>
</c:forEach>
</table>
</td>
</tr>
<tr>
<%--Footer--%>
<td height="25spx">
<jsp:include page="include/footer.jsp"></jsp:include>
</td>
</tr>
</table>
</body>
</html>