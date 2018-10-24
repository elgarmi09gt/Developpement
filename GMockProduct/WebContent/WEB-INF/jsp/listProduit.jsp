<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des produits</title>
</head>
<body>
	<a href="produitServletControleur?action=addProduits"> <button type="button" name="addProduit"><img src="images/add.png" />Nouveau produit</button></a>
	<table border=1>
       <thead>
            <tr>
                <th>REFERENCE</th>
                <th>DESIGNATION</th>
                <th>PRIX</th>
                <th>QUANTITE</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
             <c:forEach items="${produits}" var="myproduit">
                <tr>
                    <td><c:out value="${myproduit.reference}" /></td>
                    <td><c:out value="${myproduit.designation}" /></td>
                    <td><c:out value="${myproduit.prix}" /></td>
                    <td><c:out value="${myproduit.quantite}" /></td>
                    <td><a href="produitServletControleur?action=editProduits&prodRef=<c:out value="${myproduit.reference}"/>"><img src="images/pencil-small.png" /></a></td>
                    <td><a href="produitServletControleur?action=deleteProduits&prodRef=<c:out value="${myproduit.reference}"/>"><img src="images/delete.png" /></a></td>
                </tr>
            </c:forEach>
            
            </table>
</body>
</html>