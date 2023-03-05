package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


//Shift 2번 ==> 문서찾기
@Configuration
@ComponentScan(
        basePackages = "hello.core",    //탐색 시작위치를 지정할수있다. Default는 @ComponentScan이 있는 상위 Package를 탐색한다.(hello.core)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
)
public class AutoAppConfig {


}
