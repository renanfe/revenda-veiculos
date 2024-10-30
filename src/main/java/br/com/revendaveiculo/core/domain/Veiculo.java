package br.com.revendaveiculo.core.domain;

import br.com.revendaveiculo.adapter.driven.infra.entity.AlteracoesDadosVeiculoEntity;
import lombok.*;

import java.math.BigDecimal;
import java.util.*;

@Getter
@Builder
@AllArgsConstructor
public class Veiculo {

    @Setter
    private UUID id;
    @Setter
    private String marca;
    @Setter
    private String modelo;
    @Setter
    private Integer ano;
    @Setter
    private Cor cor;
    @Setter
    private BigDecimal preco;
    @Setter
    private Boolean vendido;
    @Setter
    private String cpfCliente;
    @Setter
    private Date dataVenda;

    @Builder.Default
    private List<AlteracoesDadosVeiculo> alteracoes = new ArrayList<>();

}
