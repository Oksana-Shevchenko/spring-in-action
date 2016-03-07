package com.spring.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dao.model.Spitter;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml"})
public class JpaSpitterDaoTest {
	@Autowired
	ISpitterDAO spitterDao;

	public void setSpitterDao(ISpitterDAO spitterDao) {
        this.spitterDao = spitterDao;
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
        Assert.assertNotNull(spitterDao.getSpitterById(3));
    }
}
