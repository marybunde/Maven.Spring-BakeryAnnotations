package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.services.MuffinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/muffins")
public class MuffinController {
    private MuffinService service;

    public MuffinController(MuffinService service) {
        this.service = service;
    }

    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Muffin> show(Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Muffin> create(Muffin baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Muffin> update(Long id, Muffin baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
