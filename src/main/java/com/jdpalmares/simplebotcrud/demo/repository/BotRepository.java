package com.jdpalmares.simplebotcrud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdpalmares.simplebotcrud.demo.model.Bot;

@Repository
public interface BotRepository extends JpaRepository<Bot, Long> {

}
