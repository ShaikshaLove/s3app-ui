angular.module("ProductApp").service("ProductService",['$http',function($http){
              
	    this.products=function (){
                    return $http.get("/api/products");
               };
               
               this.saveProduct=function(product,file){
            	   var fd=new FormData();
            	   fd.append("image",file);
            	   for(key in product){
            		   fd.append(key,product[key]);
            	   }
            	  return $http.post("http://sa-product-ser-sandbox.mymicroapps.net/api/products",fd,{
                       transformRequest: angular.identity,
                       headers: {'Content-Type': undefined}
                   });
               };
               
            
}]);