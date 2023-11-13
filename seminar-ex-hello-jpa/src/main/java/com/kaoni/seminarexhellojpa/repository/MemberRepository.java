package com.kaoni.seminarexhellojpa.repository;

import com.kaoni.seminarexhellojpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "select m from Member m where m.username like concat(:username,'%') ")
    List<Member> findMembersById(@Param("username") String username);
}
