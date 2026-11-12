package egovframework.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 계좌 조회 API 데모 애플리케이션.
 * 전자정부 표준프레임워크 관례대로 빈 설정은 egovframework/spring/context-*.xml 에 둔다.
 */
@SpringBootApplication
@ImportResource("classpath:/egovframework/spring/context-*.xml")
public class EgovBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(EgovBootApplication.class, args);
    }
}
