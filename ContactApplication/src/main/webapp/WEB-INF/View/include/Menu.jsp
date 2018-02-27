<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<s:url var="url_logout" value="/logout"></s:url>
<s:url var="url_register" value="/reg_form"></s:url>
<s:url var="url_login" value="/index" ></s:url>
<s:url var="add_contact" value="/contact_form" ></s:url>
<s:url var="list_contact" value="/contactlist_form" ></s:url>
<s:url var="url_home" value="/home" ></s:url>
<c:if test="${sessionScope.userId==null}">
<a href="${url_login}">LOGIN</a> | <a href="${url_register}">REGISTER</a>  | <a href="#">ABOUT</a> 
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.role==1}">
<a href="${url_home}">HOME</a> | <a href="#">USER LIST</a> | <a href="${url_logout}">LogOut</a>
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.role==2}">
<a href="${url_home}">HOME</a> | <a href="${add_contact}">AddContact</a> | <a href="${list_contact}">ContactList</a> | <a href="${url_logout}">LogOut</a>
</c:if>