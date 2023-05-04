package com.jdpalmares.simplebotcrud.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "attack_bots")
public class AttackBots {

    @Id
    @Column(name = "bot_id")
    private Long botId;

    @Id
    @Column(name = "attack_id")
    private Long attackId;

    public Long getBotId() {
        return botId;
    }

    public void setBotId(Long botId) {
        this.botId = botId;
    }

    public Long getAttackId() {
        return attackId;
    }

    public void setAttackId(Long attackId) {
        this.attackId = attackId;
    }

}
