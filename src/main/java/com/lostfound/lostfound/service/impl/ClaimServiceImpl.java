package com.lostfound.lostfound.service.impl;

import com.lostfound.lostfound.dto.ClaimDTO;
import com.lostfound.lostfound.model.Claim;
import com.lostfound.lostfound.model.FoundItem;
import com.lostfound.lostfound.model.LostItem;
import com.lostfound.lostfound.model.Match;
import com.lostfound.lostfound.repository.ClaimRepository;
import com.lostfound.lostfound.repository.FoundItemRepository;
import com.lostfound.lostfound.repository.LostItemRepository;
import com.lostfound.lostfound.repository.MatchRepository;
import com.lostfound.lostfound.service.ClaimService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository repository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private LostItemRepository lostItemRepository;

    @Autowired
    private FoundItemRepository foundItemRepository;

    @Override
    public List<Claim> getAllClaims() {
        return repository.findAll();
    }

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
            updateRelatedRecords(claim, status);
            return repository.save(claim);
        }

        return null;
    }

    private void updateRelatedRecords(Claim claim, String status) {
        Match match = matchRepository.findById(claim.getMatchId()).orElse(null);
        if (match == null) {
            return;
        }

        if ("APPROVED".equalsIgnoreCase(status)) {
            match.setStatus("APPROVED");

            LostItem lostItem = lostItemRepository.findById(match.getLostItemId()).orElse(null);
            if (lostItem != null) {
                lostItem.setStatus("CLAIM_APPROVED");
                lostItemRepository.save(lostItem);
            }

            FoundItem foundItem = foundItemRepository.findById(match.getFoundItemId()).orElse(null);
            if (foundItem != null) {
                foundItem.setStatus("CLAIMED");
                foundItemRepository.save(foundItem);
            }
        } else if ("REJECTED".equalsIgnoreCase(status)) {
            match.setStatus("REJECTED");
        }

        matchRepository.save(match);
    }
}
