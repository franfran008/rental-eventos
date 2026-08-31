package com.senai.rental_eventos.repositories;

import com.senai.rental_eventos.entities.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepositories extends JpaRepository<Aluguel, Integer> {

    

}
