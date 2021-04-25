package com.db.trade.tradingApp.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.annotation.JsonFormat;
@EnableJpaRepositories
@Entity
@Table(name="TRADES")
public class Trade implements Serializable{

	public Trade() {
	}

	public Trade(TradeDetails tradeDetails, String counterPartyId, String bookID, Date maturityDate, Date createdDate) {
		this.tradeDetails = tradeDetails;
		this.counterPartyId = counterPartyId;
		this.bookID = bookID;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
	}
	@Id
	@EmbeddedId
    private TradeDetails tradeDetails;

	@Column(name="COUNTER_PARTY_ID")
	private String counterPartyId;

	@Column(name="BOOK_ID")
	private String bookID;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name="MATURITY_DATE")
	private Date maturityDate;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="EXPIRED")
	private String expired;

	/**
	 * @return the counterPartyId
	 */
	public String getCounterPartyId() {
		return counterPartyId;
	}

	/**
	 * @param counterPartyId the counterPartyId to set
	 */
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

	/**
	 * @return the bookID
	 */
	public String getBookID() {
		return bookID;
	}

	/**
	 * @param bookID the bookID to set
	 */
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	/**
	 * @return the maturityDate
	 */
	public Date getMaturityDate() {
		return maturityDate;
	}

	/**
	 * @param maturityDate the maturityDate to set
	 */
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the expired
	 */
	public String getExpired() {
		return expired;
	}

	/**
	 * @param expired the expired to set
	 */
	public void setExpired(String expired) {
		this.expired = expired;
	}
	/**
	 * @return the tradeDetails
	 */
	public TradeDetails getTradeDetails() {
		return tradeDetails;
	}

	/**
	 * @param tradeDetails the tradeDetails to set
	 */
	public void setTradeDetails(TradeDetails tradeDetails) {
		this.tradeDetails = tradeDetails;
	}

	/*
	 * public boolean isPersistent() { return this.version != null; }
	 */

	@Override
	public String toString() {
		return "Trade [tradeID = " + tradeDetails.getTradeId() + ", version = " + tradeDetails.getVersion() + 
				", Counter Party Id = " + counterPartyId + ", book ID = " + bookID + 
				", Maturity Date = " + maturityDate + ", Created Date = " + createdDate + "]";
	}

}
