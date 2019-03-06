package com.member.member;

import com.member.member.Repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testRepository(){
        Member member = new Member();
        member.setId("1");
        member.setName("Member1");
        member.setEmail("afad@email.com");
        member.setPassword("12345678");
        member.setAddress("dir");

        memberRepository.save(member);

        Page<Member> page = memberRepository.findAll(PageRequest.of(0,10));
        List<Member> list = page.getContent();
        page.getTotalElements();
        page.getTotalPages();

        Optional<Member> optional = memberRepository.findById("1");
        if(optional.isPresent()){
            Member temp = optional.get();
        }else{
            //gak ada
        }

    }

}
