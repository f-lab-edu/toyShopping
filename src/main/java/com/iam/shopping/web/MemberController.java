package com.iam.shopping.web;

import com.iam.shopping.domain.Member;
import com.iam.shopping.mapper.MemberMapper;
import com.iam.shopping.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/member")
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void memberSignupPOST(Member member) {
        memberService.memberSignup(member);
    }
}
