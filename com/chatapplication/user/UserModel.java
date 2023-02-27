package com.chatapplication.user;

import com.chatapplication.dto.Message;
import com.chatapplication.dto.User;
import com.chatapplication.repository.Repository;

import java.util.List;

public class UserModel implements UserModelCallBack{
    private UserControllerViewCallBack userController;
    private Repository repository;
    public UserModel(UserControllerViewCallBack userController) {
        this.userController=userController;
        repository=Repository.getInstance();
    }

    @Override
    public void getAllUserName() {
        List<User> userList=repository.getAllUsername();
        this.userController.searchUserByName(userList);
    }

    @Override
    public void getChat(User user, User user1) {
        List<Message> outgoing=repository.getMessages(user,user1);
        List<Message> incoming=repository.getMessages(user1,user);
        this.userController.startChat(outgoing,incoming);

    }

    @Override
    public void sendMsg(String msg, User user, User user2) {
        Message message=repository.addNewMessage(new Message(user.getId(),user2.getId(),msg));
        if(message==null){
            userController.sendMsgFailed("Something went wrong");
        }else {
            userController.sendMsgSuccessfully(user,user2);
        }
    }
}
