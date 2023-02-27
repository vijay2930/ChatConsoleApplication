package com.chatapplication.login;

import com.chatapplication.dto.User;

interface LoginControllerViewCallBack {

    void checkLoginCredential(String email, String password);

    void addNewUser(User user);

    void exit();
}
