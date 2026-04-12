package com.lostfound.lostfound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lostfound.lostfound.model.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
