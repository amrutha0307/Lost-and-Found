package com.lostfound.lostfound.dto;

public class MatchResponseDto {
    private Long id;
    private Long lostItemId;
    private Long foundItemId;
    private String matchStatus;

    public MatchResponseDto() {
    }

    public MatchResponseDto(Long id, Long lostItemId, Long foundItemId, String matchStatus) {
        this.id = id;
        this.lostItemId = lostItemId;
        this.foundItemId = foundItemId;
        this.matchStatus = matchStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLostItemId() {
        return lostItemId;
    }

    public void setLostItemId(Long lostItemId) {
        this.lostItemId = lostItemId;
    }

    public Long getFoundItemId() {
        return foundItemId;
    }

    public void setFoundItemId(Long foundItemId) {
        this.foundItemId = foundItemId;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }
}
