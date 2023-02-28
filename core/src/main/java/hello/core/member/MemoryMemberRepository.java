package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
    //MemberRepository(인터페이스)를 통해서 실제로 동작할 구현체
    //구현체는 메서드는 죄다 @Override , 만드는 변수도 static
    //동시성 이슈가 있을수도 있으므로 ConcurrentHashMap 사용해야한다..(여러 곳에서 동시에 접근)
    private static Map<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
