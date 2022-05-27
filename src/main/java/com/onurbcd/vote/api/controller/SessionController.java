package com.onurbcd.vote.api.controller;

import com.onurbcd.vote.dto.SessionDto;
import com.onurbcd.vote.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
