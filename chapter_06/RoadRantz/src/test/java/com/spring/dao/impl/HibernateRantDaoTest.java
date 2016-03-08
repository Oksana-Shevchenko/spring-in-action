package com.spring.dao.impl;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dao.RantDao;
import com.spring.dao.model.Rant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml"})
public class HibernateRantDaoTest {
	@Autowired
	RantDao rantDao;
	
	public void setRantDao(RantDao rantDao) {
        this.rantDao = rantDao;
    }
	@Test
    public void testFindSpitterById() throws Exception {
		Rant rt = new Rant();
		rt.setRantText("test");
		rt.setPostedDate(new Date());
		rantDao.saveRant(rt);
		List<Rant> result = rantDao.getAllRants();
        Assert.assertNotNull(result);
    }
}
