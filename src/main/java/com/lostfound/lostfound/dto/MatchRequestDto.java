package com.lostfound.lostfound.dto;

public class MatchRequestDto {
    private Long lostItemId;
    private Long foundItemId;

    public MatchRequestDto() {
    }

    public MatchRequestDto(Long lostItemId, Long foundItemId) {
        this.lostItemId = lostItemId;
        this.foundItemId = foundItemId;
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
}
