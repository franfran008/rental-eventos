package com.senai.rental_eventos.services;

import com.senai.rental_eventos.models.Aluguel;
import com.senai.rental_eventos.repositories.AluguelRepositories;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AluguelService {

    
    @Autowired
    private AluguelRepositories aluguelRepository;

public Aluguel salvar(@NonNull Aluguel aluguel){
    if(aluguel != null) {}
        return aluguelRepository.save(aluguel);
    }

     public Aluguel buscar(@NonNull Integer id) {
    return aluguelRepository.findById(id).orElse(null);
}

public List<Aluguel> listarTodos(){
        return aluguelRepository.findAll();
    }


 public Aluguel atualizar(Aluguel aluguel, @NonNull Integer id){
    Aluguel aluguel2 = aluguelRepository.findById(id).get();
    if(aluguel2 != null){
        aluguel.setId(id);
        return aluguelRepository.save(aluguel);
    }
    return null;
}

 public boolean apagar(@NonNull  Integer id) {
        Aluguel aluguel = aluguelRepository.findById(id).get();
        if(aluguel != null){
            aluguelRepository.deleteById(id);
            return true;
  
        }

        return false;
}

}
