package com.carro.service.controller;


import com.carro.service.entity.Carro;
import com.carro.service.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/carro")
    public ResponseEntity<List<Carro>> getAll(){
        List<Carro> carros = carroService.getAll();
        if(carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/carro/{id}")
    public ResponseEntity<Carro> getCarroById(@PathVariable Integer id){
        Carro carro = carroService.getMotoById(id);
        if(carro == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);
    }

    @PostMapping("/carro")
    public ResponseEntity<Carro> saveCarro(@RequestBody Carro carro){
        return ResponseEntity.ok(carroService.saveMoto(carro));
    }

    @GetMapping("/carro/usuario/{usuarioId}")
    public ResponseEntity<List<Carro>> getByUsuario(@PathVariable int usuarioId){
        List<Carro> carrosUsuario = carroService.getByUsuario(usuarioId);
        if(carrosUsuario.isEmpty()){
            return  ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(carrosUsuario);
    }
}
