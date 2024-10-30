package br.com.revendaveiculo.application.port.output;

import br.com.revendaveiculo.domain.model.Veiculo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VeiculoRepository {

    Veiculo cadastrarVeiculo(final Veiculo veiculo);

    Veiculo atualizarVeiculo(Veiculo veiculo);

    List<Veiculo> buscarTodosVeiculos(final Boolean vendido);

    Optional<Veiculo> buscarVeiculoPorId(final UUID id);

}
