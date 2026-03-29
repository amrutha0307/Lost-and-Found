package com.lostfound.lostfound.repository;

import com.lostfound.lostfound.model.LostItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LostItemRepository extends JpaRepository<LostItem, Long> {
}