package com.sso.study.repository;

import com.sso.study.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findMemberNameByName(String memberName);

    @Query("select m from Member m where m.name=:name")
    Member getMemberName(@Param("name") String memberName);
}
