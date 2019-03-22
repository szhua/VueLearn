package com.iview.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author szhua
 * @Description:demo==
 * @Date 2019/3/22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String id ;
    String username ;
    String password ;

    String token ;

}
