<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login Page</title>
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
<h3>USER LOGIN</h3>
<c:if test="${err!= null }">
<p>${err}</p>
</c:if>
<s:url var="url_login" value="/login" ></s:url>
<s:url var="url_register" value="/reg_form"></s:url>
<f:form action="${url_login}" modelAttribute="command">
<table border="1">
<tr>
<td>Username</td>
<td><f:input path="loginName"/></td>
</tr>
<tr>
<td>Passowrd</td>
<td><f:password path="password"/></td>
</tr>
<tr>
<td colspan="2" align="right"><button>Login</button><br/>
<a href="${url_register}">New User Registeration</a>
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