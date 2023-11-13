package com.kaoni.seminarexhellojpa.service;

import com.kaoni.seminarexhellojpa.entity.Member;
import com.kaoni.seminarexhellojpa.entity.Team;
import com.kaoni.seminarexhellojpa.repository.MemberRepositoryV1;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class MemberServiceV1Test {

    @PersistenceContext
    EntityManager em;

    @Autowired
    MemberRepositoryV1 repositoryV1;

    @Test
    void saveV1() {
        Team team = new Team("Kaoni");
        em.persist(team);
        Member member = new Member("leeheeweon", team);
        repositoryV1.save(member);

        Member findMember = em.find(Member.class, member.getId());
        System.out.println("영속성 컨텍스트, 1차 캐쉬 저장, select 문 발생 x em.persist시 영속성 컨텍스트 1차 캐쉬에서 가져옴 ");
        System.out.println(findMember.toString());
    }

    @Test
    @Rollback(value = false)
    void updateV1() {
        Member member = getMember();
        Member findMember = repositoryV1.find(member.getId());

        findMember.setUsername("kaoni");
        System.out.println("영속성 컨텍스트, 변경 감지(Dirty Checking)");
        System.out.println("findMember = " + findMember);
    }

    @Test
    void readV1() {
        Member member = getMember();
        Member findMember = repositoryV1.find(member.getId());
        System.out.println(findMember);
    }

    @Test
    void deleteV1() {
        Member member = getMember();
        repositoryV1.delete(member.getId());
    }


    @Test
    void JPQL() {
        Team team = new Team("Kaoni");
        em.persist(team);

        for (int i = 0; i < 10; i++) {
            Member member = new Member("leeheeweon" + i, team);
            repositoryV1.save(member);
        }

        System.out.println("----JPQL SELECT LIST----");
        List<Member> result = em.createQuery("select m from Member m", Member.class)
                .getResultList();
        System.out.println("영속성 컨텍스트, 트랜잭션을 지원하는 쓰기, 쿼리문을 모아서 실행 select문 발생x ");
        for (Member findMember : result) {
            System.out.println(findMember);
        }

        System.out.println("----JPQL WHERE----");
        List<Member> where = em.createQuery("select m from Member m where m.id=:id ", Member.class)
                .setParameter("id", 1L)
                .getResultList();
        System.out.println("where = " + where);

        System.out.println("----JPQL WHERE, SINGLE----");
        Member single = em.createQuery("select m from Member m where m.id=:id ", Member.class)
                .setParameter("id", 1L)
                .getSingleResult();
        System.out.println("single = " + single);

        System.out.println("----JPQL PAGING----");
        List<Member> paging = em.createQuery("select m from Member m", Member.class)
                .setFirstResult(2)
                .setMaxResults(3)
                .getResultList();
        for (Member findMember : paging) {
            System.out.println(findMember);
        }

        System.out.println("----JPQL JOIN----");
        Member join = em.createQuery("select m from Member m join m.team t where m.id=:id ", Member.class)
                .setParameter("id", 1L)
                .getSingleResult();
        System.out.println("join = " + join);
    }

    private Member getMember() {
        Team team = new Team("Kaoni");
        em.persist(team);

        Member member = new Member("leeheeweon", team);
        repositoryV1.save(member);
        return member;
    }
}