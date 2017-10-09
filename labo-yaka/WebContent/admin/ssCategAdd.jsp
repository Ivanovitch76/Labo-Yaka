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

<fieldset>
<legend><b>Entrez une nouvelle sous-cat�gorie</b></legend> 
	<form action="${pageContext.request.contextPath}/spring/addSsCateg" method="post">
		Nouvelle valeur: <input type="text" name="sscat"/>
		<input type="hidden" value="${requestScope['idCatMere']}" name="cid"/>
		<br/>

		<input type="submit" name="" value="Ajouter">
	</form>
</fieldset>

<fieldset>
<legend><b>S�lectionnez une sous-cat�gorie existante pour acc�der � ses produits</b></legend>
	<c:forEach var="sc" items="${requestScope['listeSsCat']}">
		<a href="${pageContext.request.contextPath}/spring/affProd?sscatId=${sc.id}">
			<c:out value="${sc.nom}"/>					
		</a>
		<br/>
	</c:forEach>
</fieldset>

<c:set var="c" value="${sessionScope['sessionAdmin'].connexion}"/>
<a href="${pageContext.request.contextPath}/admin/menu.jsp">Retourner au menu</a>
<%-- <a href="${pageContext.request.contextPath}/spring/menu?login=${c.login}&password=${c.password}">Retourner au menu 2</a> --%>
</body>
</html>