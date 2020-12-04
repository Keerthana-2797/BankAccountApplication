package com.infy.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.infy.entity.Account;
import com.infy.model.AccountDTO;

@Repository("accountRepository")
public class AccountRepositoryImpl implements AccountRepository {
	private EntityManagerFactory entityManagerFactory;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AccountDTO> viewAccountDetails() {
		List<AccountDTO> resultAccount = new ArrayList<>();
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("select a from Account a");
		List<Account> allAccount = query.getResultList();
		entityManager.getTransaction().commit();
		for (Account account : allAccount) {
			resultAccount.add(Account.prepareAccountEntity(account));
		}
		return resultAccount;
	}
}
