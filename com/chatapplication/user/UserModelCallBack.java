package com.chatapplication.user;

import com.chatapplication.dto.User;

public interface UserModelCallBack {

    void getAllUserName();

    void getChat(User user, User user1);

    void sendMsg(String msg, User user, User user2);
}
