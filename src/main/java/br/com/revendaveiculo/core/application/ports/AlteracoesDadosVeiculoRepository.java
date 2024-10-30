package br.com.revendaveiculo.core.application.ports;

import br.com.revendaveiculo.core.domain.AlteracoesDadosVeiculo;

public interface AlteracoesDadosVeiculoRepository {

    void criarAlteracao(AlteracoesDadosVeiculo alteracoesDadosVeiculo);
}
