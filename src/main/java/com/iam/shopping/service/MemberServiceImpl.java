package com.iam.shopping.service;

import com.iam.shopping.domain.Member;
import com.iam.shopping.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void memberSignup(Member member) {
        memberMapper.memberInsert(member);
    }
}
