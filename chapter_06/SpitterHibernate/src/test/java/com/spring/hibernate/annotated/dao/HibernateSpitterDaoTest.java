package com.spring.hibernate.annotated.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.annotated.model.Spitter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml"})   
@TransactionConfiguration(transactionManager="txMgr", defaultRollback=true)
@Transactional
public class HibernateSpitterDaoTest {
	 @Autowired
	 private SessionFactory sessionFactory;
	 private Session currentSession;
	 

	 @Before
	 public void openSession() {
		 currentSession = sessionFactory.getCurrentSession();
	 }
	 
	 @Test
	 public void shouldHaveNoObjectsAtStart() {
		 List<?> results = currentSession.createQuery("from Spitter").list();
		 assertTrue(results.isEmpty());
	 }
	 
	 @Test
	 public void shouldBeAbleToPersistAnObject() {
	        assertEquals(0, currentSession.createQuery("from Spitter").list().size());
	        Spitter spitter = new Spitter();
	        spitter.setFullName("aaaAAAaaa");
	        spitter.setEmail("a@a.com");
	        spitter.setPassword("123456789");
	        spitter.setUpdateByEmail(false);
	        spitter.setUsername("tempUser");
	        currentSession.persist(spitter);
	        currentSession.flush();
	        assertEquals(1, currentSession.createQuery("from Spitter").list().size());
	}
	 
	@Test
	public void shouldBeABleToQueryForObjects() {
		shouldBeAbleToPersistAnObject();
		assertEquals(1, currentSession.createQuery("from Spitter where username = 'tempUser'").list().size());
	    assertEquals(0, currentSession.createQuery("from Spitter where username = 'Baz'").list().size());
	}
}
