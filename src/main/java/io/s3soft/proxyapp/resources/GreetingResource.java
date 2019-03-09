package io.s3soft.proxyapp.resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.s3soft.proxyapp.model.Greeting;

@RestController
@RequestMapping("/greetings")
public class GreetingResource {
	
	@GetMapping
	public Greeting getMessage() {
		return new Greeting("Hey! Shaiksha");
	}

}
