package com.sso.study.repository;

import com.sso.study.entity.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberEntityRepository {
    private final EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public String findByMemberId(Long memberId) {
        return em.createQuery("select m from Member m where m.name=:name", Member.class)
                .setParameter("name", "김대현")
                .getSingleResult().getName();
    }

    public String update(Long memberId) {
        Member member = em.find(Member.class, memberId);
        member.setName("이희원");
        return member.getName();
    }

    public String delete(Long memberId) {
        Member member = em.find(Member.class, memberId);
        em.remove(member);
        return "삭제";
    }
}
