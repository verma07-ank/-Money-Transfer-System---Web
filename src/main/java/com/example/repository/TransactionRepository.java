package com.example.repository;

import java.util.List;


import java.util.Date;

import com.example.entity.*;

public interface TransactionRepository {

	public List<Txn> getTransactions();

	public List<Txn> getTransactions(int limit);

	public List<Txn> getTransactions(Date fromdateTime, Date todateTime);

	void save(Txn transaction);

}