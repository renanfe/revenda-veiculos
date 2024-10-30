package br.com.revendaveiculo.domain.service;

import br.com.revendaveiculo.application.port.output.AlteracoesDadosVeiculoRepository;
import br.com.revendaveiculo.application.port.output.VeiculoRepository;
import br.com.revendaveiculo.domain.model.AlteracoesDadosVeiculo;
import br.com.revendaveiculo.domain.model.EventoAlteracao;
import br.com.revendaveiculo.domain.model.Veiculo;
import br.com.revendaveiculo.domain.model.Venda;
import br.com.revendaveiculo.application.port.input.VeiculoUseCase;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VeiculoService implements VeiculoUseCase {

    private final VeiculoRepository veiculoRepository;
    private final AlteracoesDadosVeiculoRepository alteracoesDadosVeiculoRepository;

    public VeiculoService (final VeiculoRepository veiculoRepository, AlteracoesDadosVeiculoRepository alteracoesDadosVeiculoRepository){
        this.veiculoRepository = veiculoRepository;
        this.alteracoesDadosVeiculoRepository = alteracoesDadosVeiculoRepository;
    }

    public Veiculo criarVeiculo(final Veiculo veiculo){
        AlteracoesDadosVeiculo alteracoesDadosVeiculo = gerarAlteracao(veiculo, EventoAlteracao.CADASTRO);
        veiculo.getAlteracoes().add(alteracoesDadosVeiculo);
        Veiculo veiculoNovo = veiculoRepository.cadastrarVeiculo(veiculo);
        return veiculoNovo;
    }

    public Veiculo atualizarVeiculo(final UUID id, final Veiculo veiculo2Update){
        return veiculoRepository
                .buscarVeiculoPorId(id)
                .map(veiculo -> atualizarVeiculo(veiculo, veiculo2Update))
                .map(veiculoRepository::atualizarVeiculo)
                .get();
    }

    public Veiculo venderVeiculo(final UUID id, final Venda venda){
        return veiculoRepository
                .buscarVeiculoPorId(id)
                .map(veiculo -> atualizarVendaVeiculo(veiculo, venda))
                .map(veiculoRepository::atualizarVeiculo)
                .get();
    }

    public List<Veiculo> listarVeiculo(final Boolean vendido){
        return veiculoRepository.buscarTodosVeiculos(vendido);
    }

    public Optional<Veiculo> retornarVeiculo(final UUID id){
        return veiculoRepository.buscarVeiculoPorId(id);
    }

    public Veiculo atualizarVendaVeiculo(Veiculo veiculo, Venda venda){
        veiculo.getAlteracoes().add(gerarAlteracao(veiculo, EventoAlteracao.VENDA));
        veiculo.setCpfCliente(venda.getCpfCliente());
        veiculo.setDataVenda(venda.getDataVenda());
        veiculo.setVendido(true);
        return veiculo;
    }

    public Veiculo atualizarVeiculo(Veiculo veiculo, Veiculo veiculo2Update){
        veiculo.getAlteracoes().add(gerarAlteracao(veiculo, EventoAlteracao.EDICAO));
        veiculo.setCor(veiculo2Update.getCor());
        veiculo.setAno(veiculo2Update.getAno());
        veiculo.setMarca(veiculo2Update.getMarca());
        veiculo.setModelo(veiculo2Update.getModelo());
        veiculo.setPreco(veiculo2Update.getPreco());
        return veiculo;
    }

    public AlteracoesDadosVeiculo gerarAlteracao(Veiculo veiculo, EventoAlteracao evento){
        return AlteracoesDadosVeiculo.builder()
                .veiculo(veiculo)
                .eventoAlteracao(evento)
                .data(new Date())
                .build();
    }

}
