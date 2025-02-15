package com.moto.service.controller;

import com.moto.service.entity.Moto;
import com.moto.service.services.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping("/moto")
    public ResponseEntity<List<Moto>> getAll(){
        List<Moto> motos = motoService.getAll();
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }

    @GetMapping("/moto/{id}")
    public ResponseEntity<Moto> getMotoById(@PathVariable Integer id){
        Moto moto = motoService.getMotoById(id);
        if(moto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }

    @PostMapping("/moto")
    public ResponseEntity<Moto> saveMoto(@RequestBody Moto moto){
        return ResponseEntity.ok(motoService.saveMoto(moto));
    }

    @GetMapping("/moto/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> getByUsuario(@PathVariable int usuarioId){
        List<Moto> motosUsuario = motoService.getByUsuario(usuarioId);
        if(motosUsuario.isEmpty()){
            return  ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(motosUsuario);
    }
}
