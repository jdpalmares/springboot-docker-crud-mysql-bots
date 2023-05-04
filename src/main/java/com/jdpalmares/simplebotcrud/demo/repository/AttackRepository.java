package com.jdpalmares.simplebotcrud.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jdpalmares.simplebotcrud.demo.model.Attacks;

@Repository
public interface AttackRepository extends JpaRepository<Attacks, Long> {

    @Query(value = "SELECT * from attacks t where attack_date BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<Attacks> getAttacksByDateRange(@Param("startDate") Date fromDate, @Param("endDate") Date endDate);
}
