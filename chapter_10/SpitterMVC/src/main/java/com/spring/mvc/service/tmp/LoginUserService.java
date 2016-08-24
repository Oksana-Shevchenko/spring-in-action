package com.spring.mvc.service.tmp;

import com.spring.mvc.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.spring.mvc.entity.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service(value = "loginUserService")
public class LoginUserService implements UserDetailsService {

    @Autowired
    @Qualifier("userDao")
    private IUserDao userDao;

    @Override
    public UserDetailsImpl loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDao.getUserByUsername(login);
        return convertUser(user);
    }

    private UserDetailsImpl convertUser(User user) {
        UserDetailsImpl userDetails = new UserDetailsImpl();
        userDetails.setPassword(user.getPassword());
        userDetails.setUsername(user.getUsername());
        userDetails.setEmail(user.getEmail());
        userDetails.setId(user.getId());
        userDetails.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(user.getRole().name())));
        return userDetails;
    }
}
