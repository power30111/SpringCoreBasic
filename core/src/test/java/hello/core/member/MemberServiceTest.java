package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.system.ApplicationPid;

//assertThat => 비교하기위해 사용
public class MemberServiceTest {
    MemberService memberService;
    @BeforeEach
    //@BeforeEach => 테스트 실행전 작동하는 부분
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join(){
        //given --> 이런게 주어졌을때
        Member member = new Member(1L,"memberA",Grade.VIP);

        //when  --> 이렇게 했을때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then  --> 이렇게 된다.
        //Assertions 사용시 Assertions꺼를 import 하자.

        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
