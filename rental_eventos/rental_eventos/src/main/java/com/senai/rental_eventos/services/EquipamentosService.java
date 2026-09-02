package com.senai.rental_eventos.services;

import com.senai.rental_eventos.models.Equipamentos;
import com.senai.rental_eventos.repositories.EquipamentosRepositories;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EquipamentosService {

    
    @Autowired
    private EquipamentosRepositories equipamentosRepository;

public Equipamentos salvar(@NonNull Equipamentos equipamentos){
    if(equipamentos != null) {}
        return equipamentosRepository.save(equipamentos);
    }

     public Equipamentos buscar(@NonNull Integer id) {
    return equipamentosRepository.findById(id).orElse(null);
}

public List<Equipamentos> listarTodos(){
        return equipamentosRepository.findAll();
    }


 public Equipamentos atualizar(Equipamentos equipamentos, @NonNull Integer id){
    Equipamentos equipamentos2 = equipamentosRepository.findById(id).get();
    if(equipamentos2 != null){
        equipamentos.setId(id);
        return equipamentosRepository.save(equipamentos);
    }
    return null;
}

 public boolean apagar(@NonNull  Integer id) {
        Equipamentos equipamentos = equipamentosRepository.findById(id).get();
        if(equipamentos != null){
            equipamentosRepository.deleteById(id);
            return true;
  
        }

        return false;
}

}
