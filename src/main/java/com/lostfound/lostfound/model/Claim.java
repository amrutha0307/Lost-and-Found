package com.lostfound.lostfound.model;

import jakarta.persistence.*;

@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long matchId;
    private Long userId;
    private String proof;
    private String status;

    public Long getId() { return id; }

    public Long getMatchId() { return matchId; }
    public void setMatchId(Long matchId) { this.matchId = matchId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getProof() { return proof; }
    public void setProof(String proof) { this.proof = proof; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}