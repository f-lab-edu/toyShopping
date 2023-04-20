package com.iam.shopping.web;

import com.iam.shopping.domain.Member;
import com.iam.shopping.dto.MemberDTO;
import com.iam.shopping.service.MemberService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "member", description = "회원 등록, 조회 및 삭제 API")
@RequestMapping("/member")
@RestController
public class MemberController {
    private final MemberService memberService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Tag(name = "member")
    @Operation(summary = "회원 List 조회", description = "회원 정보를 가입순으로 전체 List를 조회한다.")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Member> memberList() {
        return memberService.memberList();
    }

    @Tag(name = "member")
    @ApiOperation(value = "회원가입", notes = "회원가입")
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void signUp(@RequestBody MemberDTO memberDTO) {
        memberService.memberRegister(memberDTO);
    }

    @Tag(name = "member")
    @ApiOperation(value = "회원삭제", notes = "회원ID를 가져와 해당 회원을 삭제한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "id"
                    , value = "회원ID"
                    , required = true
                    , dataType = "String"
                    , paramType = "path"
                    , defaultValue = "test7@naver.com"
            ),
            @ApiImplicitParam(
                    name = "isTest"
                    , value = "테스트여부"
                    , dataType = "boolean"
                    , paramType = "query"
                    , defaultValue = "true"
            )
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void memberDelete(@PathVariable("id") String id) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(id);
        memberService.memberDelete(memberDTO);
    }
}
