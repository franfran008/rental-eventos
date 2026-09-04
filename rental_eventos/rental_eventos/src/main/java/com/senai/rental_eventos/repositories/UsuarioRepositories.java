package com.senai.rental_eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.senai.rental_eventos.models.Usuario;

@Repository
public interface UsuarioRepositories extends JpaRepository<Usuario, Integer> {

    @Query(value="select * from usuario where email = :email and senha = :senha", nativeQuery=true)
    public Usuario findByUsuario(String email, String senha);

    Optional<Usuario> findByEmail(String email);
}
