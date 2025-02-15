package com.moto.service.services;

import com.moto.service.entity.Moto;
import com.moto.service.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    public List<Moto> getAll(){
        return motoRepository.findAll();
    }

    public Moto getMotoById(int id){
        return motoRepository.findById(id).orElse(null);
    }

    public Moto saveMoto(Moto moto){
        Moto newMoto = motoRepository.save(moto);

        return newMoto;
    }

    public List<Moto> getByUsuario(int usuarioId){
        return motoRepository.findByUsuarioId(usuarioId);
    }

}
