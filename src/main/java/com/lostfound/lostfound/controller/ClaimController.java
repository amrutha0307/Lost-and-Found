package com.lostfound.lostfound.controller;

import com.lostfound.lostfound.dto.ClaimDTO;
import com.lostfound.lostfound.model.Claim;
import com.lostfound.lostfound.service.ClaimService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    @Autowired
    private ClaimService service;

    // CREATE CLAIM
    @PostMapping
    public Claim createClaim(@RequestBody ClaimDTO dto) {
        return service.createClaim(dto);
    }

    // VERIFY CLAIM
    @PutMapping("/verify/{id}")
    public Claim verifyClaim(@PathVariable Long id, @RequestParam String status) {
        return service.verifyClaim(id, status);
    }
}