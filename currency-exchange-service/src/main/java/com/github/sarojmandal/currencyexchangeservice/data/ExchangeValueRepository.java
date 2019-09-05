package com.github.sarojmandal.currencyexchangeservice.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.sarojmandal.currencyexchangeservice.bean.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	ExchangeValue findByFromAndTo(String from, String to);
}
