package com.senai.rental_eventos.repositories;

import com.senai.rental_eventos.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositories extends JpaRepository<Cliente, Integer> {

    @Query(value="select * from cliente where email = :email and senha = :senha", nativeQuery=true)
    public Cliente findByCliente(String email, String senha);

    Cliente findByEmail(String email);
}
