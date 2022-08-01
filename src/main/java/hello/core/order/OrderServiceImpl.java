package hello.core.order;

import hello.core.annotation.mainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.member;
import hello.core.member.memberRepository;
import hello.core.member.memoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// @RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // @Autowired private memberRepository memberRepository; 해도 된다.
    private final memberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 의존관계 자동 주입 - 생성자 주입
    // new OrderServiceImpi(memberRepository, discountPolicy) 스프링 관점
    @Autowired
    public OrderServiceImpl(memberRepository memberRepository, @mainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 의존관계 자동 주입 - 수정자 주입
    /*
    @Autowired
    public void setMemberRepository(hello.core.member.memberRepository memberRepository) {
        System.out.println("memberRepository 2 = " + memberRepository);
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("discountPolicy 2 = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }
     */

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // Configuration Test 용도
    public memberRepository getMemberRepository() {
        return memberRepository;
    }
}
