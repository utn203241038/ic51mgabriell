package com.gabriel.licona.valdez.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import com.gabriel.licona.valdez.demo.model.Categoria;


public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

	
}
