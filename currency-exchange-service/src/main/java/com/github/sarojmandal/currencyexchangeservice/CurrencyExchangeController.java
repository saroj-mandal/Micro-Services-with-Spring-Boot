package com.github.sarojmandal.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.github.sarojmandal.currencyexchangeservice.bean.ExchangeValue;
import com.github.sarojmandal.currencyexchangeservice.data.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	Environment environment;

	@Autowired
	ExchangeValueRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("Exchange value => {}", exchangeValue);
		return exchangeValue;
	}
}
