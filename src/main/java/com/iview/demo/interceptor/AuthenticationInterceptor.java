package com.iview.demo.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.iview.demo.anotation.PassToken;
import com.iview.demo.anotation.UserLoginToken;
import com.iview.demo.entity.User;
import com.iview.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author szhua
 * @Description:demo==
 * @Date 2019/3/22
 **/
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService ;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String token = request.getHeader("token") ;
        if (!(handler instanceof HandlerMethod)){
            System.err.println("11111");
            return  true ;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method =handlerMethod.getMethod() ;

        if (method.isAnnotationPresent(PassToken.class)){
            PassToken passToken =method.getAnnotation(PassToken.class);
            if (passToken.required()){
                return  false ;
            }
        }
        if (method.isAnnotationPresent(UserLoginToken.class)){
            UserLoginToken userLoginToken =method.getAnnotation(UserLoginToken.class) ;
            if (userLoginToken.required()){
                if (token == null){
                    throw  new RuntimeException("无token,请重新登录");
                }
                String userId;
                try {
                    userId =JWT.decode(token).getAudience().get(0);
                }catch (JWTDecodeException e){
                    throw new RuntimeException("401");
                }
                User user =userService.findUserById(userId) ;
                if (user == null){
                    throw  new RuntimeException("用户不存在，请重新登录");
                }
                JWTVerifier jwtVerifier =JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    jwtVerifier.verify(token);
                }catch (JWTVerificationException e){
                    throw  new RuntimeException("401");
                }
                return  true ;
            }
        }
        return true;
    }
}
