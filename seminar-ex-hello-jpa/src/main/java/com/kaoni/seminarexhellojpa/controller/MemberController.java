package com.kaoni.seminarexhellojpa.controller;

import com.kaoni.seminarexhellojpa.entity.Member;
import com.kaoni.seminarexhellojpa.entity.Team;
import com.kaoni.seminarexhellojpa.repository.TeamRepository;
import com.kaoni.seminarexhellojpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final TeamRepository teamRepository;
    @GetMapping("v1/c")
    public Long createV1() {
        Team kaoni = new Team("Kaoni");
        teamRepository.save(kaoni);

        Member member = new Member("lhw", kaoni);
        Long savedId = memberService.createV1(member);
        return savedId;
    }

    @GetMapping("v1/r")
    public Member readV1() {
        Member findMember = memberService.findV1(1L);
        return findMember;
    }

    @GetMapping("v1/u")
    public Member updateV1() {
        Member updatedMember = memberService.updateV1(1L);
        return updatedMember;
    }

    @GetMapping("v1/d")
    public String deleteV2() {
        memberService.deleteV1(1L);
        return "ok";
    }


}
