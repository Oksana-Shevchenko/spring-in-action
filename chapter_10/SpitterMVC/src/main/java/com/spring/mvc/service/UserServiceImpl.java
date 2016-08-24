package com.spring.mvc.service;
import com.spring.mvc.entity.User;
import org.springframework.transaction.annotation.Propagation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.dao.IUserDao;
import com.spring.mvc.entity.Message;

@Service("userService")
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl implements IUserService {
	
	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

	@Override
	public User get(Long id) {
		return userDao.getUser(id);
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Message> getRecentMessages(int count) {
		return userDao.getRecentMessages();
	}

	@Override
	public User getUser(String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	public List<Message> getMessagesForUser(String username){
		User user = getUser(username);
		return userDao.getMessagesForUser(user);
	}
	@Override
	public void createUser(User user){
		userDao.createOrUpdateUser(user);
	}

}
