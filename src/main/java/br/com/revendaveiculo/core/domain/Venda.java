package br.com.revendaveiculo.core.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class Venda {

    private String cpfCliente;
    @Builder.Default
    private Date dataVenda;

}
