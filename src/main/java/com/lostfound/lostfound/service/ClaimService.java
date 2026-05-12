package com.lostfound.lostfound.service;

import com.lostfound.lostfound.dto.ClaimDTO;
import com.lostfound.lostfound.model.Claim;
import java.util.List;

public interface ClaimService {

    List<Claim> getAllClaims();

    Claim createClaim(ClaimDTO dto);

    Claim verifyClaim(Long id, String status);

}
