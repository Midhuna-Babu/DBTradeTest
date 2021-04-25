package com.db.trade.tradingApp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.trade.tradingApp.model.Trade;
import com.db.trade.tradingApp.service.TradeService;

@RestController
public class TradeController {
	Logger logger = LoggerFactory.getLogger(TradeController.class);
	@Autowired
	TradeService tradeService;

	@PostMapping("/trade")
	public void createTrade(@RequestBody Trade trade) {
		try {
			logger.info(" Trade : " + trade.getTradeDetails());
			tradeService.addTrade(trade);
		} catch (Exception e) {
			e.printStackTrace();
			if(trade.getTradeDetails()!=null)
				logger.error("Exception during trade creation for trade "+ trade.getTradeDetails().getTradeId() + e.getMessage());
			else
				logger.error("Exception during trade creation for trade " + e.getMessage());
			
		}
	}

	/*
	 * @PostMapping("/trades") public ResponseEntity<Trade>
	 * createTrades(@RequestBody List<Trade> trades) { try { for(Trade trade :
	 * trades) { Trade trade = tradeRepository .save(new Trade()); } return new
	 * ResponseEntity<>(_tutorial, HttpStatus.CREATED); } catch (Exception e) {
	 * return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */

}
