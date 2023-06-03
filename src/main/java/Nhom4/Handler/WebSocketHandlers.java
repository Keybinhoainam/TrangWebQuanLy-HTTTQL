package Nhom4.Handler;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import Nhom4.Model.NhanVien;
import Nhom4.Responsitory.NhanVienResponsitory;
import Nhom4.Service.NhanVienService;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
public class WebSocketHandlers extends TextWebSocketHandler {
    @Getter
    List<WebSocketSession> list = new ArrayList<>();
    
    @Autowired
    NhanVienService nhanVienResponsitory;
    
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException, InterruptedException {
        log.info("Test message {}", message.toString());
        list.add(session);
//        session.sendMessage( new TextMessage("Hello world"));
        
        
        double currentMemory = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
        String s2=Double.toString(currentMemory);
        
        
        List<NhanVien> lnv=nhanVienResponsitory.findAll();
        int size=lnv.size();
        String s=Integer.toString(size);
        session.sendMessage( new TextMessage(s2));
//        Thread.sleep(1000);
    }

}
