package com.jdpalmares.simplebotcrud.demo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "attacks")
public class Attacks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "site")
    private String site;

    @Column(name = "attack_date")
    private Date attackDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Date getAttackDate() {
        return attackDate;
    }

    public void setAttackDate(Date attackDate) {
        this.attackDate = attackDate;
    }
}
