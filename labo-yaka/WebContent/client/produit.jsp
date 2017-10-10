<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produit</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/monstyle.css" />
</head>
<body>
<a href="${pageContext.request.contextPath}/client/accueil.jsp">
	<img id="home" alt="Home" src="${pageContext.request.contextPath}/images/site/home.jpg"/>	
</a>>

<img id="yaka" alt="Yaka" src="${pageContext.request.contextPath}/images/site/Yaka.JPG"/>	
 
<a href=${pageContext.request.contextPath}/spring/panierView>
	<img id="panier" alt="Panier" src="${pageContext.request.contextPath}/images/site/panier2.jpg"/>	
</a>

<fieldset>
<legend><b>Choisissez un produit</b></legend>  
 
<c:set var="produits" value="${requestScope['listeProduits']}" />

<ul>
	<c:forEach var="p" items="${produits}">
		<li>
			<b><c:out value="${p.nom}"/></b>
		</li>
		<li>	
			<a href="${pageContext.request.contextPath}/spring/selectProduit?produitId=${p.id}">
				<img alt="${p.nom}" src="${pageContext.request.contextPath}/images/catalogue/${p.vignette}"/>	
						
			</a>	
		</li>
		<li>		
			<c:out value="${p.descCourte}"/> 								
	
		</li>
		<br/>
	</c:forEach>		  
</ul>
</fieldset>


</body>
</html>