package com.senai.rental_eventos.controllers;

import com.senai.rental_eventos.models.Equipamentos;
import com.senai.rental_eventos.services.EquipamentosService;

import java.util.List;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentosController {

       @Autowired
    private EquipamentosService equipamentosService;

     @PostMapping("/cadastrar")
    public Equipamentos salvar(@RequestBody @NonNull Equipamentos equipamentos) {
        return equipamentosService.salvar(equipamentos);
    }


     @PutMapping("/atualizar/{id}")
    public Equipamentos atualizar(@PathVariable @NonNull Integer id, @RequestBody Equipamentos equipamentos) {
        return equipamentosService.atualizar(equipamentos, id);
        
    }

    @GetMapping("/listar")
    public List<Equipamentos> listarTodos() {
        return equipamentosService.listarTodos();
    }


    @DeleteMapping("/delete/{id}")
    public String apagar(@PathVariable @NonNull Integer id) {
        boolean deletou = equipamentosService.apagar(id);
        if (deletou) {
            return "Equipamento removido com sucesso";
        }
        return "Falha ao remover o equipamento";
    }
}