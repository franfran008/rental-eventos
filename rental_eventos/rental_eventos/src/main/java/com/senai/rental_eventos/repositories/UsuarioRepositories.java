package com.senai.rental_eventos.repositories;

import com.senai.rental_eventos.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositories extends JpaRepository<Usuario, Integer> {

    @Query(value="select * from usuario where email = :email and senha = :senha", nativeQuery=true)
    public Usuario findByUsuario(String email, String senha);

    Usuario findByEmail(String email);
}
