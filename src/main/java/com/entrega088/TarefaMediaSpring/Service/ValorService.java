package com.entrega088.TarefaMediaSpring.Service;

import com.entrega088.TarefaMediaSpring.Entity.ValorEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

@Service
public class ValorService {

    public ValorEntity CalculoValor(ValorEntity input) {
        List<BigDecimal> valores = input.getListaValores();

        // Calcular a média
        BigDecimal soma = valores.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal media = soma.divide(BigDecimal.valueOf(valores.size()), RoundingMode.HALF_UP);

        // Calcular a mediana
        Collections.sort(valores);
        BigDecimal mediana;
        if (valores.size() % 2 == 0) {
            int middle = valores.size() / 2;
            mediana = valores.get(middle - 1).add(valores.get(middle)).divide(BigDecimal.valueOf(2));
        } else {
            mediana = valores.get(valores.size() / 2);
        }

        // Calcular o desvio padrão
        BigDecimal somaDosQuadrados = valores.stream()
                .map(valor -> valor.subtract(media).pow(2))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal desvio = BigDecimal.valueOf(Math.sqrt(somaDosQuadrados.divide(BigDecimal.valueOf(valores.size()), RoundingMode.HALF_UP).doubleValue()));

        // Atualizar os valores na entidade de saída
        input.setMedia(media);
        input.setMediana(mediana);
        input.setDesvio(desvio);
        input.setQuantidade(valores.size());

        return input;
    }
}
