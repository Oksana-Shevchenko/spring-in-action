package com.spring.hibernate.xml.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.hibernate.xml.model.Spitter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context-XML.xml"})
public class HibernateSpitterDaoTest {
	@Autowired
	ISpitterDao spitterDao;
	
	public void setSpitterDao(ISpitterDao spitterDao) {
        this.spitterDao = spitterDao;
    }
	
	@Test
    public void testFindSpitterById() throws Exception {
		Spitter result = spitterDao.getSpitterById(1);
        Assert.assertNotNull(result);
    }
	
	@Test
    public void testAddSpitter() throws Exception {
		Spitter spitter = new Spitter();
		spitter.setFullName("aaaAAAaaa");
        spitter.setEmail("a@a.com");
        spitter.setPassword("123456789");
        spitter.setUpdateByEmail(false);
        spitter.setUsername("tempUser");
		spitterDao.addSpitter(spitter);
		Spitter result = spitterDao.getSpitterById(3);
        Assert.assertNotNull(result);
    }
	
}
