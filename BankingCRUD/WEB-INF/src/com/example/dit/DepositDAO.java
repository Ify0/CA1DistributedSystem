package com.example.dit;

import java.util.ArrayList; 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.dit.model.Deposit;

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
			
			public List<Deposit> getAllDeposits() {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				List<Deposit> Deposits = new ArrayList<Deposit>();
				Deposits = em.createQuery("from Deposit").getResultList();
				em.getTransaction().commit();
				em.close();
				return Deposits;
			}

			
			public Deposit getDepositbyId(String  depositId) {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				Deposit d = em.createQuery("SELECT d FROM Deposit d WHERE d.depositId = :depositId", Deposit.class)
						.setParameter("depositId", depositId)
						.getSingleResult();
						em.getTransaction().commit();
						em.close();
						return d;
			}
			
}
