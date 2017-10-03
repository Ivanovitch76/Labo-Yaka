<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panier</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/monstyle.css" />
</head>
<body>

<h1>YAKA</h1> 

<fieldset>

<c:set var="liste" value="${requestScope['liste']}"/>
<legend><b>Vos commandes :</b></legend>
	<ul>
		<c:forEach var="l" items="${liste}">
			<li>
				<b><c:out value="${l.produit.nom}"/></b>
				<img alt="${l.produit.nom}" src="${pageContext.request.contextPath}/images/${l.produit.vignette}"/>	
				<br/>
				Caractéristiques : 
				<c:forEach var="c" items="${l.caracteristiques}">
					<c:out value="${c.proprieteId.nom}"/>
					<c:if test="${c.proprieteId.id != 2}">
					<span>=</span>
					<c:out value="${c.valeur}"/>
					</c:if>
				</c:forEach>
				
				<br/>
				Prix unitaire: <b><c:out value="${l.prixHtva}"/></b>
				Quantité: <b><c:out value="${l.quantite}"/></b>	
				Prix total: <b><c:out value="${l.somme}"/></b>	
				<br/>
				<input type="button" value="Modifier"/>
				<input type="submit" value="Retirer"/>
			</li>
			<br/>
		</c:forEach>
	</ul>
</fieldset>


<div class="content"><a href="${pageContext.request.contextPath}/spring/categories">Continuer mes achats</a></div>
</body>
</html>