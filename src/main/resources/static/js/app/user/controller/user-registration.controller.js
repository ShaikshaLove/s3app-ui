angular.module("user").controller("UserRegisterCtrl",function($scope,UserService){
	$scope.message="";
	$scope.showMessage=false;
	$scope.error=false;
	$scope.errors={};
	$scope.userData={};
	$scope.flag=true;
	$scope.submit=function(){
		$scope.flag=false;
		$scope.errors="";
		UserService.register($scope.userData).then(
				function(response){
					if(response.status===201){
						$scope.message=response.data;
						$scope.showMessage=true;
						$scope.flag=true;

					}else{
						$scope.errors=response.data; 
						$scope.error=true;
						$scope.flag=true;

					}
				},function(error){
					$scope.message=error.data;
					alert(error.status+" A technical error!!!!! please try again");
					$scope.flag=true;
				}
		);
	}	
});