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

<img id="yaka" alt="Yaka" src="${pageContext.request.contextPath}/images/site/Yaka.JPG"/>	


	<fieldset>

	<c:set var="liste" value="${requestScope['liste']}"/>
	<legend><b>Vos commandes :</b></legend>
	<c:if test="${fn:length(liste) > 0 }">
	<ul>
		<c:forEach var="l" items="${liste}">
			<li>
				<b><c:out value="${l.produit.nom}"/></b>
				<img alt="${l.produit.nom}" src="${pageContext.request.contextPath}/images/catalogue/${l.produit.vignette}"/>	
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
				<a href="${pageContext.request.contextPath}/spring/selectProduit?produitId=${l.produit.id}">
					<input type="submit" name="" value="Modifier"/>
				</a>
				<a href="${pageContext.request.contextPath}/spring/remove?artId=${l.id}">
					<input type="submit" name="" value="Retirer"/>				
				</a>				
			</li>
			<br/>
		</c:forEach>
	</ul>
	</c:if>
	<c:if test="${fn:length(liste) == 0 }">
		<p>Vous n'avez aucun article pour le moment</p>
	</c:if>
	</fieldset>

<c:if test="${fn:length(liste)>0}">
<form action="${pageContext.request.contextPath}/spring/commande" method="post">
	<input type="submit" value="Je valide ma commande"/>
</form>
</c:if>

<form action="${pageContext.request.contextPath}/spring/categories" method="post">
	<input type="submit" value="Continuer mes achats"/>
</form>
</body>
</html>