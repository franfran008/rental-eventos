package com.senai.rental_eventos.controllers;

import com.senai.rental_eventos.models.Aluguel;
import com.senai.rental_eventos.services.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

       @Autowired
    private AluguelService aluguelService;

     @PostMapping("/cadastrar")
    public Aluguel salvar(@RequestBody @NonNull Aluguel aluguel) {
        return aluguelService.salvar(aluguel);
    }


     @PutMapping("/atualizar/{id}")
    public Aluguel atualizar(@PathVariable @NonNull Integer id, @RequestBody Aluguel aluguel) {
        return aluguelService.atualizar(aluguel, id);
        
    }

    @GetMapping("/listar")
    public List<Aluguel> listarTodos() {
        return aluguelService.listarTodos();
    }


    @DeleteMapping("/delete/{id}")
    public String apagar(@PathVariable @NonNull Integer id) {
        boolean deletou = aluguelService.apagar(id);
        if (deletou) {
            return "Aluguel removida com sucesso";
        }
        return "Falha ao remover o aluguel";
    }
}
