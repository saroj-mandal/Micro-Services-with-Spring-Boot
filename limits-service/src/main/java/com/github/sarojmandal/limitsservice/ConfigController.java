package com.github.sarojmandal.limitsservice;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sarojmandal.limitsservice.bean.Configuration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConfigController {

	@Autowired
	Configuration configuraion;

	@GetMapping("limit-service")
	public Configuration retrieveConfiguration() {
		try {
			TimeUnit.MILLISECONDS.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new Configuration(configuraion.getMinimum(), configuraion.getMaximum());
	}

	@GetMapping("fault-tolerance")
	@HystrixCommand(fallbackMethod = "fallbackRetrieveDefaultConfiguration")
	public Configuration retrieveDefaultConfiguration() {
		throw new RuntimeException("Not available");
	}

	public Configuration fallbackRetrieveDefaultConfiguration() {
		return new Configuration(48, 380);
	}

}
