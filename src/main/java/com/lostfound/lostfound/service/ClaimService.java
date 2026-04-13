package com.lostfound.lostfound.service;

import com.lostfound.lostfound.dto.ClaimRequestDto;
import com.lostfound.lostfound.dto.ClaimResponseDto;

public interface ClaimService {

    ClaimResponseDto createClaim(ClaimRequestDto request);

    ClaimResponseDto verifyClaim(Long id, String status);
}