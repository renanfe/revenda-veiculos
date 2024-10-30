package br.com.revendaveiculo.core.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
@Builder
public class AlteracoesDadosVeiculo {

    private UUID id;
    private Veiculo veiculo;
    private Date data;
    private EventoAlteracao eventoAlteracao;

}
