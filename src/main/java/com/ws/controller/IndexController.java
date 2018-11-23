package com.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
