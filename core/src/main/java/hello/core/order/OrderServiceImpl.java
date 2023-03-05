package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FIxDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    //MemoryMemberRepository 와 FIxDiscountPolicy 를 구현체로서 사용
    //private final DiscountPolicy discountPolicy = new FIxDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //만일 주문생성이 오면
        Member member = memberRepository.findById(memberId);
        //누가 주문했는지 먼저 조회하고
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //할인정책에 회원정보와 물건가격을 넘겨준다 --> 그럼 알아서 최종적으로 할인된 가격을 받음.
        return new Order(memberId, itemName,itemPrice,discountPrice);
        //최종적으로 생성된 주문을 반환(주문자,물건이름,물건가격,할인가격)
    }
    //Test용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
