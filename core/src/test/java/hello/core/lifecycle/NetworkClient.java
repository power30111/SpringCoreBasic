package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {    //NectworkClient가 생성할때 connect , call 메서드 실행
        System.out.println("생성자 호출, url = "+url);
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url){
        this.url=url;
    }
    //서비스를 시작할때 호출하는 메서드
    public void connect(){
        System.out.println("connect : "+url);
    }
    public void call(String message){
        System.out.println("call: "+url+" message = "+message);
    }
    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close "+url);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메세지");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}