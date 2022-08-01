package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.memberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class singletonTest {

    @Test
    @DisplayName("스프링 없이 순수한 DI 컨테이너 사용 -> AppConfig")
    void pureSingletonTest() {
        AppConfig appConfig = new AppConfig();

        // 조회
        memberService memberService1 = appConfig.memberService();

        // 조회
        memberService memberService2 = appConfig.memberService();

        // 객체 참조값이 같은지 비교
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // 객체 참조값이 같은지 assertThat 으로 비교
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("Singleton 패턴을 사용한 컨테이너 사용")
    void SingletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);

        singletonService1.logic();
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // 조회
        memberService memberService1 = ac.getBean("memberService", memberService.class);

        // 조회
        memberService memberService2 = ac.getBean("memberService", memberService.class);

        // 객체 참조값이 같은지 비교
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // 객체 참조값이 같은지 assertThat 으로 비교
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}