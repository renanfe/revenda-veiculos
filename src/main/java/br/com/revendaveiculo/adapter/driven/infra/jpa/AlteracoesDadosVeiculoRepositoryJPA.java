package br.com.revendaveiculo.adapter.driven.infra.jpa;

import br.com.revendaveiculo.adapter.driven.infra.AlteracoesDadosVeiculoRepositoryImpl;
import br.com.revendaveiculo.adapter.driven.infra.entity.AlteracoesDadosVeiculoEntity;
import br.com.revendaveiculo.adapter.driven.infra.entity.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlteracoesDadosVeiculoRepositoryJPA extends JpaRepository<AlteracoesDadosVeiculoEntity, UUID> {
}
