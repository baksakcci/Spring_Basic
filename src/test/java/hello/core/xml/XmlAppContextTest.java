package hello.core.xml;

import hello.core.member.memberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContextTest {
    ApplicationContext ac = new GenericXmlApplicationContext("AppConfig.xml");

    @Test
    void xmlTest() {
        memberService memberService = ac.getBean("memberService", memberService.class);
        Assertions.assertThat(memberService).isInstanceOf(memberService.class);
    }
}
