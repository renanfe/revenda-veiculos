package br.com.revendaveiculo.application.port.output;

import br.com.revendaveiculo.domain.model.AlteracoesDadosVeiculo;

public interface AlteracoesDadosVeiculoRepository {

    void criarAlteracao(AlteracoesDadosVeiculo alteracoesDadosVeiculo);
}
