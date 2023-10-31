package com.sso.study.service;

import com.sso.study.repository.MemberEntityRepository;
import com.sso.study.entity.Member;
import com.sso.study.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
//    private final MemberEntityRepository memberEntityRepository;
    private final MemberRepository memberRepository;

    public Long save(Member member) {
        return memberRepository.save(member).getId();
    }

    public String findByMemberId(Long memberId) {
        Member findMember = memberRepository.findById(memberId).get();
        return findMember.getName();
    }

    public String update(Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        member.setName("이희원");
        return member.getName();
    }

    public String delete(Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        memberRepository.delete(member);
        return member.getName();
    }
}
