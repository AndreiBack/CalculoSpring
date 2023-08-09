package com.entrega088.TarefaMediaSpring.Entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class ValorEntity {
    @Getter @Setter
    private List<BigDecimal> listaValores;
    @Getter @Setter
    private BigDecimal media;
    @Getter @Setter
    private BigDecimal mediana;
    @Getter @Setter
    private BigDecimal desvio;
    @Getter @Setter
    private int quantidade;
}
