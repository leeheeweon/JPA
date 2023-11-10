package com.kaoni.seminarexhellojpa.repository;

import com.kaoni.seminarexhellojpa.entity.Team;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class TeamRepository {
private final EntityManager em;

    public void save(Team team) {
        em.persist(team);
    }

}
