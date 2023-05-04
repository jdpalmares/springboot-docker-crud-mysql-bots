package com.jdpalmares.simplebotcrud.demo.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attack_bots")
public class AttackBots {

    @EmbeddedId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bot_id", nullable = true)
    private Bot bot;

    @EmbeddedId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attack_id", nullable = true)
    private Attacks attacks;

}
