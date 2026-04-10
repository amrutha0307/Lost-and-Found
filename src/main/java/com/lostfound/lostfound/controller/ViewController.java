package com.lostfound.lostfound.controller;

import com.lostfound.lostfound.model.LostItem;
import com.lostfound.lostfound.service.LostItemService;
import com.lostfound.lostfound.service.FoundItemService; // ✅ MISSING IMPORT

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add-item")
    public String addItem(@RequestParam String name,
                          @RequestParam String description,
                          @RequestParam String location,
                          @RequestParam String reportedBy) {

        LostItem item = new LostItem();
        item.setName(name);
        item.setDescription(description);
        item.setLocation(location);
        item.setReportedBy(reportedBy);
        item.setStatus("REPORTED");

        service.saveLostItem(item);

        return "redirect:/";
    }
}