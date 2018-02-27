<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Dashboard Page</title>
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
<h1>USER DASHBOARD</h1>
TO-DO html 

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