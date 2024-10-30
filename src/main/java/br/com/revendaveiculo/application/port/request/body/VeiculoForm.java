package br.com.revendaveiculo.application.port.request.body;

import br.com.revendaveiculo.domain.model.Cor;
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
