package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //MemberService(회원가입과 회원조회 기능)의 구현체
    //당연히 MemberRepository에 저장된 데이터를 불러와야 하므로 MemberRepository를 선언해주는데, 이때 인터페이스만 선언되어있으면 구현체가 없어서 Null
    //그러므로 구현객체를 선택해줘야한다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
    //구현체
}
