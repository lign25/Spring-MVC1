package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//앱 실제 동작에 필요한 구현객체를 생성, 객체의 생성과 연결을 AppConfig가 담당.
//설계 변경으로 인해 DIP를 지키는 설계방식
public class AppConfig {

    public MemberService memberService() {
        //생성자 주입
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
