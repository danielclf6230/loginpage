/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.User;

/**
 *
 * @author danielchow
 */
public class AccountService {

    public User login(String username, String password) {
        User user = new User(username, password);
        if (username.equals("abe") && password.equals("password") || username.equals("barb") && password.equals("password")) {
            password = null;
        } else {
            user = null;
        }
        return user;
    }
}
