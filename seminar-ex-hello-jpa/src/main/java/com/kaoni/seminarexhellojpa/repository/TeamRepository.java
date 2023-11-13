package com.kaoni.seminarexhellojpa.repository;

import com.kaoni.seminarexhellojpa.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    
}
