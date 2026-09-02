package com.senai.rental_eventos.controllers;

import java.util.Map;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.rental_eventos.models.Cliente;
import com.senai.rental_eventos.services.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

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

    @DeleteMapping("/delete/{id}")
        public String apagar(@PathVariable @NonNull Integer id) {
            boolean deletou = clienteService.apagar(id);
            if (deletou) {
                return "Equipamento removido com sucesso";
            }
            return "Falha ao remover o equipamento";
        }

   
}