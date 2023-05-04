package com.jdpalmares.simplebotcrud.demo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdpalmares.simplebotcrud.demo.model.Attacks;
import com.jdpalmares.simplebotcrud.demo.repository.AttackRepository;

@Service
public class AttacksService {

    @Autowired
    private AttackRepository attackRepository;

    public List<Attacks> getAllAttacks() {
        return attackRepository.findAll();
    }

    public List<Attacks> getAttacksByDateRange(String fromDate, String endDate) {
        Date from = Date.valueOf(fromDate);
        Date end = Date.valueOf(endDate);
        return attackRepository.getAttacksByDateRange(from, end);
    }

    public Attacks getAttackById(Long id) {
        return attackRepository.findById(id).get();
    }

    @Transactional
    public Attacks createAttack(Attacks attack) {
        return attackRepository.save(attack);
    }

    @Transactional
    public Attacks updateAttack(Long id, Attacks attacks) {
        Attacks existingBot = getAttackById(id);
        existingBot.setSite(attacks.getSite());
        existingBot.setAttackDate(attacks.getAttackDate());
        return attackRepository.save(existingBot);
    }

    @Transactional
    public String deleteAttack(Long id) {
        try {
            getAttackById(id);
            attackRepository.deleteById(id);
            return "Attack deleted successfully";
        } catch (Exception e) {
            return "Attack not found";
        }
    }
}
