package com.entrega088.TarefaMediaSpring.Service;

import com.entrega088.TarefaMediaSpring.Entity.ValorEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

@Service
public class ValorService {


    public ValorEntity calcularMedia(ValorEntity input) {
        List<BigDecimal> valores = input.getListaValores();
        BigDecimal soma = valores.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal media = soma.divide(BigDecimal.valueOf(valores.size()), RoundingMode.HALF_UP);
        input.setMedia(media);
        input.setQuantidade(valores.size());
        return input;
    }

    public ValorEntity calcularMediana(ValorEntity input) {
        List<BigDecimal> valores = input.getListaValores();
        Collections.sort(valores);
        BigDecimal mediana;
        if (valores.size() % 2 == 0) {
            int middle = valores.size() / 2;
            mediana = valores.get(middle - 1).add(valores.get(middle)).divide(BigDecimal.valueOf(2));
        } else {
            mediana = valores.get(valores.size() / 2);
        }
        input.setMediana(mediana);
        input.setQuantidade(valores.size());
        return input;
    }

    public ValorEntity calcularDesvioPadrao(ValorEntity input) {
        List<BigDecimal> valores = input.getListaValores();
        BigDecimal media = calcularMedia(input).getMedia();
        BigDecimal somaDosQuadrados = valores.stream()
                .map(valor -> valor.subtract(media).pow(2))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal desvio = BigDecimal.valueOf(Math.sqrt(somaDosQuadrados.divide(BigDecimal.valueOf(valores.size()), RoundingMode.HALF_UP).doubleValue()));
        input.setDesvio(desvio);
        input.setQuantidade(valores.size());
        return input;
    }

    public ValorEntity calcularValorMinimo(ValorEntity input) {
        List<BigDecimal> valores = input.getListaValores();

        if (valores.isEmpty()) {
            throw new IllegalArgumentException("Lista de valores está vazia");
        }

        BigDecimal valorMinimo = Collections.min(valores);
        input.setValorMinimo(valorMinimo);

        return input;
    }

    public ValorEntity calcularValorMaximo(ValorEntity input) {
        List<BigDecimal> valores = input.getListaValores();

        if (valores.isEmpty()) {
            throw new IllegalArgumentException("Lista de valores está vazia");
        }

        BigDecimal valorMaximo = Collections.max(valores);
        input.setValorMaximo(valorMaximo);

        return input;
    }

    public ValorEntity calcularSomaValores(ValorEntity input) {
        List<BigDecimal> valores = input.getListaValores();
        BigDecimal soma = valores.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        input.setSomaValores(soma);

        return input;
    }

    public ValorEntity calcularValor(ValorEntity input) {
        List<BigDecimal> valores = input.getListaValores();
        calcularMedia(input);
        calcularMediana(input);
        calcularDesvioPadrao(input);
        calcularValorMinimo(input);
        calcularValorMaximo(input);
        calcularSomaValores(input);

        if (valores == null || valores.isEmpty()) {
            throw new IllegalArgumentException("Valor inserido de forma incorreta");
        }

        return input;
    }
}