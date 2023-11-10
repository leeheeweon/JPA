package com.kaoni.seminarexhellojpa.service;

import com.kaoni.seminarexhellojpa.entity.Member;
import com.kaoni.seminarexhellojpa.repository.MemberRepositoryV1;
import com.kaoni.seminarexhellojpa.repository.MemberRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepositoryV1 memberRepositoryV1;
    private final MemberRepositoryV2 memberRepositoryV2;
    public Long createV1(Member member) {
        return memberRepositoryV1.save(member);
    }

    public Member findV1(Long memberId) {
        return memberRepositoryV1.find(memberId);
    }

    public Member updateV1(Long memberId) {
        return memberRepositoryV1.update(memberId);
    }

    public void deleteV1(Long memberId) {
        memberRepositoryV1.delete(memberId);
    }

    public Long createV2(Member member) {
        return memberRepositoryV2.save(member);
    }

    public Member findV2(Long memberId) {
        return memberRepositoryV2.find(memberId);
    }

    public Member updateV3(Long memberId) {
        return memberRepositoryV2.update(memberId);
    }

    public void deleteV4(Long memberId) {
        memberRepositoryV2.delete(memberId);
    }
}
