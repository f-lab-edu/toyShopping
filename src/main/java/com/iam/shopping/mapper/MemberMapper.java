package com.iam.shopping.mapper;

import com.iam.shopping.domain.Member;
import com.iam.shopping.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {
    public List<Member> selectMember();
    public void insertMember(Member member);
    public void deleteMember(Map<String, Object> memberMap);
}
