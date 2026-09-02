package com.senai.rental_eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senai.rental_eventos.models.Cliente;

@Repository
public interface ClienteRepositories extends JpaRepository<Cliente, Integer> {

    @Query(value="select * from cliente where email = :email and senha = :senha", nativeQuery=true)
    public Cliente findByCliente(String email, String senha);

    Cliente findByEmail(String email);
}
