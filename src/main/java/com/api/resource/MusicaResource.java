package com.api.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping
@Controller
public class MusicaResource {

	@RequestMapping(method = RequestMethod.GET, value = "/ola")
	public ResponseEntity<String> getTest(){
		return ResponseEntity.ok().body("teste");
	}
}
