package io.s3soft.proxyapp.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.s3soft.proxyapp.model.Product;
import io.s3soft.proxyapp.service.IProductService;

@RestController
@RequestMapping("/api/products")
public class ProductResource  {

	@Autowired
	public IProductService productService;



	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getAllProducts(){
			return ResponseEntity.ok(productService.getAllProducts());
	}

/*
	@PostMapping(produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> saveProduct(@ModelAttribute Product product,@RequestParam("image")MultipartFile imageFile) throws IOException {

		LinkedMultiValueMap<String,String> imgHeaders=new LinkedMultiValueMap<String,String>();
		imgHeaders.add("Content-disposition","form-data;name=image;filename="+imageFile.getOriginalFilename());
		imgHeaders.add("Content-type","image/jpg");
        HttpEntity<byte[]> image=new HttpEntity<byte[]>(imageFile.getBytes(),imgHeaders);
    
        LinkedMultiValueMap<String,Object>  requestBody=new LinkedMultiValueMap<String,Object>();
    	requestBody.add("productName", product.getProductName());
    	requestBody.add("manufacturer", product.getManufacturer());
    	requestBody.add("description", product.getDescription());
    	requestBody.add("mrp", product.getMrp());
    	requestBody.add("currentCost", product.getCurrentCost()); 
    	requestBody.add("image",image);
    	HttpHeaders headers=new HttpHeaders();
    	headers.setContentType(MediaType.MULTIPART_FORM_DATA);
    	HttpEntity<LinkedMultiValueMap<String, Object>> requestDocument = new HttpEntity<>(requestBody, headers);
     
    	ResponseEntity<String> resE = restTemplate.exchange("http://localhost:8085/api/products",HttpMethod.POST,requestDocument,String.class);

    	String message=(String)resE.getBody();
		System.out.println(message);
		return new ResponseEntity<String>("Product registration is successful with "+message,HttpStatus.CREATED);
	}*/


	

}
