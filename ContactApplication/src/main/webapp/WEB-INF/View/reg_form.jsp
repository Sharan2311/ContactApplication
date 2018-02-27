<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Page</title>
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
<h3>USER Registration</h3>
<c:if test="${err!= null }">
<p>${err}</p>
</c:if>
<s:url var="url_register" value="/register"></s:url>
<f:form action="${url_register}" modelAttribute="command">
<table border="1">
<tr>
<td>Username</td>
<td><f:input path="user.loginName"/></td>
</tr>
<tr>
<td>Name</td>
<td><f:input path="user.name"/></td>
</tr>
<tr>
<td>Passowrd</td>
<td><f:password path="user.password"/></td>
</tr>
<tr>
<tr>
<td>phone</td>
<td><f:input path="user.phone"/></td>
</tr>
<tr>
<td>Email</td>
<td><f:input path="user.email"/></td>
</tr>
<tr>
<td>Address</td>
<td><f:input path="user.address"/></td>
</tr>
<tr>
<td clospan="2" align="right"><button>Submit</button><br/>
</td>
</tr>
</table>
</f:form>

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