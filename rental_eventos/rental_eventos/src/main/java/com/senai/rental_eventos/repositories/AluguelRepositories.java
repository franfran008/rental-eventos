package com.senai.rental_eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.rental_eventos.models.Aluguel;

@Repository
public interface AluguelRepositories extends JpaRepository<Aluguel, Integer> {

    

}
