package com.gabriel.licona.valdez.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.licona.valdez.demo.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {

}
