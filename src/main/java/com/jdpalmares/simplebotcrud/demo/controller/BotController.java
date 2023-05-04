package com.jdpalmares.simplebotcrud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdpalmares.simplebotcrud.demo.model.Bot;
import com.jdpalmares.simplebotcrud.demo.service.BotService;

@RestController
@RequestMapping("/api/bots")
public class BotController {

    @Autowired
    private BotService botService;

    @GetMapping
    public List<Bot> getAllBots() {
        return botService.getAllBots();
    }

    @GetMapping("/{id}")
    public Bot getBotById(@PathVariable Long id) {
        return botService.getBotById(id);
    }

    @PostMapping
    public Bot createBot(@RequestBody Bot bot) {
        return botService.createBot(bot);
    }

    @PutMapping("/{id}")
    public Bot updateBot(@PathVariable Long id, @RequestBody Bot bot) {
        return botService.updateBot(id, bot);
    }

    @DeleteMapping("/{id}")
    public String deleteBot(@PathVariable Long id) {
        return botService.deleteBot(id);
    }
}
