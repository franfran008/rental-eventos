package com.senai.rental_eventos.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.senai.rental_eventos.models.Usuario;
import com.senai.rental_eventos.repositories.UsuarioRepositories;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepositories usuarioRepository;

    public CustomUserDetailsService(UsuarioRepositories usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByEmail(email)
            .orElseThrow(() ->
                new UsernameNotFoundException("Usuário não encontrado")
            );

        return User
            .withUsername(usuario.getEmail())
            .password(usuario.getSenha())
            .roles("USER")
            .build();
    }
}