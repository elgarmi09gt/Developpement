<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Ajout produit</title>
</head>
<body> 
    <form method="POST" action='editproduitServletControleur' name="frmAddProduit">
        REFERENCE : <input type="text"  name="refid" value="<c:out value="${refProduit.reference}" />" /> <br /> 
        DESIGNATION : <input  type="text" name="designation" value="<c:out value="${refProduit.designation}" />" /><br /> 
        PRIX : <input type="text" name="prix" value="<c:out value="${refProduit.prix}" />" /><br />        
        QUANTITE : <input type="text" name="quantite" value="<c:out value="${refProduit.quantite}" />" /> <br />
        <input   type="hidden"  name="prodParam" value="ADD"/>
        <input  type="submit" value="ENREGISTRER" />
    </form>
</body>
</html>