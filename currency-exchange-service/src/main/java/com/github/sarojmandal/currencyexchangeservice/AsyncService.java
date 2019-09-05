package com.github.sarojmandal.currencyexchangeservice;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.sarojmandal.currencyexchangeservice.bean.Configuration;

@Service
public class AsyncService {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	DiscoveryClient discoveryClient;

	@Autowired
	LoadBalancerClient loadBalancerClient;

	@Async
	public CompletableFuture<Configuration> getLimit() {
		System.out.println("getLimit Start");
		String host = discoveryClient.getInstances("limits-service").get(0).getHost();
		int port = discoveryClient.getInstances("limits-service").get(0).getPort();
		Configuration configuration = restTemplate.getForObject("http://" + host + ":" + port + "/limit-service",
				Configuration.class);
		System.out.println("getLimit Ends");
		return CompletableFuture.completedFuture(configuration);
	}
	
	public String getInstance(String appName) {
		ServiceInstance instance = loadBalancerClient.choose(appName);
		System.out.println("Host : " + instance.getHost() + ", Port : " + instance.getPort() + ", Instance Id : "
				+ instance.getInstanceId() + ", Service Id : " + instance.getServiceId() + ", Metadata : "
				+ instance.getMetadata() + ", Uri : " + instance.getUri());
		return instance.getUri().toString();
	}
}
