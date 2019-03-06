package com.member.member.Service;

import com.member.member.Member;

import java.util.List;

public interface MemberService {
    Member create(Member member);
    Member findId(String id);
    Member update(Member member);
    List<Member> findAll();
    Member delete(String id);
}
