package com.iam.shopping.domain.member;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {
    private static final Map<Long, MemberVO> store = new HashMap<>();
    private static long sequence = 0L;

    // 회원 저장
    public MemberVO save(MemberVO memberVO) {
        sequence += 1;
        memberVO.setNum(sequence);
        store.put(memberVO.getNum(), memberVO);
        return memberVO;
    }

    public void clearStore() {
        store.clear();
    }
}
