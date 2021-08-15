package com.example.repository;

import java.util.*;

import javax.persistence.EntityManager;


import com.example.entity.*;
import com.example.jpa.LocalEntityManageFactory;

public class TransactionRepositoryImpl implements TransactionRepository{
	
	
	public void save(Txn transaction) {
		EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		em.persist(transaction);
		em.getTransaction().commit();
		em.close();
		
	}
@SuppressWarnings("unchecked")
@Override
public List<Txn> getTransactions(){
	
	EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
	em.getTransaction().begin();
	List<Txn> txns=em.createQuery("from transaction").getResultList();
	em.getTransaction().commit();
	em.close();
	return txns;
}

@SuppressWarnings("unchecked")
public List<Txn> getTransactions(int limit){
	EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
	em.getTransaction().begin();
	List<Txn> txns = em.createQuery("from transaction order by transaction_Id desc limit"+limit).getResultList();

	em.getTransaction().commit();
	em.close();
	return txns;
}
@SuppressWarnings("unchecked")
public List<Txn> getTransactions(Date fromdateTime, Date todateTime) {
	EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
	em.getTransaction().begin();
	List<Txn> txns=em.createQuery("from transaction where LocalDateTime between "+fromdateTime+" and "+todateTime).getResultList();

	em.getTransaction().commit();
	em.close();
	return txns;
 }



}
