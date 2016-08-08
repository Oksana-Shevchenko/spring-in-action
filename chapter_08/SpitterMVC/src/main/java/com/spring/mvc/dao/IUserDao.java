package com.spring.mvc.dao;

import java.util.List;

import com.spring.mvc.entity.User;
import com.spring.mvc.entity.Message;

public interface IUserDao {
    List<Message> getRecentMessages();

    User getUserByUsername(String username);

    List<Message> getMessagesForUser(User user);

    void createOrUpdateUser(User user);

    User getUser(Long id);

}
