package br.com.revendaveiculo.adapter.driver.form;

import br.com.revendaveiculo.core.domain.Cor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class VeiculoForm {

    private UUID id;
    private String marca;
    private String modelo;
    private Integer ano;
    private Cor cor;
    private BigDecimal preco;
    @Builder.Default
    private Boolean vendido = false;
}
