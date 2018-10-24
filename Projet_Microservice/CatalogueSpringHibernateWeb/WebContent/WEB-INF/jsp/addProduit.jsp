<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produit</title>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
</head>
<body> 
		<%@include file="header.jsp" %>
	<p></p>
	<div class="container col-md-6 col-md-offset-2">
	<div class="panel panel-primary">
	<div class="panel-heading">Modification d'un Produit</div>
	<div class="panel-body">
    <form:form action="saveProduit.mvc" method="post" modelAttribute="produit">
    <div class="form-group">		
    <table>
	     <tr><td><label class="control-label">REFERENCE</label></td><td><form:input  path="reference" required="required" class="form-control"/></td></tr>
		 <tr><td><label class="control-label">DESIGNATION</label></td><td><form:input  path="designation" required="required" class="form-control"/></td></tr>
		 <tr><td><label class="control-label">PRIX</label></td><td><form:input path="prix" required="required" class="form-control"/> </td></tr>
		 <tr><td><label class="control-label">QUANTITE</label></td><td><form:input  path="quantite" required="required" class="form-control"/></td></tr>  
		 <tr><td colspan="2" align="center"><input  type="submit" value="ENREGISTRER" class="btn btn-success"/></td></tr>
    </table>
    </div>
     </form:form>
    </div>
	</div>
	</div>
</body>
</html>