/*angular.module("ProductApp").controller("ProductListCtrl",['$http','$window','ProductService',function($scope,$window,ProductService){
	$scope.flag=true;
	$scope.title="Hey! shaiksha. It is working"
	$scope.listProducts=[];
	ProductService.products().then(function(serverdata){
		console.log("Fetching products...."+serverdata.status);
		$scope.listProducts=serverdata.data;
		console.log(serverdata.data);
		console.log("-----List----Products------");
		console.log($scope.listProducts);
		$scope.flag=false;
	},function(error){
		if (error.status===401) {
			$window.location.href ='#/login';
		}
	});
}]);
 */

angular.module("ProductApp").controller("ProductListCtrl",function($scope,$window,ProductService){
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
	
	$scope.quantity=1;
	$scope.productId=1;
	$scope.cartItem={};
	$scope.myFn=function (item,index){
		if($scope.productId===item.productId){
			$scope.cartItem.quantity=$scope.quantity;
			$scope.cartItem.product=item;
			cartItems.push($scope.cartItem);

		}
	}
	$scope.add=function(){
		//	$scope.cartItem.quntity=$scope.quantity.quantity;

		console.log($scope.productId+" "+$scope.quantity);
		$scope.productList.forEach($scope.myFn);

		console.log(cartItems);
	};

	$scope.shareId=function(id){
		$scope.productId=id;
		console.log(id);
	}

});



/*
var cartItems=[];
$scope.quantity;
$scope.productId;
$scope.cartItem={};
$scope.myFn=function (item,index){
	if($scope.productId===item.productId){
		$scope.cartItem.quantity=$scope.quantity;
		$scope.cartItem.product=item;
		cartItems.push($scope.cartItem);

	}
}
$scope.add=function(){
	//	$scope.cartItem.quntity=$scope.quantity.quantity;

	console.log($scope.productId+" "+$scope.quantity);
	$scope.productList.forEach($scope.myFn);

	console.log(cartItems);
};

$scope.shareId=function(id){
	$scope.productId=id;
	console.log(id);
}

*/