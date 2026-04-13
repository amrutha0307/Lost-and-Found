package com.lostfound.lostfound.repository;

import com.lostfound.lostfound.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
}