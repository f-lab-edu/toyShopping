package com.iam.shopping.service;

import com.iam.shopping.domain.Member;
import com.iam.shopping.dto.MemberDTO;
import com.iam.shopping.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {
    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public List<Member> memberList() {
        return memberMapper.selectMember();
    }

    public void memberRegister(MemberDTO memberDTO) {
        Map<String, Object> memberMap = Map.of("id", memberDTO.getId()
                , "pass", memberDTO.getPass()
                , "name", memberDTO.getName()
                , "phone", memberDTO.getPhone());
        if (memberDTO.isTest()) return;
        int isSuccess = memberMapper.insertMember(memberMap);
    }

    public void memberDelete(MemberDTO memberDTO) {
        Map<String, Object> memberMap = Map.of("id", memberDTO.getId());
        if (memberDTO.isTest()) return;
        int isSuccess = memberMapper.deleteMember(memberMap);
    }
}
