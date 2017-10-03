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
		<img alt="${p.nom}" src="${pageContext.request.contextPath}/images/${p.image}"/>	
	</li>
	<li>		
		<c:out escapeXml="false" value="${p.descLongue}"/> 									
	</li>
</ul>
</fieldset>
<br/>

<c:set var="prop" value="${requestScope['afficherProprietes']}"/>
	<form action="${pageContext.request.contextPath}/spring/panier"
		method="post">
		<input type="hidden" name="valid" value="${p.id}" />
<!-- 		<h3>Vous pouvez configurer votre produit :</h3> -->

		<c:forEach items="${prop}" var="pr">
			<li>	
				<c:out value="${pr.prop.nom}" /> 
<%-- 				<c:choose> --%>
<%-- 					<c:when test="${pr.prop.id == 1}"> --%>
<!-- 						<select name="dimensions"> -->
<%-- 							<c:forEach var="c" items="${pr.carac}"> --%>
<%-- 								<option value="${c.id}"><c:out value="${c.valeur}" /></option> --%>
<%-- 							</c:forEach> --%>
<!-- 						</select> -->
<%-- 					</c:when> --%>
<%-- 					<c:when test="${pr.prop.id == 3}"> --%>
<!-- 						<select name="largeur"> -->
<%-- 							<c:forEach var="c" items="${pr.carac}"> --%>
<%-- 								<option value="${c.id}"><c:out value="${c.valeur}" /></option> --%>
<%-- 							</c:forEach> --%>
<!-- 						</select> -->
<%-- 					</c:when> --%>
<%-- 					<c:when test="${pr.prop.id == 4}"> --%>
<!-- 						<select name="hauteur"> -->
<%-- 							<c:forEach var="c" items="${pr.carac}"> --%>
<%-- 								<option value="${c.id}"><c:out value="${c.valeur}" /></option> --%>
<%-- 							</c:forEach> --%>
<!-- 						</select> -->
<%-- 					</c:when> --%>
<%-- 					<c:when test="${pr.prop.id == 5}"> --%>
<!-- 						<select name="profondeur"> -->
<%-- 							<c:forEach var="c" items="${pr.carac}"> --%>
<%-- 								<option value="${c.id}"><c:out value="${c.valeur}" /></option> --%>
<%-- 							</c:forEach> --%>
<!-- 						</select> -->
<%-- 					</c:when> --%>
<%-- 					<c:when test="${pr.prop.id == 6}"> --%>
<!-- 						<select name="revet"> -->
<%-- 							<c:forEach var="c" items="${pr.carac}"> --%>
<%-- 								<option value="${c.id}"><c:out value="${c.valeur}" /></option> --%>
<%-- 							</c:forEach> --%>
<!-- 						</select> -->
<%-- 					</c:when> --%>
						<select name="caracteristiques">
							<c:forEach var="c" items="${pr.carac}">
								<option value="${c.id}"><c:out value="${c.valeur}" /></option>
							</c:forEach>
						</select>					
<%-- 				</c:choose> --%>
			</li>
		</c:forEach>
		<c:if test="${fn:length(p.sousProduits) > 0 }">
			<h3>Sous-produits disponibles</h3>
			<c:forEach items="${p.sousProduits}" var="sp">
				<fieldset>
					<ul>
						<li><b><c:out value="${sp.nom}" /></b></li>
						<li><a
							href="${pageContext.request.contextPath}/spring/sousProduit?ssprodId=${sp.id}">
								<img alt="$s{p.nom}"
								src="${pageContext.request.contextPath}/images/${sp.vignette}" />
						</a></li>
						<li><c:out value="${sp.descCourte}" /></li>
					</ul>
				</fieldset>
			</c:forEach>
		</c:if>

		<br /> <input type="hidden" name="valid2" value="${c.id}" /> <input
			type="submit" value="Ajouter au panier" />
	</form>
	<br/>

<div class="content"><a href="${pageContext.request.contextPath}/spring/categories">Retour à la page d'accueil</a></div>
</body>
</html>