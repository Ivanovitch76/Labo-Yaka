<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/monstyle.css" />
</head>
<body>

<h1>YAKA ADMINISTRATEUR</h1>                                           

<fieldset>
<legend><b>Produits consultés (résultat croissant)</b></legend> 
	<c:forEach var="p" items="${requestScope['croissant']}">
		<c:out value="${p.nom}"/>
		<c:out value="${p.stat}"></c:out>
		<br/>
	</c:forEach>
</fieldset>

<a href="${pageContext.request.contextPath}/admin/menu.jsp">Retourner au menu</a>
</body>
</html>