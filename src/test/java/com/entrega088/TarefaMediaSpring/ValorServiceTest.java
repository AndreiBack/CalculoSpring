package com.entrega088.TarefaMediaSpring;

import com.entrega088.TarefaMediaSpring.Entity.ValorEntity;
import com.entrega088.TarefaMediaSpring.Service.ValorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValorServiceTest {

    private ValorService valorService;

    @BeforeEach
    public void setup() {
        valorService = new ValorService();
    }

    @Test
    public void testCalcularMedia() {
        List<BigDecimal> valores = Arrays.asList(BigDecimal.valueOf(10), BigDecimal.valueOf(20), BigDecimal.valueOf(30));
        ValorEntity input = new ValorEntity();
        input.setListaValores(valores);

        ValorEntity result = valorService.calcularMedia(input);

        assertEquals(BigDecimal.valueOf(20), result.getMedia());
        assertEquals(valores.size(), result.getQuantidade());
    }

    @Test
    public void testCalcularMediana() {
        List<BigDecimal> valores = Arrays.asList(BigDecimal.valueOf(10), BigDecimal.valueOf(20), BigDecimal.valueOf(30));
        ValorEntity input = new ValorEntity();
        input.setListaValores(valores);

        ValorEntity result = valorService.calcularMediana(input);

        assertEquals(BigDecimal.valueOf(20), result.getMediana());
        assertEquals(valores.size(), result.getQuantidade());
    }

    @Test
    public void testCalcularDesvioPadrao() {
        List<BigDecimal> valores = Arrays.asList(BigDecimal.valueOf(10), BigDecimal.valueOf(20), BigDecimal.valueOf(30));
        ValorEntity input = new ValorEntity();
        input.setListaValores(valores);

        ValorEntity result = valorService.calcularDesvioPadrao(input);

        assertEquals(BigDecimal.valueOf(8.18535277187245), result.getDesvio());
        assertEquals(valores.size(), result.getQuantidade());
    }

    @Test
    public void testCalcularValor() {
        List<BigDecimal> valores = Arrays.asList(BigDecimal.valueOf(10), BigDecimal.valueOf(20), BigDecimal.valueOf(30));
        ValorEntity input = new ValorEntity();
        input.setListaValores(valores);

        ValorEntity result = valorService.calcularValor(input);

        assertEquals(BigDecimal.valueOf(20), result.getMedia());
        assertEquals(BigDecimal.valueOf(20), result.getMediana());
        assertEquals(BigDecimal.valueOf(8.18535277187245), result.getDesvio());
        assertEquals(valores.size(), result.getQuantidade());

    }
    @Test
    public void testCalcularValorMinimo() {
        List<BigDecimal> valores = Arrays.asList(BigDecimal.valueOf(10), BigDecimal.valueOf(20), BigDecimal.valueOf(5));
        ValorEntity input = new ValorEntity();
        input.setListaValores(valores);

        ValorEntity result = valorService.calcularValorMinimo(input);

        assertEquals(BigDecimal.valueOf(5), result.getValorMinimo());
    }

    @Test
    public void testCalcularValorMaximo() {
        List<BigDecimal> valores = Arrays.asList(BigDecimal.valueOf(10), BigDecimal.valueOf(20), BigDecimal.valueOf(5));
        ValorEntity input = new ValorEntity();
        input.setListaValores(valores);

        ValorEntity result = valorService.calcularValorMaximo(input);

        assertEquals(BigDecimal.valueOf(20), result.getValorMaximo());
    }

    @Test
    public void testCalcularSomaValores() {
        List<BigDecimal> valores = Arrays.asList(BigDecimal.valueOf(10), BigDecimal.valueOf(20), BigDecimal.valueOf(5));
        ValorEntity input = new ValorEntity();
        input.setListaValores(valores);

        ValorEntity result = valorService.calcularSomaValores(input);

        assertEquals(BigDecimal.valueOf(35), result.getSomaValores());
    }
}
