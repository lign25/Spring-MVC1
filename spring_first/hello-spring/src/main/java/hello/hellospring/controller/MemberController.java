package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    //스프링 컨테이너에서 MemberService 가져오기
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //이렇게 URL 직접입력해서 접근하는 방식이 GetMapping
    //또한 GET은 조회할 때 주로 사용
    //members/createMemberForm으로 이동
    //뷰 리졸버를 통해 createMemberForm.html이 선택됨
    //타임리프 템플릿 엔진이 해당 html파일을 렌더링함
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    //데이터를 폼에 넣어서 전달할 때 PostMapping사용
    //또한 POST는 데이터를 등록할 때 주로 사용
    @PostMapping("members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        //form속의 name값을 가져와서 member의 name으로 복사
        member.setName(form.getName());

        memberService.join(member);

        return  "redirect:/";
    }

    @GetMapping("/members")
    //member의 리스트 자체를 담아서 view에 전달
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}

