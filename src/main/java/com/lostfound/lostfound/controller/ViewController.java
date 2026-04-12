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
public class ViewController {

    @Autowired
    private LostItemService service;

    @Autowired
    private FoundItemService foundItemService;

    @GetMapping("/")
    public String viewPage(Model model) {
        model.addAttribute("items", service.getAllLostItems());
        model.addAttribute("foundItems", foundItemService.getAllFoundItems());
        return "lost-items";
    }

    // ✅ Save lost item (JSON)
    @PostMapping("/add-item")
    @ResponseBody
    public LostItem addItem(@RequestBody LostItem item) {
        item.setStatus("REPORTED");
        return service.saveLostItem(item);
    }

}