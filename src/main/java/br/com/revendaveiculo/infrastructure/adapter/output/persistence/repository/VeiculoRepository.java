package br.com.revendaveiculo.infrastructure.adapter.output.persistence.repository;

import br.com.revendaveiculo.infrastructure.adapter.output.persistence.entity.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VeiculoRepository extends JpaRepository<VeiculoEntity, UUID> {

    List<VeiculoEntity> findAllByVendidoOrderByPrecoAsc(final Boolean vendido);

}