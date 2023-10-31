package com.sso.study.controller;

import com.sso.study.entity.Member;
import com.sso.study.repository.MemberRepository;
import com.sso.study.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;
    private final MemberRepository repository;

    @GetMapping("/hello")
    public Long test() {
        Member member = new Member();
        member.setName("김대현");
        member.setAge(25);

        return service.save(member);
    }

    @GetMapping("/hello2/{memberId}")
    public String getMember(@PathVariable Long memberId) {
        return service.findByMemberId(memberId);
    }

    @GetMapping("/hello3/{memberId}")
    public String updateMember(@PathVariable Long memberId) {
        return service.update(memberId);
    }

    @GetMapping("/hello4/{memberId}")
    public String deleteMember(@PathVariable Long memberId) {
        return service.delete(memberId);
    }

    @GetMapping("/hello5/{memberName}")
    public String deleteMember(@PathVariable String memberName) {
        Member findMember = repository.getMemberName(memberName);
        return findMember.getName();
    }


}
