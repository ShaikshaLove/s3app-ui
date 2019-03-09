package io.s3soft.proxyapp.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.s3soft.proxyapp.error.ApiError;
import io.s3soft.proxyapp.model.UserDto;

public class TestApp {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		//Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		// Note: here we are making this converter to process any kind of response, 
		// not only application/*json, which is the default behaviour
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));         
		messageConverters.add(converter);  
		restTemplate.setMessageConverters(messageConverters);  
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-type", "application/json");
		/*
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-type", "application/json");
     	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));*/
		UserDto user=new UserDto();
		user.setEmail("shaheen.sayyad4@gmail.com");
		user.setFirstName("shaiksha");
		user.setLastName("Sayyad");
		user.setPassword("shaiksha");
		user.setMatchingPassword("shaiksha");
		headers.add("Content-type", "application/json");
		HttpEntity<UserDto> request=new HttpEntity<>(user,headers);
		ResponseEntity<Optional> res=restTemplate.exchange("http://localhost:9080/users",HttpMethod.POST,request,Optional.class);
		Optional optional=res.getBody();
		if(res.getStatusCodeValue()==201) {
			String message=(String)optional.get();
			System.out.println(message);
		}else if(res.getStatusCodeValue()==200) {
			ObjectMapper m=new ObjectMapper();
			ApiError m1 =m.convertValue(optional.get(), ApiError.class);
			System.out.println(m1);
		}

		/*	HttpStatus st=res.getStatusCode();
	    String message=(String)res.getBody();
    	System.out.println(message);
		    if(st.is2xxSuccessful()) {
		    	String message=(String)res.getBody();
		    	System.out.println(message);
		    }else {
		    	ApiValidationError errors=(ApiValidationError)res.getBody();
		    	System.out.print(errors);
		    }*/
		/*	ResponseEntity<Optional> res=restTemplate.exchange("http://localhost:8080/hi/0",HttpMethod.GET,null,Optional.class);
		Optional o=res.getBody();
		System.out.println();
		if(res.getStatusCodeValue()==200) {
			String message=(String)o.get();
			System.out.println(message);
		}else {
			ObjectMapper m=new ObjectMapper();
			Greeting m1 =m.convertValue(o.get(), Greeting.class);
			System.out.println(m1);}*/
	}
}
