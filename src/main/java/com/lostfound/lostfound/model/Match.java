package com.lostfound.lostfound.model;

import jakarta.persistence.*;

@Entity
@Table(name = "item_matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long lostItemId;
    private Long foundItemId;

    // ✅ KEEP CONSISTENT NAME
    private String status;

    public Match() {}

    public Match(Long lostItemId, Long foundItemId, String status) {
        this.lostItemId = lostItemId;
        this.foundItemId = foundItemId;
        this.status = status;
    }

    public Long getId() {
        return id;
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

    // ✅ FIXED GETTER
    public String getStatus() {
        return status;
    }

    // ✅ FIXED SETTER
    public void setStatus(String status) {
        this.status = status;
    }
}