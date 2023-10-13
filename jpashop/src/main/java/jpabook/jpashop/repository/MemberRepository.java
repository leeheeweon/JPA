package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor //spring boot data jpa 사용시 생성자를 만들면 @PersistenceContext 대체 가능
public class MemberRepository {
    
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member member(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where name = :name", Member.class)
                .setParameter("name",name)
                .getResultList();
    }
}