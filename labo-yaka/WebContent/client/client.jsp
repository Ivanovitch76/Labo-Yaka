<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/monstyle.css" />
</head>
<body>
<a href="${pageContext.request.contextPath}/client/accueil.jsp">
	<img id="home" alt="Home" src="${pageContext.request.contextPath}/images/site/home.jpg"/>	
</a>

<img id="yaka" alt="Yaka" src="${pageContext.request.contextPath}/images/site/Yaka.JPG"/>	

<c:set var="pays" value="${requestScope['listePays']}"/>
<fieldset>
<legend><b>Veuillez compléter le formulaire</b></legend>  

<form action="${pageContext.request.contextPath}/spring/addClient" method="post">
	Prénom: <input type="text" name="prenom"/>
	<br/>
	Nom: <input type="text" name="nom"/>
	<br/>
	Adresse: <input type="text" name="adresse"/>
	<br/>
	Code postal: <input type="text" name="cp"/>
	<br/>
	Localité: <input type="text" name="localite"/>
	<br/>
	Pays: 	<select name="nat">
				<c:forEach var="p" items="${pays}">
					<option value="${p.abrev}">
						<c:out value="${p.nom}"/>
					</option>				
				</c:forEach>
			</select>
	<br/>		
	Téléphone: <input type="text" name="phone"/> 	
	<br/>
	Numéro de carte de banque: <input type="text" name="carte"/>
	<br/>
	Date d'échéance: <input type="text" name="echeance" placeholder="dd-mm-yyyy"/>
	<br/>	
	Email: <input type="text" name="email">
	<br/>
	<input type="submit" value="Envoyer"/>
</form>
</fieldset>

</body>
</html>