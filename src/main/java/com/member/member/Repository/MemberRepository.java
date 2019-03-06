package com.member.member.Repository;

import com.member.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {
    List<Member> findAllByName(String name);
    List<Member> findByName(String name);
    List<Member> findByEmail(String email);
    List<Member> findAllById(String id);
}
