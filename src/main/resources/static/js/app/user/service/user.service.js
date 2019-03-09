angular.module("user").service("UserService",['$http',function($http){

	this.login=function(credentials){
		console.log(credentials);
		return $http.get('/login', {
			headers : { authorization : "Basic "
				+ btoa(credentials.username
						+ ":" + credentials.password)
			}});

	};

	this.verify=function(){
		return $http.get('/login');
	};

	this.register=function(user){
		return $http.post("/api/users",user);
	}
	
	this.getUsers=function(){
		return $http.get("/api/users");
	}

}]);