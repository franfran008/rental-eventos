package com.senai.rental_eventos.services;

import com.senai.rental_eventos.models.Cliente;
import com.senai.rental_eventos.repositories.ClienteRepositories;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepositories clienteRepository;

public Cliente salvar(@NonNull Cliente cliente){
    if(cliente != null) {}
        return clienteRepository.save(cliente);
    }

     public Cliente buscar(@NonNull Integer id) {
    return clienteRepository.findById(id).orElse(null);
}

     public Cliente login(String email, String senha){
        Cliente cliente = clienteRepository.findByCliente(email, senha);
        if(cliente != null && senha.equals(cliente.getSenha())){
            return cliente;
        }
        return null;
    }

    public Cliente atualizar(Cliente cliente, String email){
    Cliente cliente2 = clienteRepository.findByEmail(email);
    if(cliente2 != null){
        cliente.setNome(cliente.getNome());
        cliente.setSenha(cliente.getSenha());
        return clienteRepository.save(cliente);
    }
    return null;
}

 public boolean apagar(@NonNull  Integer id) {
        Cliente cliente = clienteRepository.findById(id).get();
        if(cliente != null){
            clienteRepository.deleteById(id);
            return true;
  
        }

        return false;
}
}
