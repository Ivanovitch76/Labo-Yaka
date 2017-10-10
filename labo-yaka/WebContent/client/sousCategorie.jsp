<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sous-Catégorie</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/monstyle.css" />
</head>
<body>

<a href="${pageContext.request.contextPath}/client/accueil.jsp">
	<img id="home" alt="Home" src="${pageContext.request.contextPath}/images/site/home.jpg"/>	
</a>

<img id="yaka" alt="Yaka" src="${pageContext.request.contextPath}/images/site/Yaka.JPG"/>	
 
<a href=${pageContext.request.contextPath}/spring/panierView>
	<img id="panier" alt="Panier" src="${pageContext.request.contextPath}/images/site/panier2.jpg"/>	
</a>

<fieldset>
<legend><b>Choisissez une sous-catégorie</b></legend>

<c:set var="ssCateg" value="${requestScope['listeSousCategories']}" />
<ul>
	<c:forEach var="sc" items="${ssCateg}">
		<li>
			<a href="${pageContext.request.contextPath}/spring/selectSsCateg?sousCateg=${sc.id}">
				<c:out value="${sc.nom}"/> 
			</a>	
		</li>
	</c:forEach>		  
</ul>
</fieldset>

</body>
</html>