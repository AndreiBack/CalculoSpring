package com.entrega088.TarefaMediaSpring.Controller;

import com.entrega088.TarefaMediaSpring.Entity.ValorEntity;
import com.entrega088.TarefaMediaSpring.Service.ValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "/api")
public class ValorController {

    private final ValorService valorService;

    @Autowired
    public ValorController(ValorService valorService) {
        this.valorService = valorService;
    }

    @PostMapping("/Calculo")
    public ResponseEntity<ValorEntity> calcularMediaMedianaDesvio(@RequestBody ValorEntity input) {
        ValorEntity resultado = valorService.CalculoValor(input);
        return ResponseEntity.ok(resultado);
    }
}