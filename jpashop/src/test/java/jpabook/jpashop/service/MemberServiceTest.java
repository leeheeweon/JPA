package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepositoryOld;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepositoryOld memberRepositoryOld;

    @Test
    @Rollback(value = false)
    void 회원가입() {
        Member member = new Member();
        member.setName("leeheeweon");

        Long savedId = memberService.join(member);
        Assertions.assertEquals(member, memberRepositoryOld.member(savedId));
    }

    @Test
    void 중복회원예외() {
        Member member1 = new Member();
        member1.setName("leeheeweon");

        Member member2 = new Member();
        member2.setName("leeheeweon");

        memberService.join(member1);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });
    }
}