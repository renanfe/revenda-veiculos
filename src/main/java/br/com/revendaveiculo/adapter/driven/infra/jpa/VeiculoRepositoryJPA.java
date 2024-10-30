package br.com.revendaveiculo.adapter.driven.infra.jpa;

import br.com.revendaveiculo.adapter.driven.infra.entity.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VeiculoRepositoryJPA extends JpaRepository<VeiculoEntity, UUID> {

    List<VeiculoEntity> findAllByVendidoOrderByPrecoAsc(final Boolean vendido);

}