package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.spring.dao.ISpitterDao;
import com.spring.model.Spitter;

@Transactional(propagation = Propagation.REQUIRED)
public class SpitterServiceImpl implements ISpitterService{
	private TransactionTemplate transactionTemplate;
	private ISpitterDao spitterDao;
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	public void setSpitterDao(ISpitterDao spitterDao) {
		this.spitterDao = spitterDao;
	}
	
	public void saveSpitter(final Spitter spitter) {
		transactionTemplate.execute(new TransactionCallback<Void>() {
			 public Void doInTransaction(TransactionStatus txStatus) {
				 if (spitter.getId() == null) {
					 spitterDao.addSpitter(spitter);
				 } else {
					 spitterDao.saveSpitter(spitter);
				 }
				 return null;
			 }
		 });
	}

	public Spitter getSpitter(long id) {
		return spitterDao.getSpitterById(id);
	}

	public Spitter getSpitter(String username) {
		return spitterDao.getSpitterByUsername(username);
	}

	public List<Spitter> getAllSpitters() {
		 return spitterDao.findAllSpitters();
	}
}
