package com.lostfound.lostfound.service.impl;

import com.lostfound.lostfound.dto.ClaimDTO;
import com.lostfound.lostfound.model.Claim;
import com.lostfound.lostfound.repository.ClaimRepository;
import com.lostfound.lostfound.service.ClaimService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository repository;

    @Override
    public Claim createClaim(ClaimDTO dto) {
        Claim claim = new Claim();
        claim.setMatchId(dto.getMatchId());
        claim.setUserId(dto.getUserId());
        claim.setProof(dto.getProof());
        claim.setStatus("PENDING");

        return repository.save(claim);
    }

    @Override
    public Claim verifyClaim(Long id, String status) {
        Claim claim = repository.findById(id).orElse(null);

        if (claim != null) {
            claim.setStatus(status); // APPROVED or REJECTED
            return repository.save(claim);
        }

        return null;
    }
}