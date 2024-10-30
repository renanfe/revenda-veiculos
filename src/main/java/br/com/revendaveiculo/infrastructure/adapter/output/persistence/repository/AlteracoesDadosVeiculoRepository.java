package br.com.revendaveiculo.infrastructure.adapter.output.persistence.repository;

import br.com.revendaveiculo.infrastructure.adapter.output.persistence.entity.AlteracoesDadosVeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlteracoesDadosVeiculoRepository extends JpaRepository<AlteracoesDadosVeiculoEntity, UUID> {
}
