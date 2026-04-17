package com.lostfound.lostfound.controller;

import com.lostfound.lostfound.model.FoundItem;
import com.lostfound.lostfound.service.FoundItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/found-items")
public class FoundItemController {

    @Autowired
    private FoundItemService service;

    // ✅ FIXED: JSON support
    @PostMapping
    public FoundItem saveItem(@RequestBody FoundItem item) {
        return service.saveFoundItem(item);
    }

    // ✅ ADD THIS (needed for matching)
    @GetMapping
    public List<FoundItem> getAllItems() {
        return service.getAllFoundItems();
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        service.deleteFoundItem(id);
    }
}
