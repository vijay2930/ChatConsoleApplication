package com.chatapplication.user;

import com.chatapplication.dto.Message;
import com.chatapplication.dto.User;

import java.util.List;

public interface UserViewCallBack {
    void searchUserByName(List<User> userList);

    void startChat(List<Message> outgoing, List<Message> incoming);

    void sendMsgFailed(String msg);

    void sendMsgSuccessfully(User user, User user2);
}
