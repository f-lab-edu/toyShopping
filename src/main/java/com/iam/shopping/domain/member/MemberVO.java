package com.iam.shopping.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
    private Long num;
    private String id;
    private String pass;
    private String name;
    private String phone;

    public MemberVO() {
    }

    public MemberVO(String id, String pass, String name, String phone) {
        this.id = id;
        this.pass = pass;
        this.name = name;
        this.phone = phone;
    }
}