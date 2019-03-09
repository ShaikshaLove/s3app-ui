package io.s3soft.proxyapp.test;

import org.springframework.util.LinkedMultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.s3soft.proxyapp.model.Product;

public class Test {
public static void main(String[] args) {
	ObjectMapper mapper=new ObjectMapper();
    Product p=new Product();
    p.setProductName("apple");
    p.setDescription("My apple");
    p.setMrp(1.0);
   // p.setCurrentCost(1.0);
   System.out.println(	mapper.convertValue(p, LinkedMultiValueMap.class));
 }
}
