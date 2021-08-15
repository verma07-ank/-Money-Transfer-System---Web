package com.example.service;

import java.util.Date;

import com.example.entity.Txn;
import com.example.entity.TxnType;
import com.example.repository.AccountRepository;
import com.example.repository.AccountRepositoryImpl;
import com.example.repository.TransactionRepository;
import com.example.repository.TransactionRepositoryImpl;

public class TxrServiceImpl implements TxrService {
	public void transfer(String fromAcc, String toAcc, double amount) {

		AccountRepository accountRepository = new AccountRepositoryImpl();
		TransactionRepository transactionRepository = new TransactionRepositoryImpl();
		Txn transaction = null;

		boolean flag;
		int count = 0;
		try {
			flag = accountRepository.check(fromAcc);
			if (!flag) {
				count = 1;
				throw new AccountBalanceException();
			}
			flag = accountRepository.check(toAcc);
			if (!flag) {
				throw new AccountBalanceException();
			}
			if (accountRepository.balance(fromAcc) < amount) {
				throw new AccountNotFound(fromAcc);
			} else {
				accountRepository.update(fromAcc, accountRepository.balance(fromAcc) - amount);
				transaction = new Txn(fromAcc, amount, new Date(), TxnType.DEBIT);
				transactionRepository.save(transaction);
				accountRepository.update(toAcc, accountRepository.balance(toAcc) + amount);
				transaction = new Txn(toAcc, amount, new Date(), TxnType.CREDIT);
				transactionRepository.save(transaction);
			}
		} catch (AccountBalanceException e) {
			if (count == 1) {
				System.out.println(e.getMessage() + fromAcc);
			} else {

				System.out.println(e.getMessage() + toAcc);
			}

		}catch(AccountNotFound e) {
			System.out.println("AccountNotFound");
		}
	}
}
