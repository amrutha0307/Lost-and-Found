package com.lostfound.lostfound.dto;

public class ClaimResponseDto {

    private Long id;
    private Long matchId;
    private Long userId;
    private String proof;
    private String status;

    public ClaimResponseDto() {}

    public ClaimResponseDto(Long id, Long matchId, Long userId, String proof, String status) {
        this.id = id;
        this.matchId = matchId;
        this.userId = userId;
        this.proof = proof;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getMatchId() { return matchId; }
    public void setMatchId(Long matchId) { this.matchId = matchId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getProof() { return proof; }
    public void setProof(String proof) { this.proof = proof; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}