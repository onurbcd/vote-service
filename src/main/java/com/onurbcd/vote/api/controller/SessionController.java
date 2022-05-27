package com.onurbcd.vote.api.controller;

import com.onurbcd.vote.dto.SessionDto;
import com.onurbcd.vote.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessionController {

    private final SessionService service;

    @Autowired
    public SessionController(SessionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SessionDto> post(@RequestBody SessionDto sessionDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(sessionDto));
    }

    @GetMapping
    public ResponseEntity<Page<SessionDto>> getAll(@PageableDefault(sort = "id") Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }
}
