package io.s3soft.proxyapp.locator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.s3soft.proxyapp.model.Product;
import io.s3soft.proxyapp.wrapper.ProductWrapper;

@Component
public class ProductRuleUtil {

	@Autowired
	private RestTemplate restTemplate;

	public List<Product> findAllProducts(){
		ProductWrapper products=restTemplate.getForObject("http://sa-product-microservice-sandbox.mymicroapps.net/api/products", ProductWrapper.class);
		List<Product> listProduct=products.getProducts();
		System.out.println(listProduct)	;
		/*listProduct.forEach((product)->{
			product.setImageName("http://sa-product-ser-SANDBOX.mymicroapps.net/images/"+product.getImageName());
		});*/
		return listProduct;	
	}
}
