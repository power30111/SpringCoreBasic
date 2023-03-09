package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        //ConfigurableApplicationContext ==> close메서드 지원을 위해 사용
        //Configurable...가 AnnotationConfigApplication..보다 상위인터페이스 이다(즉 부모 인터페이스에는 담을수있음)
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }
    @Configuration
    static class LifeCycleConfig{
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spirng.dev");
            return networkClient;
        }
    }
}
