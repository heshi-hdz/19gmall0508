package com.atguigu.gmall.userserviceImpl;


import com.atguigu.gmall.mapper.UserMapperDao;
import com.atguigu.gmall.entity.UmsMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.gmall.service.UserService;

import java.util.List;

@Service(value = "UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapperDao userMapperDao;

    @Override
    public List<UmsMember> getAllusers() {
        List<UmsMember> umsMembers = userMapperDao.selectAllUsers();
        return umsMembers;
    }

    @Override
    public UmsMember getUserById(String userId) {
        UmsMember user = new UmsMember();
        user.setId(userId);
        UmsMember getUser = userMapperDao.selectOne(user);
        return getUser;
    }

}
