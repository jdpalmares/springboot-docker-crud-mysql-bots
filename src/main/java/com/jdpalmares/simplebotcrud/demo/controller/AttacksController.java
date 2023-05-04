package com.jdpalmares.simplebotcrud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdpalmares.simplebotcrud.demo.model.Attacks;
import com.jdpalmares.simplebotcrud.demo.service.AttacksService;

@RestController
@RequestMapping("/api/attacks")
public class AttacksController {

    @Autowired
    private AttacksService attacksService;

    @GetMapping
    public List<Attacks> getAllAttacks() {
        return attacksService.getAllAttacks();
    }

    @GetMapping("/dates")
    public List<Attacks> getAttacksByDateRange(
            @RequestParam("from") String fromDate,
            @RequestParam("to") String endDate) {
        if (fromDate == null || fromDate.isBlank() || endDate == null || endDate.isBlank()) {
            throw new WebServerException("Bad Rquest. From or To date is missing or empty", new NullPointerException());
        }

        return attacksService.getAttacksByDateRange(fromDate, endDate);
    }

    @GetMapping("/{id}")
    public Attacks getAttackById(@PathVariable Long id) {
        return attacksService.getAttackById(id);
    }

    @PostMapping
    public Attacks createAttack(@RequestBody Attacks attack) {
        return attacksService.createAttack(attack);
    }

    @PutMapping("/{id}")
    public Attacks updateAttack(@PathVariable Long id, @RequestBody Attacks attack) {
        return attacksService.updateAttack(id, attack);
    }

    @DeleteMapping("/{id}")
    public String deleteAttack(@PathVariable Long id) {
        return attacksService.deleteAttack(id);
    }
}
