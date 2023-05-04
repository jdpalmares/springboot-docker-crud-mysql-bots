package com.jdpalmares.simplebotcrud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdpalmares.simplebotcrud.demo.model.AttackBots;

@Repository
public interface AttackBotsRepository extends JpaRepository<AttackBots, Long> {

}
