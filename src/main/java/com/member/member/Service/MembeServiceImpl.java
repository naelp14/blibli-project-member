package com.member.member.Service;

import com.member.member.Member;
import com.member.member.Repository.MemberRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MembeServiceImpl implements MemberService {

    private ArrayList<Member> members = new ArrayList<Member>();
    private MemberRepository memberRepository;
    @Override
    public Member create(Member member) {
        members.add(member);
        return member;
    }

    @Override
    public Member findId(String id) {
        Member temp = new Member();
        for (int i=0;i<members.size();i++){
            if(members.get(i).getId().equals(id)){
                BeanUtils.copyProperties(members.get(i),temp);
                return temp;
            }
        }return null;
    }

    @Override
    public Member update(Member member) {
        for(int i=0;i<members.size();i++){
            if(members.get(i).getId().compareTo(member.getId())==0){
                members.get(i).setEmail(member.getEmail());
                members.get(i).setPassword(member.getPassword());
                members.get(i).setName(member.getName());
                members.get(i).setAddress(member.getAddress());
                return members.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Member> findAll() {
        return members;
    }

    @Override
    public Member delete(String id) {
        Member temp = new Member();
        for (int i=0;i<members.size();i++){
            if(members.get(i).getId().equals(id)){
                BeanUtils.copyProperties(members.get(i),temp);
                members.remove(i);
                return temp;
            }
        }
        return null;
    }
}
