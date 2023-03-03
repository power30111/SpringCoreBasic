package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    //iter ==> 리스트 같은 iter한 자료형이 있으면 알아서 for 문 생성
    //soutm soutv soutp 등등 이런게 있는데 이거 System.out.println 줄여서 쓰는거인듯
    //코드 드래그 한 이후 Ctrl+D --> 드래그 한 문장들 죄다 아래쪽에 복붙해줌
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName+" object"+ bean);
        }

    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            //getBeanDefinition? -> 빈에 대한 메타데이터 정보(하나하나에 대한)
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            //ROLE_APPLICATION? -> 내가 쓰기위해 등록한 빈 or 외부 라이브러리
            //ROLE_INFRASTRUCTURE? -> 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName+" object"+ bean);
            }
        }

    }

}
