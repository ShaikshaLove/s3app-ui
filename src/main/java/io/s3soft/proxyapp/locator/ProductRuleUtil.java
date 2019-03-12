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
		ProductWrapper products=restTemplate.getForObject("https://s3food-products.herokuapp.com/products",ProductWrapper.class);
		List<Product> listProduct=products.getProducts();
		System.out.println(listProduct)	;
		/*listProduct.forEach((product)->{
			product.setImageName("https://product-service-in.herokuapp.com/images/"+product.getImageName());
		});*/
		return listProduct;	
	}
}
