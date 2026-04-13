package com.lostfound.lostfound.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lostfound.lostfound.dto.ClaimRequestDto;
import com.lostfound.lostfound.dto.ClaimResponseDto;
import com.lostfound.lostfound.model.Claim;
import com.lostfound.lostfound.repository.ClaimRepository;
import com.lostfound.lostfound.service.ClaimService;

@Service
@Transactional
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepository;

    public ClaimServiceImpl(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    @Override
    public ClaimResponseDto createClaim(ClaimRequestDto request) {

        Claim claim = new Claim(
                request.getMatchId(),
                request.getUserId(),
                request.getProof(),
                "PENDING"
        );

        Claim saved = claimRepository.save(claim);

        return toDto(saved);
    }

    @Override
    public ClaimResponseDto verifyClaim(Long id, String status) {

        Claim claim = claimRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Claim not found: " + id));

        claim.setStatus(status);

        Claim saved = claimRepository.save(claim);

        return toDto(saved);
    }

    private ClaimResponseDto toDto(Claim claim) {
        return new ClaimResponseDto(
                claim.getId(),
                claim.getMatchId(),
                claim.getUserId(),
                claim.getProof(),
                claim.getStatus()
        );
    }
}