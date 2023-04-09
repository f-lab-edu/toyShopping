package com.iam.shopping.mapper;

import com.iam.shopping.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public void memberInsert(Member member);
}
