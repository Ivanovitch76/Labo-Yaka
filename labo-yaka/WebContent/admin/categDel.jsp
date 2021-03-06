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

<c:set var="l" value="${requestScope['listeCat']}"/>
<fieldset>
<legend><b>Supprimez une catégorie</b></legend> 
	<c:forEach var="c" items="${l}">
		<a href="${pageContext.request.contextPath}/spring/delCateg?cId=${c.categorie.id}">
			<b><c:out value="${c.categorie.nom}"/></b>
		</a>
		<br/>
		<c:forEach var="sc" items="${c.prodBySousCat}">
			<a href="${pageContext.request.contextPath}/spring/delSsCateg?scId=${sc.sousCatgorie.id}">
				&emsp;<i><c:out value="${sc.sousCatgorie.nom}"/></i>
			</a>	
			<br/>
			<c:forEach var="p" items="${sc.produits}">
				<a href="${pageContext.request.contextPath}/spring/delProd?pId=${p.id}">
					&emsp;&emsp;<c:out value="${p.nom}"/>
				</a>	
				<br/>			
			</c:forEach>
		</c:forEach>
		<br/>
	</c:forEach>
</fieldset>

<a href="${pageContext.request.contextPath}/admin/menu.jsp">Retourner au menu</a>
</body>
</html>