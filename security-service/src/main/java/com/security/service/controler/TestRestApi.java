package com.security.service.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/security")
public class TestRestApi {

    @GetMapping
    public Map<String, Object> dataTest(){
        return Map.of("message", "Data Test");
    }
}
