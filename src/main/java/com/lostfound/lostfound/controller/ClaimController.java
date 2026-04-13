package com.lostfound.lostfound.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lostfound.lostfound.dto.ClaimRequestDto;
import com.lostfound.lostfound.dto.ClaimResponseDto;
import com.lostfound.lostfound.service.ClaimService;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping
    public ResponseEntity<ClaimResponseDto> createClaim(@RequestBody ClaimRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(claimService.createClaim(request));
    }

    @PutMapping("/{id}/verify")
    public ResponseEntity<ClaimResponseDto> verifyClaim(
            @PathVariable Long id,
            @RequestParam String status) {

        return ResponseEntity.ok(claimService.verifyClaim(id, status));
    }
}