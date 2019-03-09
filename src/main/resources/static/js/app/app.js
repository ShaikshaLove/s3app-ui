angular.module("myapp",["ProductApp","user","NavBar","ngRoute"]);


angular.module("myapp").config(function($httpProvider,$routeProvider){
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

	$routeProvider.when("/productRegister",{

		templateUrl:"js/app/product/html/ProductRegister.html",
		controller:"ProductRegisterCtrl"

	}
	);

	$routeProvider.when("/products",
			{
		templateUrl:"js/app/product/html/products.html",
		controller:"ProductListCtrl"
			});
	
	$routeProvider.when("/MyCart",
			{
		templateUrl:"js/app/product/html/MyCart.html",
		//controller:"ProductListCtrl"
			});

	$routeProvider.when("/user-login",
			{
		templateUrl:"js/app/user/html/user-login.html",
		controller:"UserCtrl"
			});

	$routeProvider.when("/user-registration",
			{
		templateUrl:"js/app/user/html/user-registration.html",
		controller:"UserRegisterCtrl"
			});
	
	$routeProvider.when("/user-data",
			{
		templateUrl:"js/app/user/html/user-data.html",
		controller:"UserDataCtrl"
			});

	$routeProvider.when("/home",
			{
		templateUrl:"home.html",
		controller:"HomeCtrl"
			});
	$routeProvider.otherwise(
			{
				templateUrl:"home.html",
				controller:"HomeCtrl"
			});
});

