package com.onurbcd.vote.api.controller;

import com.onurbcd.vote.dto.VoteDto;
import com.onurbcd.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vote")
public class VoteController {

    private final VoteService service;

    @Autowired
    public VoteController(VoteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<VoteDto> post(@RequestBody VoteDto voteDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(voteDto));
    }
}
