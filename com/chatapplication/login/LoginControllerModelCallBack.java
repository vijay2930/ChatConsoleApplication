package com.chatapplication.login;

import com.chatapplication.dto.User;

interface LoginControllerModelCallBack {
    void loginSuccessful(User user);
    void loginFailed(String s);
    void signupFailed(String msg);

    void signupSuccessful(User user);
}
