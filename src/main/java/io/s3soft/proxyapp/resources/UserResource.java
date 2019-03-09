package io.s3soft.proxyapp.resources;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.s3soft.proxyapp.error.ApiError;
import io.s3soft.proxyapp.error.ApiValidationError;
import io.s3soft.proxyapp.model.User;
import io.s3soft.proxyapp.model.UserDto;
import io.s3soft.proxyapp.service.IUserService;

/**
 * @author shaiksha
 *
 */
@RestController
@RequestMapping("/api/users")
public class UserResource {
	
	@Autowired
	private IUserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity<?> registerUser(@RequestBody UserDto userDto){

		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-type", "application/json");
		HttpEntity<UserDto> request=new HttpEntity<>(userDto,headers);
		ResponseEntity<Optional> res=restTemplate.exchange("https://s3food-users.herokuapp.com/api/users",HttpMethod.POST,request,Optional.class);
		Optional optional=res.getBody();
		if(res.getStatusCodeValue()==201) {
			String message=(String)optional.get();
			return new ResponseEntity<Optional<String>>(Optional.of("A conformation link has been sent to "+userDto.getEmail()+". It is valid for just 10 minutes"),HttpStatus.CREATED);
		  }else if (res.getStatusCodeValue()==200){
			LinkedHashMap<String,String> map=new LinkedHashMap<String,String>();

			ObjectMapper m=new ObjectMapper();
			ApiError m1 =m.convertValue(optional.get(), ApiError.class);

			List<ApiValidationError> listErr=m1.getErrors();
			for(ApiValidationError er:listErr) {
				map.put(er.getProperty(), er.getMessage());
			}
			return new ResponseEntity<LinkedHashMap<String,String>>(map,HttpStatus.OK);
		}else {
			return  ResponseEntity.ok("No worries!!! It is just a server issue. Try again");
		}
	}
	
	@GetMapping
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
}
