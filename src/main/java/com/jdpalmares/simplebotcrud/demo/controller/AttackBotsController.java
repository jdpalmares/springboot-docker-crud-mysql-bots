package com.jdpalmares.simplebotcrud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdpalmares.simplebotcrud.demo.model.AttackBots;
import com.jdpalmares.simplebotcrud.demo.service.AttackBotsService;

@RestController
@RequestMapping("/api/attackbots")
public class AttackBotsController {

    @Autowired
    private AttackBotsService attacksBotsService;

    @PostMapping
    public AttackBots createAttackBot(
            @RequestParam("botid") String botId,
            @RequestParam("attackid") String attackId) {
        if (botId.isBlank() || attackId.isBlank()) {
            throw new WebServerException("Bad Rquest. From or To date is empty", new NullPointerException());
        }

        return attacksBotsService.createAttackBot(botId, attackId);
    }

}
