package ronick.projectLimbo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ronick.projectLimbo.domain.Tb_user;
import ronick.projectLimbo.service.MemberService;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /* --- 데이터 삽입 시작 --- */
    @GetMapping("/test-new")
    public String createUserForm(){
        return "/user/createUserForm";
    }

    @PostMapping("/user/new")
    public String createUserForm(UserForm userForm){
        // sequence 값 제외하고 전부 세팅한후 join
        Tb_user member = new Tb_user();
        member.setKakao_name(userForm.getKakao_name());
        member.setItem(userForm.getItem());
        member.setPlay_hour(userForm.getPlay_hour());
        member.setRanking(userForm.getRanking());

        memberService.join(member);

        return "redirect:/";
    }
    /* --- 데이터 삽입 끝 --- */

    // user 정보 표시
    @GetMapping("/user-info-summary")
    public String info_summary(Model model){
        List<Tb_user> members = memberService.findMembers();
        model.addAttribute("users", members);
        return "/user/info-summary";
    }

    // login
    @GetMapping("/restAPItest")
    public String restAPItest(){
        return "/user/restAPItest";
    }

}
