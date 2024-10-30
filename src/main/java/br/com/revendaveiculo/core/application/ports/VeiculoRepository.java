package br.com.revendaveiculo.core.application.ports;

import br.com.revendaveiculo.core.domain.Veiculo;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VeiculoRepository {

    Veiculo cadastrarVeiculo(final Veiculo veiculo);

    Veiculo atualizarVeiculo(Veiculo veiculo);

    List<Veiculo> buscarTodosVeiculos(final Boolean vendido);

    Optional<Veiculo> buscarVeiculoPorId(final UUID id);

}
