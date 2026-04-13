package com.lostfound.lostfound.service;

import com.lostfound.lostfound.model.LostItem;
import java.util.List;

public interface LostItemService {

    LostItem saveLostItem(LostItem lostItem);

    List<LostItem> getAllLostItems();
}