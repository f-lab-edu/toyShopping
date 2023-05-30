package com.iam.shopping.service;

import com.iam.shopping.domain.Member;
import com.iam.shopping.exception.LoginException;
import com.iam.shopping.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final MemberMapper memberMapper;

    public LoginService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public Optional<Member> findByLoginId(String loginId) {
        return Optional.ofNullable(memberMapper.selectMember()
                .stream()
                .filter(cond -> cond.getId().equals(loginId))
                .findFirst()
                .orElseThrow(() -> new LoginException("이메일 ID가 존재하지 않습니다.")));
    }

    public Member login(String loginId, String password) {
        return findByLoginId(loginId)
                .filter(cond -> cond.getPass().equals(password))
                .orElseThrow(() -> new LoginException("비밀번호가 맞지 않습니다."));
    }
}
