package com.senai.rental_eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senai.rental_eventos.models.Usuario;

@Repository
public interface UsuarioRepositories extends JpaRepository<Usuario, Integer> {

    @Query(value="select * from usuario where cpf = :cpf and senha = :senha", nativeQuery=true)
    public Usuario findByUsuario(String cpf, String senha);

    Usuario findBycpf(String cpf);
}
