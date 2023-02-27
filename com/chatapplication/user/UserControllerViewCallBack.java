package com.chatapplication.user;

import com.chatapplication.dto.Message;
import com.chatapplication.dto.User;

import java.util.List;

public interface UserControllerViewCallBack {
    void getAllUserName();

    void searchUserByName(List<User> userList);

    void getChat(User user, User user1);

    void startChat(List<Message> outgoing, List<Message> incoming);

    void sendMsg(String msg, User user, User user2);

    void sendMsgSuccessfully(User user, User user2);

    void sendMsgFailed(String somethingWentWrong);
}
