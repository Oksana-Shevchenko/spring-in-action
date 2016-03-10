package com.spring.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Spitter;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-spitter.xml"})   
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class SpitterServiceImplTest {
	@Autowired
	ISpitterService spitterService;
	
	public void setSpitterService(ISpitterService spitterService) {
        this.spitterService = spitterService;
    }
	
	@Test
    public void testFindSpitterById() throws Exception {
		Spitter spitter = new Spitter();
		spitter.setFullName("aaaAAAaaa");
        spitter.setEmail("a@a.com");
        spitter.setPassword("123456789");
        spitter.setUpdateByEmail(false);
        spitter.setUsername("tempUser");
        spitterService.saveSpitter(spitter);
		Spitter result = spitterService.getSpitter(1);
        Assert.assertNotNull(result);
    }
}
