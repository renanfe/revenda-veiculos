package br.com.revendaveiculo.application.port.input;
import br.com.revendaveiculo.domain.model.Veiculo;
import br.com.revendaveiculo.domain.model.Venda;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VeiculoUseCase {

    public Veiculo criarVeiculo(final Veiculo veiculo);

    public Veiculo atualizarVeiculo(final UUID id, final Veiculo veiculo2Update);

    public Veiculo venderVeiculo(final UUID id, final Venda venda);

    public List<Veiculo> listarVeiculo(final Boolean vendido);

    public Optional<Veiculo> retornarVeiculo(final UUID id);

}
