package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FIxDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//Configuration -->? 설정 정보에 쓰는 어노테이션 
//Bean --> 스프링 컨테이너에 등록
public class AppConfig {
    //의존성 주입? -> Dependency Injection
    //IoC(Inversion of Control) ==> 프로그램을의 제어흐름을 직접제어하는것이 아니라 외부에서 관리하는 것.(App Config가 하는것마냥)
    //@Bean(name="") 이있는데 Spring 객체 찾을때 .getBean("name")에서 호출하는 이름을 바꿀수있다.단 잘쓰지말자..[관례]
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
