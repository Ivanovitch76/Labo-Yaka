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

<h1>YAKA</h1>

<fieldset>
<legend><b>Détail du produit</b></legend>

<c:set var="p" value="${requestScope['afficheUnProduit']}" />
<ul>
	<li>
		<h2><c:out value="${p.nom}"/></h2> 
	</li>
	<li>	
		<a href="${pageContext.request.contextPath}/spring/detailProduit?prodId=${p.id}">	
			<img alt="${p.nom}" src="${pageContext.request.contextPath}/images/${p.image}"/>	
		</a>
	</li>
	<li>		
		<c:out escapeXml="false" value="${p.descLongue}"/> 									
	</li>
</ul>
</fieldset>
<br/>

<c:set var="prop" value="${requestScope['afficherProprietes']}"/>
	<c:choose>
		<c:when test="${fn:length(prop) > 1 }">
			<h3>Vous pouvez configurer votre produit</h3>
			<c:forEach items="${prop}" var="p">
				<li>
					<c:out value="${p.prop.nom}" /> 
					<select name="caracteristiques">
						<c:forEach var="c" items="${p.carac}">
							<option value="${c.id}"><c:out value="${c.valeur}" /></option>
						</c:forEach>
					</select>
				</li>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<c:forEach items="${prop}" var="p">
				<li>
					<h3><c:out value="${p.prop.nom}" /></h3> 
				</li>
			</c:forEach>
		</c:otherwise>
	</c:choose>
<br/>

<form action="${pageContext.request.contextPath}/spring/valider" method="post">
	<input type="hidden"  name="valid" value="${p.id}"/>
	<input type="submit" value="Ajouter au panier"/> 
</form>	
<br/>

<div class="content"><a href="${pageContext.request.contextPath}/spring/categories">Retour à la page d'accueil</a></div>
</body>
</html>