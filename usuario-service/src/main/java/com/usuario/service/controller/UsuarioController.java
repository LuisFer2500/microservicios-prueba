package com.usuario.service.controller;

import com.usuario.service.entity.Usuario;
import com.usuario.service.models.Carro;
import com.usuario.service.models.Moto;
import com.usuario.service.service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping()
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> usuarios = usuarioServicio.getAll();
        if(usuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable int id){
        Usuario usuario = usuarioServicio.getUsuarioById(id);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping()
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario user){
        Usuario newUsuario =  usuarioServicio.saveUsuario(user);
        if (newUsuario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newUsuario);
    }

    @GetMapping("/carros/{usuarioId}")
    public ResponseEntity<List<Carro>> getCarros(@PathVariable("usuarioId") int usuarioId){
        Usuario usuario = usuarioServicio.getUsuarioById(usuarioId);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }

        List<Carro> carros = usuarioServicio.getCarros(usuarioId);
        if(carros.isEmpty()){
           return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(carros);
    }

    @PostMapping("/carro/usuario/{usuarioId}")
    public ResponseEntity<Carro> saveCarro(@PathVariable("usuarioId") int id, @RequestBody Carro carro){
        Usuario usuario = usuarioServicio.getUsuarioById(id);
        if(usuario == null){
            return  ResponseEntity.notFound().build();
        }

        Carro nuevoCarro = usuarioServicio.saveCarro(id, carro);
        return ResponseEntity.ok(nuevoCarro);
    }

    @GetMapping("/moto/{usuarioId}")
    public ResponseEntity<List<Moto>> getMotos(@PathVariable("usuarioId") int usuarioID){
        Usuario usuario = usuarioServicio.getUsuarioById(usuarioID);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        List<Moto> motos = usuarioServicio.getMoto(usuarioID);
        if (motos.isEmpty()){
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }

    @PostMapping("/moto/usuario/{usuarioId}")
    public ResponseEntity<Moto> saveMoto(@PathVariable("usuarioId") int usuarioId, @RequestBody Moto moto){
        Usuario usuario = usuarioServicio.getUsuarioById(usuarioId);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuarioServicio.saveMoto(usuarioId, moto));
    }

    @GetMapping("/todos/{usuarioId}")
    public ResponseEntity<Map<String, Object>> listarTodosVehiculos(@PathVariable("usuarioId") int usuarioId){
        Map<String,Object> resultado = usuarioServicio.getUsuarioAndVehiculo(usuarioId);
        return ResponseEntity.ok(resultado);

    }



}
