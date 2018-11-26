package com.ws.bean;
/**
 *
 */

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
//注册为websocket服务器
@ServerEndpoint("/web")
@Component
public class MyWebSocket {
    //private static Set<Session> sessions;
    private Session session;
    private Integer count;
    private String id;
    private static Map<String ,Object> map = new HashMap<String,Object>();
    @OnOpen
    public void onOpen(Session session){
        System.out.println("建立连接");
        this.session= session;
        System.out.println("参数："+session.getRequestParameterMap());
        this.id = session.getRequestParameterMap().get("user_id").get(0);
        map.put(session.getRequestParameterMap().get("user_id").get(0),this);
        this.count=map.size();
        System.out.println("上线了，当前在线人数："+this.count);
        System.out.println(map);
    }
    @OnMessage
    public void onMessage(Session session,String message) throws IOException {
        System.out.println("接收到浏览器消息："+message);
    }
    @OnError
    public void error(Throwable error){
        System.out.println("链接出错");
    }
    @OnClose
    public void close(){
        System.out.println("连接关闭了");
        map.remove(this.id);
        this.count=map.size();
        System.out.println("下线了，当前人数为："+this.count);
    }

    public static Map<String, Object> getMap() {
        return map;
    }

    public static void setMap(Map<String, Object> map) {
        MyWebSocket.map = map;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
