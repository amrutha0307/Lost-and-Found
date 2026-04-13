package com.lostfound.lostfound.service.impl;

import com.lostfound.lostfound.model.FoundItem;
import com.lostfound.lostfound.repository.FoundItemRepository;
import com.lostfound.lostfound.service.FoundItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoundItemServiceImpl implements FoundItemService {

    @Autowired
    private FoundItemRepository repository;

    @Override
    public FoundItem saveFoundItem(FoundItem item) {
        return repository.save(item);
    }

    @Override
    public FoundItem getFoundItemById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<FoundItem> getAllFoundItems() {
        return repository.findAll();
    }
}
