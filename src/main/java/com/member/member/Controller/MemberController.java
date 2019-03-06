package com.member.member.Controller;

import java.util.List;

import com.member.member.Member;
import com.member.member.Service.MembeServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    private MembeServiceImpl memberService;
    public MemberController(MembeServiceImpl memberService){
        this.memberService = memberService;
    }

    @RequestMapping(
            value="/members",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )

    public Member create(@RequestBody Member member){
        return memberService.create(member);
    }

    @RequestMapping(
            value = "/members",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public List<Member> findAll(){
        return memberService.findAll();
    }

    @RequestMapping(
            value = "/members/{idMember}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public Member findById(@PathVariable("idMember")String id){
        return memberService.findId(id);
    }

    @RequestMapping(
            value = "/members/delete/{idMember}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Member delete(@PathVariable("idMember") String idMember){
        return memberService.delete(idMember);
    }

    @RequestMapping(
            value = "/members/update/{idMember}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Member update(@RequestBody Member member){
        return memberService.update(member);
    }
}
