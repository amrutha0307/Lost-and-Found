package com.lostfound.lostfound.service;

import com.lostfound.lostfound.model.LostItem;
import java.util.List;

public interface LostItemService {

    LostItem saveLostItem(LostItem lostItem);

    LostItem getLostItemById(Long id);

    List<LostItem> getAllLostItems();

    void deleteLostItem(Long id);
}
