package com.senai.rental_eventos.services;

import com.senai.rental_eventos.models.Usuario;
import com.senai.rental_eventos.repositories.UsuarioRepositories;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
    @Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepositories usuarioRepository;

public Usuario salvar(@NonNull Usuario usuario){
    if(usuario != null) {}
        return usuarioRepository.save(usuario);
    }

     public Usuario buscar(@NonNull Integer id) {
    return usuarioRepository.findById(id).orElse(null);
}

     public Usuario login(String email, String senha){
        Usuario usuario = usuarioRepository.findByUsuario(email, senha);
        if(usuario != null && senha.equals(usuario.getSenha())){
            return usuario;
        }
        return null;
    }

    public Usuario atualizar(Usuario usuario, @NonNull Integer id){
        Usuario usuario2 = usuarioRepository.findById(id).get();
        if(usuario2 != null){
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

 public boolean apagar(@NonNull  Integer id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        if(usuario != null){
            usuarioRepository.deleteById(id);
            return true;
  
        }

        return false;
}

}
