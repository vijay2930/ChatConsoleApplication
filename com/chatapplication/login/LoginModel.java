package com.chatapplication.login;

import com.chatapplication.dto.User;
import com.chatapplication.repository.Repository;

public class LoginModel implements LoginModelCallBack{
    private LoginControllerModelCallBack loginController;
    private Repository repository;
    public LoginModel(LoginControllerModelCallBack loginController) {
        this.loginController = loginController;repository=Repository.getInstance();
    }

    @Override
    public void checkLoginCredential(String email, String password) {
        User user=repository.getUser(email,password);
        if(user==null){
            loginController.loginFailed("Invalid Credentials.");
        }else {
            loginController.loginSuccessful(user);
        }
    }

    @Override
    public void addNewUser(User user) {
        User newUser=repository.addNewUser(user);
        if(newUser==null){
            loginController.signupFailed("Email you provided was Already exits.Try Again With Another Email...");
        }else {
            loginController.signupSuccessful(user);
        }
    }
    @Override
    public void exit() {
        repository.save();
    }

}
