package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

//assertThat => 비교하기위해 사용
public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();
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
