package com.chatapplication.login;

import com.chatapplication.dto.User;

interface LoginViewCallBack {
    void loginSuccessful(User user);

    void loginFailed(String msg);

    void signupFailed(String msg);

    void signupSuccessful(User user);
}
