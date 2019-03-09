
angular.module("user").controller("UserCtrl", ['$scope', '$window','UserService' ,function($scope, $window,UserService) {	


/*	UserService.verify().then(function(sucResponse){
		$window.location.href="#/home";
	});*/
	$scope.showMessage=false;
	$scope.username="";
	$scope.password="";
	$scope.flag=true;
	$scope.credentials={};
	$scope.login=function(){
		$scope.credentials.username=$scope.username;
		$scope.credentials.password=$scope.password;
		$scope.flag=false;
		UserService.login($scope.credentials).then(function(resource){
			$window.location.href = '#/home';
			$scope.flag=true;
			$scope.showMessage=false;

		},
		function(error){
			if(error.status===401||error.status===403)
			{
				$window.location.href = '#/user-login';
				$scope.message="Hmm! you are not a valid user";
				$scope.flag=true;
				$scope.showMessage=true;
			}
		}
		);
	};


	self.load=function(){
		$http.get('/greetings').then(function(resource){
			self.greeting=resource.data;	
			self.flag=false;
		})	;	 
	};



}]);