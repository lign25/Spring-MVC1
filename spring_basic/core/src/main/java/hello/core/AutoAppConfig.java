package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
//@Component: 자동으로 class path에 있는 내부에 있는 Component가 붙어있는 함수를 자동으로 스프링 컨테이너에 등록
//이후 의존관계를 주입해 주어야하는데, 이것을 Autowired를 이용하여 설정
@ComponentScan(
        //탐색할 패키지의 시작 위치를 지정한다
        basePackages = "hello.core.member",
        //지정한 컴포넌트 스캔 중 제외할 내용
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)

)
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
