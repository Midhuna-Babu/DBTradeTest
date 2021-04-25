package com.db.trade.tradingApp.jpa;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.db.trade.tradingApp.model.Trade;

public interface TradeRepository extends JpaRepository<Trade, Long>{
	
	public Trade findByTradeDetailsTradeIdAndExpiredAndMaturityDate(String tradeId, String expired, Date maturityDate);
	
	@Transactional
	@Modifying
	@Query("UPDATE Trade t SET t.expired = 'Y' WHERE t.maturityDate < :date")
	public void updateTradeAsExpired(@Param("date") Date date);

	
	
}
