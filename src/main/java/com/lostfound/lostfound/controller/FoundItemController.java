package com.lostfound.lostfound.controller;

import com.lostfound.lostfound.model.FoundItem;
import com.lostfound.lostfound.service.FoundItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // ✅ IMPORTANT
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/found-items")
public class FoundItemController {

    @Autowired
    private FoundItemService service;

    @PostMapping
    public String saveItem(@RequestParam String name,
                           @RequestParam String description,
                           @RequestParam String location) {

        FoundItem item = new FoundItem();
        item.setName(name);
        item.setDescription(description);
        item.setLocation(location);

        service.saveFoundItem(item);

        return "redirect:/"; // ✅ NOW WORKS
    }
}