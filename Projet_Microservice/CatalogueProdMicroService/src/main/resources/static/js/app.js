var app = angular.module("MyApp",[]);
app.controller("MyController", function($scope,$http){
	$scope.listeProduit = null;	
	$scope.txtDesignation = "";
	$scope.rechercherProduits = function(){
		$http.get("http://localhost:8080/listProduits?txtDesignation="+$scope.txtDesignation).then(successCallback, errorCallback);
		function successCallback(response){
			$scope.listeProduit = response.data;
		}
		function errorCallback(error){
		    //error code
		}
	}
	
})