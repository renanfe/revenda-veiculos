package br.com.revendaveiculo.infrastructure.adapter.output.persistence;

import br.com.revendaveiculo.infrastructure.adapter.output.persistence.repository.AlteracoesDadosVeiculoRepository;
import br.com.revendaveiculo.infrastructure.adapter.output.persistence.mapper.AlteracoesDadosVeiculoMapper;
import br.com.revendaveiculo.domain.model.AlteracoesDadosVeiculo;
import org.springframework.stereotype.Repository;

@Repository
public class AlteracoesDadosVeiculoAdapter implements br.com.revendaveiculo.application.port.output.AlteracoesDadosVeiculoRepository {

    private final AlteracoesDadosVeiculoRepository alteracoesDadosVeiculoRepositoryJPA;

    public AlteracoesDadosVeiculoAdapter (AlteracoesDadosVeiculoRepository alteracoesDadosVeiculoRepositoryJPA) {
        this.alteracoesDadosVeiculoRepositoryJPA = alteracoesDadosVeiculoRepositoryJPA;
    }

    @Override
    public void criarAlteracao(AlteracoesDadosVeiculo alteracoesDadosVeiculo) {
        alteracoesDadosVeiculoRepositoryJPA.save(AlteracoesDadosVeiculoMapper.alteracoesToEntity(alteracoesDadosVeiculo));
    }

}
