package hello.core.beanFind;

import hello.core.AppConfig;
import hello.core.member.memberService;
import hello.core.member.memberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름, 타입을 이용해 조회")
    void findBeanByName() {
        memberService memberService = ac.getBean("memberService", memberService.class);
        System.out.println("memberService = " + memberService +
                "\nmemberService.getClass = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(memberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 타입으로만 조회")
    void findBeanByType() {
        memberService memberService = ac.getBean(memberService.class);
        System.out.println("memberService = " + memberService);
        assertThat(memberService).isInstanceOf(memberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByInstanceType() {
        memberServiceImpl memberService = ac.getBean(memberServiceImpl.class);
        System.out.println("memberService = " + memberService);
        assertThat(memberService).isInstanceOf(memberServiceImpl.class);
    }

    @Test
    @DisplayName("다른 빈 이름으로 조회했을 때")
    void findBeanByNameX() {
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", memberService.class));
    }
}
