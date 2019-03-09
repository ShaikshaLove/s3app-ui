angular.module("ProductApp").controller("MyCartCtrl",function($scope,$window,ProductService){
	$scope.flag=true;
	$scope.productList={};
	ProductService.products().then(function(successResponse){
		if(successResponse.status===401||successResponse.status===302){
			$window.location.href="/login";}
		else{
		$scope.productList=successResponse.data;
		$scope.flag=false;}
	},function(errorResponse){
		if(errorResponse.status===401||errorResponse.status===302)
			$window.location.href="/login";
	});
	
