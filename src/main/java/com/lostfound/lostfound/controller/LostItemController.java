package com.lostfound.lostfound.controller;

import com.lostfound.lostfound.model.LostItem;
import com.lostfound.lostfound.service.LostItemService;
import com.lostfound.lostfound.service.FoundItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LostItemController {

    @Autowired
    private LostItemService service;

    @Autowired
    private FoundItemService foundItemService;

    // ✅ MAIN PAGE (SPA ENTRY)
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", service.getAllLostItems());
        model.addAttribute("foundItems", foundItemService.getAllFoundItems());
        return "lost-items"; // your big HTML file
    }

    // ✅ API: CREATE LOST ITEM
    @PostMapping("/lost-items")
    @ResponseBody
    public LostItem reportLostItem(@RequestBody LostItem lostItem) {
        return service.saveLostItem(lostItem);
    }

    // ✅ API: GET ALL LOST ITEMS (for JS matching)
    @GetMapping("/lost-items")
    @ResponseBody
    public List<LostItem> getAllLostItems() {
        return service.getAllLostItems();
    }

    @DeleteMapping("/lost-items/{id}")
    @ResponseBody
    public void deleteLostItem(@PathVariable Long id) {
        service.deleteLostItem(id);
    }
}
