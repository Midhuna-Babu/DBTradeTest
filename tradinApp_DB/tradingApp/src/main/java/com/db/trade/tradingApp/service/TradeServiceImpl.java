package com.db.trade.tradingApp.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.trade.tradingApp.jpa.TradeRepository;
import com.db.trade.tradingApp.model.Trade;

@Service
public class TradeServiceImpl implements TradeService{

	Logger logger = LoggerFactory.getLogger(TradeServiceImpl.class);
	@Autowired
	TradeRepository tradeRepository;

	@Override
	public void addTrade(Trade trade) throws Exception{
		logger.info("Recieved trade : " + trade.getTradeDetails().getTradeId() + " with version " + trade.getTradeDetails().getVersion());
		if(maturityDateCheck(trade)) {
			if(checkExistingEntryVersion(trade))
				tradeRepository.save(trade);
			else
				logger.info("Trade not created as the version is older than the exosting version for this trade.");
		}
		else {
			logger.info("Trade not created as the maturity date for the new trade is older than the current date.");
		}

	}

	private boolean checkExistingEntryVersion(Trade trade) {
		Trade tradeEntryInDB = getTrade(trade.getTradeDetails().getTradeId(), trade.getExpired(), trade.getMaturityDate());
		if(tradeEntryInDB != null) {
			if(tradeEntryInDB.getTradeDetails().getVersion() <= trade.getTradeDetails().getVersion())
				return true;
			else 
				return false;
		} else
			return true;
	}

	private boolean maturityDateCheck(Trade trade) {
		if(trade.getMaturityDate().toLocalDate().isBefore(LocalDate.from(ZonedDateTime.now()))) {
			System.out.println("Trade Maturity date is less than the current date, hence its an invalid trade. Skipping Registration");
			return false;
		}
		return true;
	}

	@Override
	public void addTrades(List<Trade> trades) {
		for(Trade trade : trades)
			tradeRepository.save(trade);
	}

	@Override
	public Trade getTrade(String tradeId, String expired, Date maturityDate) {
		return tradeRepository.findByTradeDetailsTradeIdAndExpiredAndMaturityDate(tradeId, expired, maturityDate);
	}

}