package com.kaoni.seminarexhellojpa.service;

import com.kaoni.seminarexhellojpa.entity.Member;
import com.kaoni.seminarexhellojpa.entity.Team;
import com.kaoni.seminarexhellojpa.repository.MemberRepository;
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
class MemberServiceV2Test {

    @PersistenceContext
    EntityManager em;

    @Autowired
    MemberRepository repositoryV2;

    @Test
    void saveV1() {
        Team team = new Team("Kaoni");
        em.persist(team);
        Member member = new Member("leeheeweon", team);
        repositoryV2.save(member);

        Member findMember = repositoryV2.findById(member.getId()).get();
        System.out.println(findMember.toString());
    }

    @Test
    @Rollback(value = false)
    void updateV1() {
        Member member = getMember();
        Member findMember = repositoryV2.findById(member.getId()).get();
        findMember.setUsername("kaoni");
        System.out.println("findMember = " + findMember);
    }

    @Test
    void readV1() {
        Member member = getMember();
        Member findMember = repositoryV2.findById(member.getId()).get();
        System.out.println(findMember);
    }

    @Test
    void deleteV1() {
        Member member = getMember();
        repositoryV2.delete(member);
    }


    @Test
    void springDataJPQL() {
        Team team = new Team("Kaoni");
        em.persist(team);

        for (int i = 0; i < 10; i++) {
            Member member = new Member("leeheeweon" + i, team);
            repositoryV2.save(member);
        }

        List<Member> leeheeweon = repositoryV2.findMembersById("leeheeweon");
        for (Member member : leeheeweon) {
            System.out.println("member = " + member);
        }
    }

    private Member getMember() {
        Team team = new Team("Kaoni");
        em.persist(team);

        Member member = new Member("leeheeweon", team);
        repositoryV2.save(member);
        return member;
    }
}