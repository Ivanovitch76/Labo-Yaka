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
                                        
<div id="accueil">
<h1>Bonjour et bienvenue sur le site de vente en ligne <img id="yakaStart" alt="Yaka" src="${pageContext.request.contextPath}/images/site/Yaka.JPG"/></h1>

<h2>Cliquez sur le magasin pour commencer vos achats</h2>
</div>
<a href="${pageContext.request.contextPath}/spring/categories">
	<img id="shop" alt="Shop" src="${pageContext.request.contextPath}/images/site/shop.jpg">
</a>	

</body>
</html>