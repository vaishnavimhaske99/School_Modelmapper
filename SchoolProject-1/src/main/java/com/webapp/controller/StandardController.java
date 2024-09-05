package com.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.webapp.service.StandardService;
import com.webapp.student.StandardDTO;

@RestController
@RequestMapping("/standards")
public class StandardController {

    @Autowired
    private StandardService standardService;

    @GetMapping("/{id}")
    public ResponseEntity<StandardDTO> getStandardById(@PathVariable Long id) {
        StandardDTO standardDTO = standardService.getStandardById(id);
        return ResponseEntity.ok(standardDTO);
    }

    @PostMapping
    public ResponseEntity<StandardDTO> createStandard(@RequestBody StandardDTO standardDTO) {
        StandardDTO createdStandard = standardService.createStandard(standardDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStandard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardDTO> updateStandard(@PathVariable Long id, @RequestBody StandardDTO standardDTO) {
        StandardDTO updatedStandard = standardService.updateStandard(id, standardDTO);
        return ResponseEntity.ok(updatedStandard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStandard(@PathVariable Long id) {
        standardService.deleteStandard(id);
        return ResponseEntity.noContent().build();
    }
}
