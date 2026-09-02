package com.senai.rental_eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.rental_eventos.models.Equipamentos;

@Repository
public interface EquipamentosRepositories extends JpaRepository<Equipamentos, Integer> {

}
