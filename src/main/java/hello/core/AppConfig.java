package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.memberRepository;
import hello.core.member.memberService;
import hello.core.member.memberServiceImpl;
import hello.core.member.memoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public memberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new memberServiceImpl(MemberRepository());
    }
    @Bean
    public memberRepository MemberRepository() {
        System.out.println("call AppConfig.MemberRepository");
        return new memoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(MemberRepository(), DiscountPolicy());
        // return null;
    }
    @Bean
    public DiscountPolicy DiscountPolicy()  { return new FixDiscountPolicy();
    }
}
