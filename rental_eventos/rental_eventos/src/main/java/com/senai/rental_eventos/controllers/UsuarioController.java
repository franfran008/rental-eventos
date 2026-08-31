package com.senai.rental_eventos.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.dobi.models.Usuario;
import com.senai.infoa.dobi.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

     @PostMapping("/cadastrar")
    public Usuario salvar(@RequestBody @NonNull Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

   @PostMapping("/login")
    public Usuario login(@RequestParam String email, @RequestParam String senha) {
        return usuarioService.login(email, senha);
    }

     @PutMapping("/atualizar/{id}")
    public Usuario atualizar(@PathVariable String nome, @RequestBody Usuario usuario) {
        return usuarioService.atualizar(usuario, nome);
        
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable @NonNull Integer id) {
    Usuario usuario = usuarioService.buscar(id);

    if (usuario != null) {
        var resposta = Map.of(
            "mensagem", "Usuario " + id + " encontrado com sucesso",
            "usuario", usuario
        );
        return ResponseEntity.ok(resposta);
    }

    return ResponseEntity.status(404).body("Falha ao buscar o usuario");
}

     @DeleteMapping("/desativar/{email}")
    public Usuario desativar(@PathVariable String email){

        return usuarioService.desativar(email);
    }

   
}