package com.spring.hibernate.xml.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.spring.hibernate.xml.dao.ISpitterDao;
import com.spring.hibernate.xml.model.Spitter;

@Component
public class HibernateSpitterDao implements ISpitterDao {
	@Autowired
	private HibernateTemplate template;
	
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public HibernateTemplate getTemplate() {
		return template;
	} 
	
	public void addSpitter(Spitter spitter) {
		template.saveOrUpdate(spitter);
	}
	
	public Spitter getSpitterById(long id) {
		return template.get(Spitter.class, id);
	}
	
	public void saveSpitter(Spitter spitter) {
		template.update(spitter);
	}
}
