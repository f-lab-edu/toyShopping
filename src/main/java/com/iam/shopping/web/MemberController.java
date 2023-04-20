package com.iam.shopping.web;

import com.iam.shopping.domain.Member;
import com.iam.shopping.dto.MemberDTO;
import com.iam.shopping.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/member")
@RestController
public class MemberController {
    private final MemberService memberService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(value = "/memberList", method = RequestMethod.GET)
    public List<Member> memberList() {
        return memberService.memberList();
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void memberSignupPOST(@RequestBody Member member) {
        logger.info("info log = {}", member);
        memberService.memberRegister(member);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void memberDelete(@PathVariable("id") String id) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(id);
        memberService.memberDelete(memberDTO);
    }
}
