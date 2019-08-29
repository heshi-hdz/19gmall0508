package com.atguigu.gmall.usecontroller;




import com.atguigu.gmall.entity.UmsMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.atguigu.gmall.service.UserService;

import java.util.List;

@Controller
public class usercontroller {
    @Autowired
    private UserService userService;
    //get a user by id
    @RequestMapping("/get/User/By/{usrId}")
    @ResponseBody
    public UmsMember getUserById(@PathVariable("usrId")String usrId) {
        UmsMember selectuserById = userService.getUserById(usrId);
        return  selectuserById;
    }


    //get all userss
    @RequestMapping("/get/all/users")
    @ResponseBody
    public List<UmsMember> getAllUsers() {
        List<UmsMember> userList = userService.getAllusers();
        return userList;
    }

}
