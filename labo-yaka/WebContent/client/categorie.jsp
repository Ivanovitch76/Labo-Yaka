<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catégorie</title>
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
<legend><b>Choisissez une catégorie</b></legend> 

<c:set var="categ" value="${requestScope['listeCategories']}" />
<ul>
	<c:forEach var="c" items="${categ}">
		<li>
			<a href="${pageContext.request.contextPath}/spring/selectCateg?categId=${c.id}">
				<c:out value="${c.nom}"/> 
			</a>	
		</li>
	</c:forEach>		  
</ul>
</fieldset>
</body>
</html>