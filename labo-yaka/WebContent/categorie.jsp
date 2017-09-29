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

<h1>YAKA</h1>

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