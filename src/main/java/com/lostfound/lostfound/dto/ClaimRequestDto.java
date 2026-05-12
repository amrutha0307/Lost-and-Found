package com.lostfound.lostfound.dto;

public class ClaimRequestDto {

    private Long matchId;
    private Long userId;
    private String proof;

    public ClaimRequestDto() {}

    public ClaimRequestDto(Long matchId, Long userId, String proof) {
        this.matchId = matchId;
        this.userId = userId;
        this.proof = proof;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }
}