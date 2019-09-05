package com.github.sarojmandal.restfulwebservices.international;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternationalMessageController {

	@Autowired
	MessageSource messageSource;

	@GetMapping("/hello-world-international")
	public String helloWorld() {
		return messageSource.getMessage("good-morning", null, LocaleContextHolder.getLocale());
	}
}
