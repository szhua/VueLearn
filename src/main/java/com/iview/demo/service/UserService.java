package com.iview.demo.service;

import com.iview.demo.entity.User;
import org.springframework.stereotype.Service;

/**
 * @Author szhua
 * @Description:demo==
 * @Date 2019/3/22
 **/
@Service
public class UserService {

    public User findUserByUserName(User user){
        if (!"szhua".equals(user.getUsername())){
            return  null ;
        }
        return  new User("1","szhua","123456","");
    }

    public User findUserById(String userId ){
        if (!"1".equals(userId)){
            return  null ;
        }
        return  new User("1","szhua","123456","");

    }

}
