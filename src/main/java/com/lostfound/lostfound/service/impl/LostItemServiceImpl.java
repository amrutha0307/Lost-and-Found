package com.lostfound.lostfound.service.impl;

import com.lostfound.lostfound.model.LostItem;
import com.lostfound.lostfound.repository.LostItemRepository;
import com.lostfound.lostfound.service.LostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostItemServiceImpl implements LostItemService {

    @Autowired
    private LostItemRepository repository;

    private String reportedBy;
    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    @Override
    public LostItem saveLostItem(LostItem lostItem) {
        lostItem.setStatus("REPORTED");
        return repository.save(lostItem);
    }

    @Override
    public LostItem getLostItemById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<LostItem> getAllLostItems() {
        return repository.findAll();
    }

    @Override
    public void deleteLostItem(Long id) {
        repository.deleteById(id);
    }
}
