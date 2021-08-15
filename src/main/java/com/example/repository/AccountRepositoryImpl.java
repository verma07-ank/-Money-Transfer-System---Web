package com.example.repository;

import javax.persistence.EntityManager;

import com.example.entity.Account;
import com.example.jpa.LocalEntityManageFactory;

public class AccountRepositoryImpl implements AccountRepository {

	
	public boolean check(String account) {

		EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		Account acc = em.find(Account.class, account);
		
		em.getTransaction().commit();
		em.close();
		if(acc==null) {
			return false;
		} else {
			return true;
		}

	}


	
	public double balance(String account) {

		EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();

		Account acc = em.find(Account.class, account);
		double bal = acc.getBalance();
		em.getTransaction().commit();
		em.close();
		return bal;

	}


	
	public void update(String account_id, double balance) {

		EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();

		Account account = em.find(Account.class, account_id);
		account.setBalance(balance);

		em.getTransaction().commit();
		em.close();

	}

}