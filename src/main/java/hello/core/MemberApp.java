package hello.core;

import hello.core.member.grade;
import hello.core.member.member;
import hello.core.member.memberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        // AppConfig appConfig = new AppConfig();
        // memberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService memberService = applicationContext.getBean("memberService",  memberService.class);

        member member = new member(1L, "memberA", grade.VIP); //member 만들기
        memberService.join(member);

        member findMember = memberService.findMember(1L);
        System.out.println("newMember = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
