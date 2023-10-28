package com.example.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.app.entity.Deposit;

public class DepositDAO {
	protected static EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("IfeomasPU");
			
			public DepositDAO(){
				
			}
			
			public void persist(Deposit deposit) {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				em.persist(deposit);
				em.getTransaction().commit();
				em.close();
			}

			public void removeDeposit(Deposit deposit) {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				em.remove(em.merge(deposit));
				em.getTransaction().commit();
				em.close();
			}

			public Deposit merge(Deposit deposit) {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				Deposit updatedDeposit = em.merge(deposit);
				em.getTransaction().commit();
				em.close();
				return updatedDeposit;
			}

}
