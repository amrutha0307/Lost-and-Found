package com.lostfound.lostfound.controller;

import com.lostfound.lostfound.model.LostItem;
import com.lostfound.lostfound.service.LostItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    @Autowired
    private LostItemService service;

    // ✅ ONLY API — NO PAGE MAPPING
    @PostMapping("/add-item")
    @ResponseBody
    public LostItem addItem(@RequestBody LostItem item) {
        item.setStatus("REPORTED");
        return service.saveLostItem(item);
    }
}