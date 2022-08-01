package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.memberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class AutoAppConfigTest {
    @Test
    void BasicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        memberService memberService = ac.getBean((memberService.class));
        Assertions.assertThat(memberService).isInstanceOf(memberService.class);
    }
}