package io.s3soft.proxyapp.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class UploadController {

	@PostMapping
	public String hey(@RequestParam("file")MultipartFile file) {
		return "Hey!!! "+file.getOriginalFilename();
	}
	
}
