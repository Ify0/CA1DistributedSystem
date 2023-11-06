package com.example.dit;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.dit.model.Deposit;
import com.example.dit.model.Loan;

public class LoanDAO {
	protected static EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("IfeomasPU");
			
			public LoanDAO(){
				
			}
			
			public void persist(Loan loan) {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				em.persist(loan);
				em.getTransaction().commit();
				em.close();
			}

			public void removeLoan(Loan loan) {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				em.remove(em.merge(loan));
				em.getTransaction().commit();
				em.close();
			}

			public Loan merge(Loan loan) {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				Loan updatedLoan = em.merge(loan);
				em.getTransaction().commit();
				em.close();
				return updatedLoan;
			}
			
			public List<Loan> getAllLoans(){
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				List<Loan> LoanFromDB = new ArrayList<Loan>();
				LoanFromDB = em.createNamedQuery("from Loan").getResultList();
				em.getTransaction().commit();
				em.close();
				return LoanFromDB;
		}
			public Loan getLoanbyId(String loanId) {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				Loan l = em.createQuery("SELECT l FROM Loan l WHERE l.loanId = :loanId", Loan.class)
						.setParameter("loanId", loanId)
						.getSingleResult();
						em.getTransaction().commit();
						em.close();
						return l;
			}

}
