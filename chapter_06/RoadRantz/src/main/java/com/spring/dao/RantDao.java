package com.spring.dao;

import java.util.Date;
import java.util.List;

import org.springmodules.cache.annotations.CacheFlush;
import org.springmodules.cache.annotations.Cacheable;

import com.spring.dao.model.Rant;

public interface RantDao {
	@CacheFlush(modelId="rantzCacheModel")
	public void saveRant(Rant rant);
	@Cacheable(modelId="rantzCacheModel")
	public List<Rant> getRantsForDay(Date day);
	@Cacheable(modelId="rantzCacheModel")
	public List<Rant> getAllRants();
}
