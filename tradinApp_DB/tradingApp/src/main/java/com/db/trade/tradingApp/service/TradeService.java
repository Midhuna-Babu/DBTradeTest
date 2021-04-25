package com.db.trade.tradingApp.service;

import java.sql.Date;
import java.util.List;

import com.db.trade.tradingApp.model.Trade;

public interface TradeService {
	
	public void addTrade(Trade trade) throws Exception;
	
	public void addTrades(List<Trade> trades);
	
	public Trade getTrade(String tradeId, String expired, Date maturityDate);
}
