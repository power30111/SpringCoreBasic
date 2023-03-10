package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FIxDiscountPolicy implements DiscountPolicy{
    //DiscountPolicy가 고정된 할인 정책일 경우의 구현체
    private int discountFixAmount = 1000;   //고정된 할인금액
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            // == 으로 비교하는게 맞나요? --> enum형일경우 == 쓰자.
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
