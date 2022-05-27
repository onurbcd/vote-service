package com.onurbcd.vote.api.controller;

import com.onurbcd.vote.dto.AssociateDto;
import com.onurbcd.vote.service.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/associate")
public class AssociateController {

    private final AssociateService service;

    @Autowired
    public AssociateController(AssociateService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AssociateDto> post(@RequestBody AssociateDto associateDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(associateDto));
    }

    @GetMapping
    public ResponseEntity<Page<AssociateDto>> getAll(@PageableDefault(sort = "id") Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }
}
