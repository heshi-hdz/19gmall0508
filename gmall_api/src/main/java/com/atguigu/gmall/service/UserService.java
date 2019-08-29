package com.atguigu.gmall.service;



import com.atguigu.gmall.entity.UmsMember;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllusers();
    UmsMember getUserById(String userId);
}
