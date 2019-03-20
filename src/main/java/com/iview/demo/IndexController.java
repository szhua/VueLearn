package com.iview.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author szhua
 * @Description:ivew_demo==
 * @Date 2019/2/23
 **/
@Controller
public class IndexController {


    //基础属性
    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }

    //购物车实战
    @RequestMapping(value = "cart")
    public String cart(){

        return "cart";
    }

    //model
    @RequestMapping(value = "vModel")
    public String vModel(){
        return "v_model_practice";
    }


    //组件
    @RequestMapping(value = "component")
    public String component(){
        return "v_component";
    }


    @RequestMapping(value = "componenetMessage")
    public String componentMessage(){
        return "component_message";
    }

    @RequestMapping(value = "componenetMessage2")
    public String componentMessage1(){
        return "component_message2";
    }


    @RequestMapping(value = "slot")
    public String slot(){
        return "slot";
    }


    @RequestMapping(value = "upper_component")
    public String upper_component(){
        return  "upper_component";
    }

    @RequestMapping(value = "numberinput")
    public String numberInput(){
        return  "numberinput";
    }


    @RequestMapping(value ="tabs")
    public String  tabs(){
        return  "tabs" ;
    }





}
