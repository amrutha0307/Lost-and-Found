package com.lostfound.lostfound.controller;

import com.lostfound.lostfound.model.LostItem;
import com.lostfound.lostfound.service.LostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lost-items")
public class LostItemController {

    @Autowired
    private LostItemService service;

    @PostMapping
    public LostItem reportLostItem(@RequestBody LostItem lostItem) {
        return service.saveLostItem(lostItem);
    }

    @GetMapping
    public List<LostItem> getAllLostItems() {
        return service.getAllLostItems();
    }
}