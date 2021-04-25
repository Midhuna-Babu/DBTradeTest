package com.db.trade.tradingApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.sun.istack.NotNull;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Embeddable
public class TradeDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TradeDetails() {
		this.tradeId="";
		this.version=0;
	}

	public TradeDetails(String tradeId, int version) {
		this.tradeId = tradeId;
		this.version = version;
	}
	@NotNull
	@Column(name="TRADE_ID")
	private String tradeId;
	
	@NotNull
	@Column(name="VERSION")
	private Integer version;
	

	/**
	 * @return the tradeID
	 */
	public String getTradeId() {
		return tradeId;
	}

	/**
	 * @param tradeID the tradeID to set
	 */
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}
}
