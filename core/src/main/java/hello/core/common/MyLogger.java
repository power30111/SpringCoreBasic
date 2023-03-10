package hello.core.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)//proxyMode = 가짜 프록시 객체를 만들어서 주입.
//적용대상이 인터페이스가 아닌 클래스면 TARGET_CLASS, 인터페이스면 INTERFACES
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("["+ uuid+"]"+"["+requestURL+"] "+message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();    // 랜덤한 UUID를 만드는 메서드. 확률이 로또보다 낮다고한다..
        System.out.println("["+ uuid +"] request scope bean create: "+this);
    }
    @PreDestroy
    public void close(){
        System.out.println("["+ uuid +"] request scope bean close: "+this);
    }
}
