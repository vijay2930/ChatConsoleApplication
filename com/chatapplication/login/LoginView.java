package com.chatapplication.login;

import com.chatapplication.dto.User;
import com.chatapplication.user.UserView;
import com.chatapplication.util.Read;

public class LoginView implements LoginViewCallBack{
    private LoginControllerViewCallBack loginController;
    public LoginView() {
        loginController=new LoginController(this);
    }
    public void init(){this.start();}
    private void start() {
        System.out.println("-----------------");
        System.out.println("chat Application");
        System.out.println("-----------------");
        System.out.println("Main Page");
        System.out.println("---------");
        System.out.println("1. Login");
        System.out.println("2. SignUp");
        System.out.println("3. Exit");
        int choice=0;
        try {
            choice= Read.changeToInt(Read.input("Enter your choice: "));
        }catch (NumberFormatException e){}
        this.checkValidChoice(choice);
    }

    private void checkValidChoice(int choice) {
        switch (choice){
        case 1:
//            code here
            this.getLoginInfo();
            break;
        case 2:
            this.getSignUpInfo();
//            code here
            break;
        case 3:
            loginController.exit();
            System.exit(0);
//            code here
            break;
        default:
            System.out.println("Please enter only the Valid Choice....\n");
            this.init();
        }
    }

    private void getSignUpInfo() {
        System.out.println("SignUp Page");
        System.out.println("-----------");
        String userName=Read.input("Enter UserName: ");
        String email=Read.getEmail("Enter Email: ");
        String password=Read.getPassword("Enter password: ");
        loginController.addNewUser(new User(userName,email,password));
    }
    private void getLoginInfo() {
        System.out.println("Login Page");
        System.out.println("----------");
        String email=Read.getEmail("Enter Email: ");
        String password=Read.input("Enter Password: ");
        loginController.checkLoginCredential(email,password);
    }
    @Override
    public void loginSuccessful(User user) {
        System.out.println("\nLogin Successful.");
        System.out.println("Welcome "+user.getUserName());
        new UserView(user).init();
    }
    @Override
    public void loginFailed(String msg) {
        System.out.println("\nLogin Failed");
        System.out.println(msg);
        this.init();
    }

    @Override
    public void signupFailed(String msg) {
        System.out.println("\nSignUp Failed");
        System.out.println(msg);
        this.init();
    }

    @Override
    public void signupSuccessful(User user) {
        System.out.println("\nSignup Successful.");
        System.out.println("Welcome "+user.getUserName());
        new UserView(user).init();
    }
}
