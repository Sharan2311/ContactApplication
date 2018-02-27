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
<h1>USER DASHBOARD</h1>
 <s:url var="url_contact" value="/contact"></s:url>
<f:form action="${url_contact}" modelAttribute="command">
<table border="1">
<tr>
<td>Name</td>
<td><f:input path="contact.name"/></td>
</tr>
<tr>
<tr>
<td>phone</td>
<td><f:input path="contact.phone"/></td>
</tr>
<tr>
<td>Email</td>
<td><f:input path="contact.email"/></td>
</tr>
<tr>
<td>Address</td>
<td><f:input path="contact.address"/></td>
</tr>
<tr>
<td>Remark</td>
<td><f:input path="contact.remark"/></td>
</tr>
<tr>
<td colspan="2" align="right"><button>SaveContact</button><br/>
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