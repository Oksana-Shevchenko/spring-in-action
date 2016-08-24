package com.spring.mvc.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.OverridesAttribute;

import com.spring.mvc.entity.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.entity.User;
import com.spring.mvc.entity.Message;

@Repository("userDao")
@Transactional(propagation=Propagation.REQUIRED)
public class UserDaoImpl implements IUserDao {

//	@Autowired
//	@Qualifier("passwordEncoder")
//	private PasswordEncoder passwordEncoder;

	private SessionFactory sessionFactory;

	private static final String RECENT_MESSAGES_QUERY = "from Message";
	private static final String GET_USER_BY_USERNAME_QUERY = "from User where username =:username";
	private static final String GET_USER_BY_ID_QUERY = "from User where id =:id";
	private static final String GET_MESSAGES_FOR_USER_QUERY = "from Message where user =:user";


	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Message> getRecentMessages() {
		Query query = getCurrentSession(sessionFactory).createQuery(RECENT_MESSAGES_QUERY);
		return (List<Message>)query.list();
	}

	@Override
	public User getUserByUsername(String username) {
		Query query = getCurrentSession(sessionFactory).createQuery(GET_USER_BY_USERNAME_QUERY);
		query.setParameter("username",username);
		return (User)query.uniqueResult();
	}

	@Override
	public List<Message> getMessagesForUser(User user) {
		Query query = getCurrentSession(sessionFactory).createQuery(GET_MESSAGES_FOR_USER_QUERY);
		query.setParameter("user",user);
		return (List<Message>)query.list();
	}

	@Override
	public void createOrUpdateUser(User user) {
//		user.setPassword(passwordEncoder.encodePassword());


        user.setRole(Role.ROLE_USER);
		getCurrentSession(sessionFactory).persist(user);
		getCurrentSession(sessionFactory).flush();
	}

	@Override
	public User getUser(Long id) {
		Query query = getCurrentSession(sessionFactory).createQuery(GET_USER_BY_ID_QUERY);
		query.setParameter("id", id);
		return (User) query.uniqueResult();
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession(SessionFactory sessionFactory) {
		return sessionFactory.getCurrentSession();
	}
}