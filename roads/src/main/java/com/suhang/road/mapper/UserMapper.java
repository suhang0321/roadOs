package com.suhang.road.mapper;

import com.suhang.road.po.User;
import com.suhang.road.po.UserCustom;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public UserCustom findUserByUid(String uid)throws Exception;

    public User findUserByNamePassAndBlock(UserCustom UserCustom)throws Exception;

    public List<User> findUsersAll()throws Exception;

    public void updateNameAndPassByUid(Map<String,String> map)throws Exception;
}
