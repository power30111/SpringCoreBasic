package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    //psvm 치면 아래 public static void main이 나오네요..
    //Ctrl + Alt + v = 객체 선언시 이름바꾸기 편하게 ㅇㅇ?
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        //Spring은 ApplicationContext가 객체들을 관리(Bean 한것들)
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //getBean("이러한 이름을 가진객체를 찾는다")

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        //memberRepository에 member란 회원 저장

        Member findMember = memberService.findMember(1L);
        System.out.println("find Member = " + findMember.getName());
        System.out.println("new Member = " + member.getName());
    }
}
