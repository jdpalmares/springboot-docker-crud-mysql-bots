package com.jdpalmares.simplebotcrud.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdpalmares.simplebotcrud.demo.model.AttackBots;
import com.jdpalmares.simplebotcrud.demo.model.Attacks;
import com.jdpalmares.simplebotcrud.demo.model.Bot;
import com.jdpalmares.simplebotcrud.demo.repository.AttackBotsRepository;

@Service
public class AttackBotsService {

    @Autowired
    private AttackBotsRepository attackBotsRepository;

    @Autowired
    private AttacksService attacksService;
    @Autowired
    private BotService botService;

    @Transactional
    public AttackBots createAttackBot(String botId, String attackId) {
        Bot bot = botService.getBotById(Long.parseLong(botId));
        Attacks attacks = attacksService.getAttackById(Long.parseLong(attackId));

        AttackBots attackBots = new AttackBots(bot, attacks);

        return attackBotsRepository.save(attackBots);
    }
}
