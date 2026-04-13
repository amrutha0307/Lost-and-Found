package com.lostfound.lostfound.service;

import com.lostfound.lostfound.model.FoundItem;

import java.util.List;

public interface FoundItemService {

    FoundItem saveFoundItem(FoundItem item);

    FoundItem getFoundItemById(Long id);

    List<FoundItem> getAllFoundItems();
}
