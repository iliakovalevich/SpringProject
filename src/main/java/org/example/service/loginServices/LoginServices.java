package org.example.service.loginServices;

public interface LoginServices {
    String login(String username, String password);
    boolean registration(String username,String password,String address);
}
