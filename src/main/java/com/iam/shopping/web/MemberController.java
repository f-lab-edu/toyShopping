package com.iam.shopping.web;

import com.iam.shopping.domain.Member;
import com.iam.shopping.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void memberSignupPOST(@RequestBody Member member) {
        logger.info("info log = {}", member);
        memberService.memberSignup(member);
    }
}
