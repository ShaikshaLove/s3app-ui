angular.module("user").controller("UserDataCtrl", ['$scope', '$window','UserService' ,function($scope, $window,UserService) {	
	$scope.users={};

	UserService.getUsers().then(
			function(response){
				$scope.users=response.data;
			},
			function(error){
				alert('Error in loadind user data')
			});


}]);

