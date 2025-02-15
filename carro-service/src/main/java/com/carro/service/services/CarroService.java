package com.carro.service.services;

import com.carro.service.entity.Carro;
import com.carro.service.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;


    public List<Carro> getAll(){
        return carroRepository.findAll();
    }

    public Carro getMotoById(int id){
        return carroRepository.findById(id).orElse(null);
    }

    public Carro saveMoto(Carro carro){
        Carro newCarro = carroRepository.save(carro);

        return newCarro;
    }

    public List<Carro> getByUsuario(int usuarioId){
        return carroRepository.findAllByUsuarioId(usuarioId);
    }

}
