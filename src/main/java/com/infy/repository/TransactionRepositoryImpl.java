package com.infy.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.infy.entity.Transaction;
import com.infy.model.TransactionDTO;

@Repository("transactionRepository")
public class TransactionRepositoryImpl implements TransactionRepository {
	private EntityManagerFactory entityManagerFactory;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionDTO> viewTransactionDetails(Long accountNumber) {
		List<TransactionDTO> resultTransaction = new ArrayList<TransactionDTO>();
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("select t from Transaction t where t.accountNumber=:accountNumber");
		query.setParameter("accountNumber", accountNumber);
		List<Transaction> allTransaction = query.getResultList();
		entityManager.getTransaction().commit();
		for (Transaction transaction : allTransaction) {
			resultTransaction.add(Transaction.prepareTransactionEntity(transaction));
		}
		return resultTransaction;
	}

}
