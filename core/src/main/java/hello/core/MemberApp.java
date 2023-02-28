package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    //psvm 치면 아래 public static void main이 나오네요..
    //Ctrl + Alt + v = 객체 선언시 이름바꾸기 편하게 ㅇㅇ?
    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        //새로운 멤버 생성
        memberService.join(member);
        //memberRepository에 member란 회원 저장

        Member findMember = memberService.findMember(1L);
        System.out.println("find Member = " + findMember.getName());
        System.out.println("new Member = " + member.getName());
    }
}
