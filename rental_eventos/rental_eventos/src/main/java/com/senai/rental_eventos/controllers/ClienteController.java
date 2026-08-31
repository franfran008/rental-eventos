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

import com.senai.infoa.dobi.models.Cliente;
import com.senai.infoa.dobi.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService ClienteService;

     @PostMapping("/cadastrar")
    public Cliente salvar(@RequestBody @NonNull Cliente cliente) {
        return clienteService.salvar(cliente);
    }

   @PostMapping("/login")
    public Cliente login(@RequestParam String email, @RequestParam String senha) {
        return clienteService.login(email, senha);
    }

     @PutMapping("/atualizar/{id}")
    public Cliente atualizar(@PathVariable String nome, @RequestBody Cliente cliente) {
        return clienteService.atualizar(cliente, nome);
        
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable @NonNull Integer id) {
    Cliente cliente = clienteService.buscar(id);

    if (cliente != null) {
        var resposta = Map.of(
            "mensagem", "Cliente " + id + " encontrado com sucesso",
            "cliente", cliente
        );
        return ResponseEntity.ok(resposta);
    }

    return ResponseEntity.status(404).body("Falha ao buscar o cliente");
}

     @DeleteMapping("/desativar/{email}")
    public Cliente desativar(@PathVariable String email){

        return clienteService.desativar(email);
    }

   
}