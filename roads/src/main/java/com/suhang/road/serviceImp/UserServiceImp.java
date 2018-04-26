package com.suhang.road.serviceImp;

import com.suhang.road.mapper.UserMapper;
import com.suhang.road.po.User;
import com.suhang.road.po.UserCustom;
import com.suhang.road.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserByNamePassAndBlock(UserCustom userCustom) throws Exception {
        User user = userMapper.findUserByNamePassAndBlock(userCustom);
        return user;
    }

    @Override
    public List<User> findUsersAll() throws Exception {
        return userMapper.findUsersAll();
    }

    @Override
    public void updateNameAndPassByUid(String uid, String loginname, String loginpass) throws Exception {
        Map<String, String>map = new HashMap<String,String>();
        map.put("loginname",loginname);
        map.put("loginpass",loginpass);
        map.put("uid",uid);
        userMapper.updateNameAndPassByUid(map);
    }
}
