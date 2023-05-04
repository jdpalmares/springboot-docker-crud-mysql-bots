package com.jdpalmares.simplebotcrud.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdpalmares.simplebotcrud.demo.model.Bot;
import com.jdpalmares.simplebotcrud.demo.repository.BotRepository;

@Service
public class BotService {

    @Autowired
    private BotRepository botRepository;

    public List<Bot> getAllBots() {
        return botRepository.findAll();
    }

    public Bot getBotById(Long id) {
        return botRepository.findById(id).get();
    }

    @Transactional
    public Bot createBot(Bot bot) {
        return botRepository.save(bot);
    }

    @Transactional
    public Bot updateBot(Long id, Bot bot) {
        Bot existingBot = getBotById(id);
        existingBot.setName(bot.getName());
        return botRepository.save(existingBot);
    }

    @Transactional
    public String deleteBot(Long id) {
        try {
            getBotById(id);
            botRepository.deleteById(id);
            return "Bot deleted successfully";
        } catch (Exception e) {
            return "Bot not found";
        }
    }
}
