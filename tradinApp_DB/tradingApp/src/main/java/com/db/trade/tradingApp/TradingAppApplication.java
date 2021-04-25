package com.db.trade.tradingApp;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.db.trade.tradingApp.jpa.TradeRepository;
import com.db.trade.tradingApp.service.TradeServiceImpl;

@EnableScheduling
@ComponentScan("com.db.trade.tradingApp")
@SpringBootApplication
public class TradingAppApplication {
	
	Logger logger = LoggerFactory.getLogger(TradingAppApplication.class);
	
	@Autowired
	TradeRepository tradeRepository;

	public static void main(String[] args) {
		SpringApplication.run(TradingAppApplication.class, args);
	}

	// Automatically update expire flag if the trade crosses maturity date
	// The duration should be set to run for a day, setting it to 100000 for demonstration purpose
	@Scheduled(fixedDelay = 100000) public void updateExpiryTrade() {
		Date start = new Date(System.currentTimeMillis());
		tradeRepository.updateTradeAsExpired(start); 
		logger.info("Updated status of trades to expired where maturity date is before current date.");
	}


}
