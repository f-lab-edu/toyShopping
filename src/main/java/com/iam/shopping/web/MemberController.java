package com.iam.shopping.web;

import com.iam.shopping.domain.Member;
import com.iam.shopping.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/member")
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Member memberInfo() {
        Member member = new Member();
        member.setId("test@naver.com");
        member.setPass("1234");
        member.setName("이동호");
        member.setPhone("010-4819-6169");
        return member;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void memberSignupPOST(@RequestBody Member member) {
        System.out.println(member);
        memberService.memberSignup(member);
    }
}
