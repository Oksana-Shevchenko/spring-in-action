package com.spring.mvc.service;

import java.util.List;

import com.spring.mvc.entity.User;
import com.spring.mvc.entity.Message;

public interface IUserService {

    User get(Long id);

    List<Message> getRecentMessages(int count);

    User getUser(String username);

    List<Message> getMessagesForUser(String username);

    void createUser(User user);
}
