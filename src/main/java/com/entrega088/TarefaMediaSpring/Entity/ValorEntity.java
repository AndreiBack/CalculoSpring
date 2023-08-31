package com.entrega088.TarefaMediaSpring.Entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Getter @Setter
public class ValorEntity {
    private List<BigDecimal> listaValores;
    private BigDecimal media;
    private BigDecimal mediana;
    private BigDecimal desvio;
    private int quantidade;
    private BigDecimal valorMinimo;
    private BigDecimal valorMaximo;
    private BigDecimal somaValores;
}
