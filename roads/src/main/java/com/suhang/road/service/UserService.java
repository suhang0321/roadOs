package com.suhang.road.service;

import com.suhang.road.po.User;
import com.suhang.road.po.UserCustom;

import java.util.List;

public interface UserService {
    public User findUserByNamePassAndBlock(UserCustom userCustom)throws Exception;

    public List<User> findUsersAll()throws Exception;

    public void updateNameAndPassByUid(String uid,String loginname,String loginpass)throws Exception;
}
