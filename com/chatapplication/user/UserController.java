package com.chatapplication.user;

import com.chatapplication.dto.Message;
import com.chatapplication.dto.User;

import java.util.List;

public class UserController implements UserControllerViewCallBack,UserControllerModelCallBack{
    private  UserViewCallBack userView;
    private  UserModelCallBack userModel;
    public UserController(UserViewCallBack userView) {
    this.userView=userView;
    this.userModel=new UserModel(this);
    }

    @Override
    public void getAllUserName() {
        this.userModel.getAllUserName();
    }

    @Override
    public void searchUserByName(List<User> userList) {
        this.userView.searchUserByName(userList);
    }

    @Override
    public void getChat(User user, User user1) {
        this.userModel.getChat(user,user1);
    }

    @Override
    public void startChat(List<Message> outgoing, List<Message> incoming) {
        this.userView.startChat(outgoing,incoming);
    }

    @Override
    public void sendMsg(String msg, User user, User user2) {
        this.userModel.sendMsg(msg,user,user2);
    }

    @Override
    public void sendMsgSuccessfully(User user, User user2) {
        userView.sendMsgSuccessfully(user,user2);
    }
    @Override
    public void sendMsgFailed(String msg) {
        userView.sendMsgFailed(msg);
    }
}
