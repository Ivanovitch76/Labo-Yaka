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
<legend><b>Choisissez vos statistiques</b></legend> 
		<a href="${pageContext.request.contextPath}/spring/statProdCroissant">			
			Produits par ordre croissant 
		</a>
		<br/>
		<a href="${pageContext.request.contextPath}/spring/statProdDecroissant">		
			Produits par ordre décroissant  
		</a>
</fieldset>

<a href="${pageContext.request.contextPath}/admin/menu.jsp">Retourner au menu</a>
</body>
</html>