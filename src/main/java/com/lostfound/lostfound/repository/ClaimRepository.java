package com.lostfound.lostfound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lostfound.lostfound.model.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
}