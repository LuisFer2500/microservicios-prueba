package com.usuario.service.feingClients;

import com.usuario.service.models.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "moto-service")
public interface MotoFeignClient {

    @PostMapping("/api/v1/moto")
    public Moto saveMoto(@RequestBody Moto moto);

    @GetMapping("/api/v1/moto/usuario/{usuarioId}")
    public List<Moto> getMotos(@PathVariable("usuarioId") int usuarioId);
}
