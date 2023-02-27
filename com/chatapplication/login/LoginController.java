package com.chatapplication.login;

import com.chatapplication.dto.User;

class LoginController implements LoginControllerViewCallBack,LoginControllerModelCallBack{
    private LoginModelCallBack loginModel;
    private LoginViewCallBack loginView;
    public LoginController(LoginViewCallBack loginView) {
        this.loginView = loginView;
        this.loginModel=new LoginModel(this);
    }

    @Override
    public void checkLoginCredential(String email, String password) {
        loginModel.checkLoginCredential(email,password);
    }

    @Override
    public void addNewUser(User user) {
        loginModel.addNewUser(user);
    }

    @Override
    public void exit() {
        loginModel.exit();
    }

    @Override
    public void loginSuccessful(User user) {
        loginView.loginSuccessful(user);
    }

    @Override
    public void loginFailed(String msg) {
        loginView.loginFailed(msg);
    }

    @Override
    public void signupFailed(String msg) {
        loginView.signupFailed(msg);
    }

    @Override
    public void signupSuccessful(User user) {
        loginView.signupSuccessful(user);
    }
}