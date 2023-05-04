package com.jdpalmares.simplebotcrud.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attack_bots")
public class AttackBots {

    public AttackBots() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bot_id", nullable = true)
    private Bot bot;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attack_id", nullable = true)
    private Attacks attacks;

    public AttackBots(Bot bot, Attacks attacks) {
        this.bot = bot;
        this.attacks = attacks;
    }

}
