
angular.module("NavBar").controller("NavbarCtrl",function($scope,$http){

	$scope.navbar={};
	var cartItems=[];
	$scope.hideHyperLinks=true;
	$http.get("/myaccount").then(function(response){
		$scope.navbar=response.data;
		console.log(response.data)
	},function(error){
		$scope.navbar=error.data;
	});
	
	$scope.logout=function(){
		$scope.hideHyperLinks=false;
	}
	$scope.showCopyRight=true;
	$scope.toggleClick=function(){
		
		if($scope.showCopyRight===true){
			$scope.showCopyRight=false;
		}else{
			$scope.showCopyRight=true;
		}
	}
	
});
