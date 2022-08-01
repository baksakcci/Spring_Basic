package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.memberRepository;
import hello.core.member.memberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    @Test
    void ConfigurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        memberServiceImpl memberService = ac.getBean("memberService", memberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        memberRepository memberRepository = ac.getBean("MemberRepository", memberRepository.class);

        System.out.println("memberService -> memberRepository" + memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository " + orderService.getMemberRepository());
        System.out.println("MemberRepository = " + memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void ConfigurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean);
    }
}