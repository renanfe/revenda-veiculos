package br.com.revendaveiculo.adapter.driven.infra;

import br.com.revendaveiculo.adapter.driven.infra.entity.AlteracoesDadosVeiculoEntity;
import br.com.revendaveiculo.adapter.driven.infra.entity.VeiculoEntity;
import br.com.revendaveiculo.adapter.driven.infra.jpa.AlteracoesDadosVeiculoRepositoryJPA;
import br.com.revendaveiculo.adapter.utils.AlteracoesDadosVeiculoMapper;
import br.com.revendaveiculo.adapter.utils.VeiculoMapper;
import br.com.revendaveiculo.core.application.ports.AlteracoesDadosVeiculoRepository;
import br.com.revendaveiculo.core.domain.AlteracoesDadosVeiculo;
import br.com.revendaveiculo.core.domain.Veiculo;
import org.springframework.stereotype.Repository;

@Repository
public class AlteracoesDadosVeiculoRepositoryImpl implements AlteracoesDadosVeiculoRepository {

    private final AlteracoesDadosVeiculoRepositoryJPA alteracoesDadosVeiculoRepositoryJPA;

    public AlteracoesDadosVeiculoRepositoryImpl(AlteracoesDadosVeiculoRepositoryJPA alteracoesDadosVeiculoRepositoryJPA) {
        this.alteracoesDadosVeiculoRepositoryJPA = alteracoesDadosVeiculoRepositoryJPA;
    }

    @Override
    public void criarAlteracao(AlteracoesDadosVeiculo alteracoesDadosVeiculo) {
        alteracoesDadosVeiculoRepositoryJPA.save(AlteracoesDadosVeiculoMapper.alteracoesToEntity(alteracoesDadosVeiculo));
    }

}
