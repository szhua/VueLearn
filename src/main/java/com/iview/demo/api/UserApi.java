package com.iview.demo.api;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.iview.demo.anotation.UserLoginToken;
import com.iview.demo.entity.User;
import com.iview.demo.service.TokenService;
import com.iview.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author szhua
 * @Description:demo==
 * @Date 2019/3/22
 **/
@RestController
@RequestMapping(value = "api")
public class UserApi {
    @Autowired
    UserService userService ;
    @Autowired
    TokenService tokenService ;

    @PostMapping("/login")
    public Object login(@RequestBody User user){
        JSONObject jsonObject =new JSONObject() ;
        User userforBase =userService.findUserByUserName(user) ;
        if (userforBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return  jsonObject ;
        }else {
            if (!userforBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败。密码错误");
            }else{
                String token =tokenService.getToken(userforBase);
                jsonObject.put("token",token);
                jsonObject.put("user",userforBase) ;
            }
            return  jsonObject ;
        }
    }


    @Autowired
    HttpServletRequest request ;

    @UserLoginToken
    @GetMapping(value = "/getMessage")
    public User getMessage(){
        String token = request.getHeader("token") ;
        String userId = JWT.decode(token).getAudience().get(0);
        User user =userService.findUserById(userId) ;
        user.setToken(token);
        return  user;
    }


}
