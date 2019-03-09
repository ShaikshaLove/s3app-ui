package io.s3soft.proxyapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.s3soft.proxyapp.filters.CorsFilter;

@SpringBootApplication
public class S3foodApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(S3foodApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> freg=new FilterRegistrationBean<CorsFilter>();
		freg.setFilter(new CorsFilter());
		ArrayList<String> al=new ArrayList<>();
		al.add("/*");
		freg.setUrlPatterns(al);
		return freg;
	}
	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(S3foodApplication.class);
	}

	@Bean
	public RestTemplate rt() {
		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		messageConverters.add(converter);  
		restTemplate.setMessageConverters(messageConverters); 
		return restTemplate;
	}
}

