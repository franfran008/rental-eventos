package com.senai.rental_eventos.repositories;

import com.senai.rental_eventos.entities.Equipamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentosRepositories extends JpaRepository<Equipamentos, Integer> {

}
