package com.entrega088.TarefaMediaSpring.Controller;

import com.entrega088.TarefaMediaSpring.Entity.ValorEntity;
import com.entrega088.TarefaMediaSpring.Service.ValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculos")
public class ValorController {

    private final ValorService valorService;

    @Autowired
    public ValorController(ValorService valorService) {
        this.valorService = valorService;
    }

    @PostMapping("/media")
    public ResponseEntity<?> calcularMedia(@RequestBody ValorEntity input) {
        try {
            ValorEntity resultado = valorService.calcularMedia(input);
            return ResponseEntity.ok(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("{\"erro\": \"Valor inserido de forma incorreta\"}");
        }
    }

    @PostMapping("/mediana")
    public ResponseEntity<?> calcularMediana(@RequestBody ValorEntity input) {
        try {
            ValorEntity resultado = valorService.calcularMediana(input);
            return ResponseEntity.ok(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("{\"erro\": \"Valor inserido de forma incorreta\"}");        }
    }

    @PostMapping("/desvio")
    public ResponseEntity<?> calcularDesvioPadrao(@RequestBody ValorEntity input) {
        try {
            ValorEntity resultado = valorService.calcularDesvioPadrao(input);
            return ResponseEntity.ok(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("{\"erro\": \"Valor inserido de forma incorreta\"}");        }
    }

    @PostMapping("/todos")
    public ResponseEntity<?> calcularTodos(@RequestBody ValorEntity input) {
        try {
            ValorEntity resultado = valorService.calcularValor(input);
            return ResponseEntity.ok(resultado);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("{\"erro\": \"Valor inserido de forma incorreta\"}");        }
    }
}
