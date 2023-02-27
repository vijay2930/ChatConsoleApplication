package com.chatapplication.login;

import com.chatapplication.dto.User;

public interface LoginModelCallBack {
    void checkLoginCredential(String email, String password);

    void addNewUser(User user);

    void exit();
}
