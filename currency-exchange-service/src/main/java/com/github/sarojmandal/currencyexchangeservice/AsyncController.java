package com.github.sarojmandal.currencyexchangeservice;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.github.sarojmandal.currencyexchangeservice.bean.Configuration;

@RestController
@EnableEurekaClient
public class AsyncController {
	@Autowired
	AsyncService asyncService;

	@GetMapping("/async/limits")
	public Configuration getLimits() throws InterruptedException, ExecutionException {
		System.out.println("/async/limits Start");
		CompletableFuture<Configuration> configuration = asyncService.getLimit();
		System.out.println("/async/limits Ends " + configuration);
		return configuration.join();
	}

	@GetMapping("/get-instance/{appName}")
	public String getInstance(@PathVariable String appName) {
		return asyncService.getInstance(appName);
	}
}
