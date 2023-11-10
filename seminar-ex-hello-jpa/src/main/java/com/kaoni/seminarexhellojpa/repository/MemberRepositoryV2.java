package com.kaoni.seminarexhellojpa.repository;

import com.kaoni.seminarexhellojpa.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryV2 {
    private final EntityManager em;


    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long memberId) {
        Member findMember = em.createQuery("select m from Member m where m.id=:memberId ", Member.class)
                .setParameter("memberId", memberId)
                .getSingleResult();

        return findMember;
    }

    public Member update(Long memberId) {
        Member findMember = em.createQuery("select m from Member m where m.id=:memberId ", Member.class)
                .setParameter("memberId", memberId)
                .getSingleResult();

        findMember.setUsername("Kaoni");
        return findMember;
    }

    public void delete(Long memberId) {
        em.createQuery("delete from Member m where m.id =:memberId")
                .setParameter("memberId", memberId);
    }
}
