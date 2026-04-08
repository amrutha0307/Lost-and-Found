package com.lostfound.lostfound.controller;

import com.lostfound.lostfound.model.FoundItem;
import com.lostfound.lostfound.service.FoundItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/found-items")
public class FoundItemController {

    @Autowired
    private FoundItemService service;

    @PostMapping
    public ResponseEntity<FoundItem> saveItem(@RequestBody FoundItem item) {
        FoundItem savedItem = service.saveFoundItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoundItem> getItem(@PathVariable Long id) {
        FoundItem item = service.getFoundItemById(id);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(item);
    }

    @GetMapping
    public List<FoundItem> getAllItems() {
        return service.getAllFoundItems();
    }
}
