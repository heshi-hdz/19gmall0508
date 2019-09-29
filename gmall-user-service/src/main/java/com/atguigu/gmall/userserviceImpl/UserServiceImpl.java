package com.atguigu.gmall.userserviceImpl;


import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.entity.UmsMemberReceiveAddress;
import com.atguigu.gmall.mapper.UmsMemberReceiveAddressMapper;
import com.atguigu.gmall.mapper.UserMapperDao;
import com.atguigu.gmall.entity.UmsMember;
import org.springframework.beans.factory.annotation.Autowired;
import com.atguigu.gmall.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapperDao userMapperDao;

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

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

    @Override
    public UmsMember login(UmsMember umsMember) {

//        UmsMember umsMember1 = new UmsMember();
//        umsMember1.setUsername(umsMember.getUsername());
//        umsMember1.setPassword(umsMember.getPassword());
//        UmsMember umsMember2 = (UmsMember)this.umsMemberMapper.selectOne(umsMember1);
//        return umsMember2;
        UmsMember umsMember1 = new UmsMember();
        umsMember1.setUsername(umsMember.getUsername());
        umsMember1.setPassword(umsMember.getPassword());
        UmsMember umsMember2 = userMapperDao.selectOne(umsMember1);
        return umsMember2;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);

        return umsMemberReceiveAddresses;
    }

    @Override
    public UmsMemberReceiveAddress getReceiveAddressById(String addressId) {
        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setId(addressId);
        UmsMemberReceiveAddress umsMemberReceiveAddress1 = umsMemberReceiveAddressMapper.selectOne(umsMemberReceiveAddress);
        return umsMemberReceiveAddress1;
    }

}
