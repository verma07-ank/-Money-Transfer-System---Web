package com.example.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction" ,schema="bank")
public class Txn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transaction_id;
	private double amount;
	@Column(name="time_stamp")
	private Date date;
	@Column(name="transaction_type")
	private TxnType type;
	@Column(name="account_id")
	private String account;
	
	@Override
	public String toString() {
		return "Txn [transaction_id=" + transaction_id + ", amount=" + amount + ", date=" + date+ ", type="
				+ type + ", account=" + account + "]";
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public TxnType getType() {
		return type;
	}

	public void setType(TxnType type) {
		this.type = type;
	}

	public Txn(String account, double amount, Date date, TxnType type) {
		super();
		this.account = account;
		this.amount = amount;
		this.date = date;
		this.type = type;
	}

	

	

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		
			this.date = date;
		}

		
		
		public Txn() {}

		public void settime_stamp(Timestamp timestamp) {
			// TODO Auto-generated method stub
			
		}

	}