package com.ws.bean;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
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
    private static CopyOnWriteArraySet<MyWebSocket> copyOnWriteArraySet = new CopyOnWriteArraySet<MyWebSocket>();
    @OnOpen
    public void onOpen(Session session){
        System.out.println("建立连接");
        this.session= session;
        copyOnWriteArraySet.add(this);
        this.count=copyOnWriteArraySet.size();
        System.out.println("上线了，当前在线人数："+this.count);
        System.out.println("参数："+session.getRequestParameterMap());
    }
    @OnMessage
    public void onMessage(Session session,String message) throws IOException {
        System.out.println("接收到浏览器消息："+message);
        for(MyWebSocket myWebSocket : copyOnWriteArraySet){
           myWebSocket.session.getBasicRemote().sendText(message);
            System.out.println("发送消息了");
        }
    }
    @OnError
    public void error(Throwable error){
        System.out.println("链接出错");
    }
    @OnClose
    public void close(){
        System.out.println("连接关闭了");
        copyOnWriteArraySet.remove(this);
        this.count = copyOnWriteArraySet.size();
        System.out.println("下线了，当前人数为："+this.count);
    }
}
