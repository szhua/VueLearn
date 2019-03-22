package com.iview.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.iview.demo.entity.User;
import org.springframework.stereotype.Service;

/**
 * @Author szhua
 * @Description:demo==
 * @Date 2019/3/22
 **/
@Service
public class TokenService {

  public String getToken(User user){
      String token ="" ;
      token =JWT.create().withAudience(user.getId(), String.valueOf(System.currentTimeMillis()))
              .sign(Algorithm.HMAC256(user.getPassword()));
      return  token ;
  }

}
