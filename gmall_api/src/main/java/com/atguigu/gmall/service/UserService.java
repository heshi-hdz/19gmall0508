package com.atguigu.gmall.service;



import com.atguigu.gmall.entity.UmsMember;
import com.atguigu.gmall.entity.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllusers();
    UmsMember getUserById(String userId);

    UmsMember login(UmsMember umsMember);

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);

    UmsMemberReceiveAddress getReceiveAddressById(String addressId);
}
