package com.lostfound.lostfound.controller;

import com.lostfound.lostfound.model.LostItem;
import com.lostfound.lostfound.service.LostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    @Autowired
    private LostItemService service;

    @GetMapping("/")
    public String viewPage(Model model) {
        model.addAttribute("items", service.getAllLostItems());
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
        item.setStatus("REPORTED"); // ✅ ensure status is set

        service.saveLostItem(item);

        return "redirect:/";
    }
}