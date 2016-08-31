package com.studytrails.tutorials.springwebflow;

import java.util.HashMap;
import java.util.Map;

public class LoginService {

    private Map<String, String> loginCredentialsMap = new HashMap<String, String>();

    public String performLogin(LoginCredentials loginCredentials) throws IncorrectLoginCredentialsException {

        if (loginCredentials.getLoginName() == null ||
                loginCredentials.getLoginName().trim().equals("") ||
                loginCredentials.getPassword() == null ||
                loginCredentials.getPassword().trim().equals("")) {
            throw new IncorrectLoginCredentialsException();
        }

        String password = loginCredentialsMap.get(loginCredentials.getLoginName());

        if (password == null || ! password.equals(loginCredentials.getPassword())) {
            throw new IncorrectLoginCredentialsException();
        }

        return "success";
    }

    public void createNewAccount(LoginCredentials loginCredentials)  throws IncorrectLoginCredentialsException{

        if (loginCredentials.getLoginName() == null ||
                loginCredentials.getLoginName().trim().equals("") ||
                loginCredentials.getPassword() == null ||
                loginCredentials.getPassword().trim().equals("")) {
            throw new IncorrectLoginCredentialsException();
        }

        loginCredentialsMap.put(loginCredentials.getLoginName(), loginCredentials.getPassword());

    }
}
