<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/monstyle.css" />
</head>
<body>

<h1>YAKA ADMINISTRATEUR</h1>                                           
<%-- <c:out value="${sessionScope['sessionAdmin'].connexion}"></c:out> --%>
<c:choose>
	<c:when test="${! empty sessionScope['sessionAdmin'].connexion}">
		<fieldset>
			<legend><b>Menu</b></legend> 
			<a href="${pageContext.request.contextPath}/spring/categAdd">			
				Ajouter des catégories ou produits
			</a>
			<br/>
			<a href="${pageContext.request.contextPath}/spring/categDel">		
				Supprimer des catégories ou produits
			</a>	
			<br/>
			<a href="${pageContext.request.contextPath}/admin/statCateg.jsp">
				Statistiques sur les catégories
			</a>	
			<br/>
			<a href="${pageContext.request.contextPath}/admin/statProd.jsp">
				Statistiques sur les produits
			</a>	
			<br/>
		</fieldset>
	</c:when>
	<c:otherwise>
		<fieldset>
		<legend><b>Entrez votre login et votre password</b></legend> 

			<form action="${pageContext.request.contextPath}/spring/menu" method="post">
				Login: <input type="text" name="login"/>
				<br/>
				Password: <input type="text" name="password"/>
				<br/>
				<input type="submit" name="" value="Envoyer">
			</form>
		</fieldset>
		<h3>Login et/ou password incorrect</h3>
	</c:otherwise>
</c:choose>

</body>
</html>