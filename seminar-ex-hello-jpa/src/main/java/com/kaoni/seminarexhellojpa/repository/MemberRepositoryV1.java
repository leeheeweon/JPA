package com.kaoni.seminarexhellojpa.repository;

import com.kaoni.seminarexhellojpa.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryV1 {

    @PersistenceContext
    private EntityManager em;


    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long memberId) {
        return em.find(Member.class, memberId);
    }

    public Member update(Long memberId) {
        Member member = em.find(Member.class, memberId);
        member.setUsername("Kaoni");
        return member;
    }

    public void delete(Long memberId) {
        Member member = em.find(Member.class, memberId);
        em.remove(member);
    }
}
