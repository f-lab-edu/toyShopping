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

    public void memberRegister(Member member) {
        memberMapper.insertMember(member);
    }

    public void memberDelete(MemberDTO memberDTO) {
        Map<String, Object> memberMap = Map.of("id", memberDTO.getId());
        memberMapper.deleteMember(memberMap);
    }
}
