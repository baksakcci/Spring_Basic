package hello.core.discount;

import hello.core.member.member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(member member, int price);

}
