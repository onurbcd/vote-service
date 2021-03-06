package com.onurbcd.vote.api.controller;

import com.onurbcd.vote.dto.AgendaDto;
import com.onurbcd.vote.dto.AgendaResult;
import com.onurbcd.vote.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    private final AgendaService service;

    @Autowired
    public AgendaController(AgendaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AgendaDto> post(@RequestBody AgendaDto agendaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(agendaDto));
    }

    @GetMapping
    public ResponseEntity<Page<AgendaDto>> getAll(@PageableDefault(sort = "id") Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendaResult> result(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(service.getResult(id));
    }
}
