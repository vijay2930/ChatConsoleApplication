package com.chatapplication.user;

import com.chatapplication.dto.Message;
import com.chatapplication.dto.User;
import com.chatapplication.login.LoginView;
import com.chatapplication.util.Check;
import com.chatapplication.util.Read;

import java.util.ArrayList;
import java.util.List;

public class UserView implements UserViewCallBack{
    private User user;
    private User user2;
    private UserControllerViewCallBack userController;
    public UserView(User user) {
        this.user=user;
        userController=new UserController(this);
    }

    public void init() {
        this.start();
    }

    private void start() {
        System.out.println("User Page");
        System.out.println("1. Find User to Chat");
        System.out.println("2. Logout");
        int choice=0;
        try{
            choice= Read.changeToInt(Read.input("Enter your Choice: "));
        }catch (Exception e){}
        this.checkValidChoice(choice);
    }

    private void checkValidChoice(int choice) {
        switch (choice){
            case 1:
                userController.getAllUserName();
            case 2:
                this.logout();
            default:
                System.out.println("Please enter a Valid Choice");
        }
    }

    private void logout() {
        new LoginView().init();
    }

    @Override
    public void searchUserByName(List<User> userList) {
        System.out.println("Find User to Chat");
        System.out.println("-----------------");
        List<String> namelist=new ArrayList<>();
        for (User user1:userList) {
            if(user1.getUserName().equals(this.user.getUserName())){
                continue;
            }
            namelist.add(user1.getUserName());
        }
        System.out.println("Available User List");
        System.out.println(namelist);
        while (true){
            String userName=Read.input("Enter Username:");
            for (User user1: userList) {
                if(user1.getUserName().equals(userName)){
                    this.user2=user1;
                    userController.getChat(this.user,user1);
                }
            }
            System.out.println("No Match Found.Try again");

        }
    }

    @Override
    public void startChat(List<Message> outgoing, List<Message> incoming) {
        if(outgoing.isEmpty() && incoming.isEmpty()){
            System.out.println("No Msg found");
        }
        int i=0;
        int j=0;
        while (i<outgoing.size() && j<incoming.size()){
            if(i<outgoing.size() && outgoing.get(i).getId()<incoming.get(j).getId()){
                System.out.println("*********************************************");
                System.out.printf("%20s\n","you");
                System.out.println("*********************************************");
                    System.out.printf("%-20s\n",outgoing.get(i).getMessage());
                System.out.println("---------------------------------------------");
                i++;
            }
            else if(j<incoming.size() && outgoing.get(i).getId()>incoming.get(j).getId()){
                System.out.println("*********************************************");
                System.out.printf("%20s\n",user2.getUserName());
                System.out.println("*********************************************");
                System.out.printf("%-20s\n",incoming.get(j).getMessage());
                System.out.println("---------------------------------------------");
                j++;
            }
        }
        while (i<outgoing.size()){
            System.out.println("*********************************************");
            System.out.printf("%20s\n","you");
            System.out.println("*********************************************");
                System.out.printf("%-20s\n",outgoing.get(i).getMessage());
            System.out.println("---------------------------------------------");
            i++;
        }

        while(j<incoming.size()) {
            System.out.println("*********************************************");
            System.out.printf("%20s\n",user2.getUserName());
            System.out.println("*********************************************");
                System.out.printf("%-20s\n",incoming.get(j).getMessage());
            System.out.println("\n---------------------------------------------");
            j++;
        }
        String msg=Read.getContent("Enter msg:");
        userController.sendMsg(msg,user,user2);
    }

    @Override
    public void sendMsgFailed(String msg) {
        System.out.println("Failed to send Message.Try again");
        System.out.println(msg);
        System.out.println("Do you want to continue chat");
        System.out.println("1. yes");
        System.out.println("2. No");
        int choice=0;
        while (true) {
            try {
                choice = Read.changeToInt(Read.input("Enter your choice:"));
            } catch (Exception e) {
            }
            if(choice==1){
                this.returnToChat();
            }else if(choice==2){
                System.out.println("Returning to the Home Page");
                user2=null;
                this.init();
            }
        }
    }

    private void returnToChat() {
        userController.getChat(user,user2);
    }


    @Override
    public void sendMsgSuccessfully(User user, User user2) {
        System.out.println("Do you want to Continue Chatting");
        System.out.println("1. yes");
        System.out.println("2. No");
        while (true){
            try{
                int choice=Read.changeToInt(Read.input("Enter your Choice: "));
                if(choice==1){
                    userController.getChat(user,user2);
                }else if(choice==2){
                    System.out.println("Returning to the home Page");
                    this.init();
                }
            }catch (Exception e){}
        }
    }
}
