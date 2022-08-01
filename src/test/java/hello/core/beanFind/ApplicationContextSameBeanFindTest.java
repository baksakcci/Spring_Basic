package hello.core.beanFind;

import hello.core.member.memberRepository;
import hello.core.member.memoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Configuration
    static class SameBeanConfig {

        @Bean
        public memberRepository MemberRepository1() {
            return new memoryMemberRepository();
        }

        @Bean
        public memberRepository MemberRepository2() {
            return new memoryMemberRepository();
        }
    }

    @Test
    @DisplayName("타입으로 조회할 때 같은 타입이 2개 이상 있다면 오류 발생")
    void findBeanByTypeDuplicate() {
        // memberRepository memberRepository = ac.getBean(hello.core.member.memberRepository.class);
        memberRepository memberRepository = ac.getBean("MemberRepository1", memberRepository.class);
        Assertions.assertThat(memberRepository).isInstanceOf(memoryMemberRepository.class);
    }
    // 이름으로 조회하면 된다.

    @Test
    @DisplayName("같은 타입들끼리 모두 조회하고 싶다")
    void findBeanByTypeAll() {
        Map<String, memberRepository> beansOfType = ac.getBeansOfType(memberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key); //key
        }
        System.out.println("beansOfType = " + beansOfType); //value
    Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }
}
