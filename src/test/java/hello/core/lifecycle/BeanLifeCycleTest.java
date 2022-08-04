package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

class BeanLifeCycleTest {

    /*
    빈 생명주기 테스트
    1. 외부 네트워크를 연결하는 객체를 빈으로 생성함
    2. 설정 정보에서 빈 수동등록 (객체 생성을 먼저 하고, URL을 외부에서 나중에 셋팅 후 반환)
    3. getBean 메서드를 통해 반환, close 메서드를 통해 스프링 컨테이너를 종료

    스프링 빈의 이벤트 라이프사이클
    스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 -> 사용 -> 소멸전 콜백 -> 스프링 종료

    라이프사이클 순서를 신경쓰면서 코드를 읽어보자. 출력 타이밍이 맞을것이다.
     */
    @Test
    public void lifeCycleTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close(); // ConfigurableApplicationContext or AnnotationConfigApplicationContext 필요
    }

    @Configuration
    static class LifeCycleConfig {
        // @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient(); // 생성자에서 먼저 실행 -> null값이 나옴
            networkClient.setUrl("http://hello-spring.dev"); // 객체 생성 이후로 URL 설정 -> 나중에는 URL 나옴
            return networkClient;
        }
    }
}