package com.spring.springwebsocket2;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {
	
	// http 프로토콜 request, session으로 데이터를 받아왔다. 
/*
	클라이언트와 서버간에 통신 채널을 설정하려면 클라이언트가 서버로 HTTP 업그레이드 요청을 보내야합니다. 
	이를 WebSocket 프로토콜 핸드 셰이크라고합니다.
	
	서버가 연결을 업그레이드 할 수 있는 경우,  HTTP 101 응답을 요청한 클라이언트에 보냅니다. 
	이 시점에서 핸드 셰이크가 성공한 것으로 간주되고 서버와 클라이언트 간의 연결이 WebSocket 프로토콜로 업그레이드됩니다.

 	* 참고 : 클라이언트가 HTTP 101 응답을받는 즉시, 연결은 더 이상 HTTP와 연결되었다고 간주되지 않습니다.


 */
	
	// 클라이언트에서 웹 소켓 생성. /웹 소켓으로 통신을 하려면 변환 작업이 필요하다 : handshakeInterceptor가 해준다.		
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wshandler, Map<String, Object> map) throws Exception{
		
		// 위의 파라미터 중, attribute에 값을 저장하면 웹소켓 핸들러 클래스의 webSocketSession에 전달된다.
		
		 System.out.println("Before Handshake");
		 

		 ServletServerHttpRequest ssreq = (ServletServerHttpRequest) request;
		 System.out.println("URI : " + request.getURI());                                                                                                
		 
		 HttpServletRequest req = ssreq.getServletRequest();
		 
		 /*
		  String name = (String)req.getSession().getAttribute("name");
		  map.put("userName", name);
		  System.out.print("HttpSession에 저장된 name : " + name ); 
		  */
		 
		 String id = (String)req.getSession().getAttribute("id");
		 map.put("userId", id);
		 System.out.println("HttpSession에 저장된 id : " + id);

		 // handler가 필요한 정보는 map을 통해 전달
		 return super.beforeHandshake(request, response, wshandler, map);
	}
	
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wdhandler, Exception ex) {
		
		System.out.println("After Handshake");
		super.afterHandshake(request, response, wdhandler, ex);
	}
	
	
	
}
















