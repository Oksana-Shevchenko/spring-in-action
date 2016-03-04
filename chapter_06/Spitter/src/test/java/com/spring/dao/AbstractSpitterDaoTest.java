package com.spring.dao;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import com.spring.dao.impl.SimpleJdbcTemplateSpitterDao;
import com.spring.model.Spitter;
import static org.springframework.test.jdbc.SimpleJdbcTestUtils.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml"})   
@TransactionConfiguration(transactionManager="txMgr", defaultRollback=true)
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
@Transactional
public abstract class AbstractSpitterDaoTest {
	@Autowired
	private SimpleJdbcTemplate jdbcTemplateForTesting;
	  
	@Autowired
	private ISpitterDAO spitterDao;

	private EmbeddedDatabase db;
	  
	@Before
	public void setUp() {
		db = new EmbeddedDatabaseBuilder().setName("spitter")
		    		.setType(EmbeddedDatabaseType.H2)
		    		.addScript("schema.sql")
		    		.addScript("data.sql")
		    		.build();
	}
		 
	@Test
	public void testFindByname() {
		Spitter user = spitterDao.getSpitterByUsername("habuma");
		Assert.assertNotNull(user);
		Assert.assertEquals(1, user.getId().intValue());
		Assert.assertEquals("habuma", user.getUsername());
		Assert.assertEquals("craig@habuma.com", user.getEmail());
	}
	
	@Test
	public void shouldCreateRowsAndSetIds() {
		assertEquals(2, countRowsInTable(jdbcTemplateForTesting, "spitter"));    
	    insertASpitter("username", "password", "fullname", "email", false);
	    insertASpitterWithNamedParameter("username1", "password1", "fullname1", "email1", false);
	    assertEquals(4, countRowsInTable(jdbcTemplateForTesting, "spitter"));
	} 
	
	private Spitter insertASpitter(String username, String password, String fullname, String email, boolean updateByEmail) {
		Spitter spitter = new Spitter();
		spitter.setUsername(username);
		spitter.setPassword(password);
		spitter.setFullName(fullname);
		spitter.setEmail(email);
		spitter.setUpdateByEmail(updateByEmail);
		assertNull(spitter.getId());
		spitterDao.addSpitter(spitter);
		return spitter;
	}
	
	private Spitter insertASpitterWithNamedParameter(String username, String password, String fullname, String email, boolean updateByEmail) {
		Spitter spitter = new Spitter();
		spitter.setUsername(username);
		spitter.setPassword(password);
		spitter.setFullName(fullname);
		spitter.setEmail(email);
		spitter.setUpdateByEmail(updateByEmail);
		assertNull(spitter.getId());
		spitterDao.addSpitterWithNamedParameters(spitter);
		return spitter;
	}	
	
	@After
	public void tearDown() {
		deleteFromTables(jdbcTemplateForTesting, "spitter");
	}
}
