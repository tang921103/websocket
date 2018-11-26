$(function(){
    var websocket = null;
    if("WebSocket" in window){
        websocket = new WebSocket("ws://localhost:8080/ws/web");
        console.log("创建websocket");
        websocket.onopen=function (ev) {
            console.log("open");
        }
        websocket.onmessage=function (ev) {
            console.log("收到服务器消息："+ev.data);
        }
        websocket.onerror=function (ev) {
            console.log("error");
        }
        websocket.onclose=function (ev) {
            console.log("close");
        }
    }else {
        console.log("浏览器不支持websocket");
    }

})