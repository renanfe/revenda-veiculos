package br.com.revendaveiculo.adapter.utils;

import br.com.revendaveiculo.adapter.driven.infra.entity.AlteracoesDadosVeiculoEntity;
import br.com.revendaveiculo.core.domain.AlteracoesDadosVeiculo;

public class AlteracoesDadosVeiculoMapper {
    public static AlteracoesDadosVeiculoEntity alteracoesToEntity(AlteracoesDadosVeiculo alteracoesDadosVeiculo) {
        return AlteracoesDadosVeiculoEntity.builder()
                .id(alteracoesDadosVeiculo.getId())
                .data(alteracoesDadosVeiculo.getData())
                .eventoAlteracao(alteracoesDadosVeiculo.getEventoAlteracao())
                .build();
    
    }

    public static AlteracoesDadosVeiculo altecoesEntityToAlteracoes (AlteracoesDadosVeiculoEntity alteracoesDadosVeiculoEntity) {
        return AlteracoesDadosVeiculo.builder()
                .id(alteracoesDadosVeiculoEntity.getId())
                .data(alteracoesDadosVeiculoEntity.getData())
                .eventoAlteracao(alteracoesDadosVeiculoEntity.getEventoAlteracao())
                .build();
    }
}
