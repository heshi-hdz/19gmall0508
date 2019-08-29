package com.atguigu.gmall.mapper;





import com.atguigu.gmall.entity.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapperDao extends Mapper<UmsMember>{
    public List<UmsMember> selectAllUsers();
}
