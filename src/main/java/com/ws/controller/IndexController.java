package com.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
    @RequestMapping("/websocket")
    public String index(){
        return "websocket";
    }
    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }
    @RequestMapping("/showLogin")
    public String showLogin(){
        return "login";
    }
    @RequestMapping("/login")
    @ResponseBody
    public String login(String username,String password){
        Map<String,Object> map = new HashMap<String,Object>();
        return "success";
    }
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
