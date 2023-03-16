package com.iam.shopping.controller.member;

import com.iam.shopping.domain.member.MemberRepository;
import com.iam.shopping.domain.member.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member")
public class MemberController {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup() {
        return "member/signup";
    }

    @PostMapping("/signup")
    public String saveMember(@RequestParam("id") String id,
                             @RequestParam("pass") String pass,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone,
                             Model model) {
        MemberVO memberVO = new MemberVO(id, pass, name, phone);
        memberRepository.save(memberVO);
        model.addAttribute("member", memberVO);

        return "index";
    }
}
