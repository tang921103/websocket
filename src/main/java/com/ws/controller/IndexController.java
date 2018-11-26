package com.ws.controller;

import com.ws.bean.MyWebSocket;
import com.ws.entities.User;
import com.ws.service.IUserService;
import com.ws.utils.MsgUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Resource
    private IUserService userService;
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
    public Map<String,Object> login(String username,String password){
        Map<String,Object> map = new HashMap<String,Object>();
        List<User> list = userService.getUsers(username);
        if(null!=list && list.size()>0){
            User user = list.get(0);
            if(user.getPassword().equals(password)){
                System.out.println("登陆成功");
                Integer id = user.getId();
                if(MyWebSocket.getMap().containsKey(id.toString())){
                    System.out.println("此账号已经被登陆了");
                    MyWebSocket myWebSocket = (MyWebSocket)MyWebSocket.getMap().get(id.toString());
                    try {
                        myWebSocket.getSession().getBasicRemote().sendText("此账号已经登陆");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                map = MsgUtils.getRight(user);
            }
        }else{
            map = MsgUtils.getError(null);
        }
        return  map;
    }
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
