package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account", schema="bank")
public class Account {
	@Id
	@Column(name="account_id")
	private String num;
    private double balance;

	@Override
	public String toString() {
		return "Account [num=" + num + ", balance=" + balance + "]";
	}

	

	public String getNum() {
		return num;
	}



	public void setNum(String num) {
		this.num = num;
	}



	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account(String num, double balance) {
		super();
		this.num = num;
		this.balance = balance;
		
	}
	
	public Account() {}
	
	
}
