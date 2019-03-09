package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import io.s3soft.proxyapp.error.ApiError;
import io.s3soft.proxyapp.model.UserDto;

@RunWith(SpringRunner.class)
public class SpringAngularJsApplicationTests {

	private RestTemplate rt;

	@Before
	public void init() {
		rt=new RestTemplate();
	}

	@Test
	public void contextLoads() {

		UserDto user=new UserDto();
		user.setEmail("shheen.sayyad3@gmail.com");
		user.setFirstName("shaiksha");
		user.setLastName("Sayyad");
		user.setPassword("shaiksha");
		user.setMatchingPassword("shaiksha");
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-type", "application/json");
		HttpEntity<UserDto> request=new HttpEntity<>(user,headers);

		ResponseEntity<ApiError> res=rt.exchange("http://sa-registration-service-SANDBOX.mymicroapps.net/users",HttpMethod.POST,request,ApiError.class);
		System.out.println(res.getStatusCodeValue());
		assertEquals(400, res.getStatusCodeValue());

	}

}
