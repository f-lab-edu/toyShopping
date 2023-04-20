package com.iam.shopping.mapper;

import com.iam.shopping.domain.Member;
import com.iam.shopping.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {
    public List<Member> selectMember();
    public int insertMember(Map<String, Object> memberMap);
    public int deleteMember(Map<String, Object> memberMap);
}
