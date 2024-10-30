package br.com.revendaveiculo.infrastructure.adapter.output.persistence.mapper;

import br.com.revendaveiculo.infrastructure.adapter.output.persistence.entity.AlteracoesDadosVeiculoEntity;
import br.com.revendaveiculo.infrastructure.adapter.output.persistence.entity.VeiculoEntity;
import br.com.revendaveiculo.application.port.request.body.VeiculoForm;
import br.com.revendaveiculo.domain.model.Veiculo;

import java.util.List;
import java.util.stream.Collectors;

public class VeiculoMapper {

    private VeiculoMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static VeiculoEntity veiculoToEntity(final Veiculo veiculo) {
        VeiculoEntity veiculoEntity = VeiculoEntity.builder()
                .id(veiculo.getId())
                .ano(veiculo.getAno())
                .cor(veiculo.getCor())
                .preco(veiculo.getPreco())
                .marca(veiculo.getMarca())
                .modelo(veiculo.getModelo())
                .cpfCliente(veiculo.getCpfCliente())
                .dataVenda(veiculo.getDataVenda())
                .vendido(veiculo.getVendido())
                .build();
        List<AlteracoesDadosVeiculoEntity> lstAlteracoesDadosVeiculoEntity = veiculo.getAlteracoes()
                .stream()
                .map(AlteracoesDadosVeiculoMapper::alteracoesToEntity)
                .collect(Collectors.toList());
        veiculoEntity.setAlteracoes(lstAlteracoesDadosVeiculoEntity);
        lstAlteracoesDadosVeiculoEntity.forEach(alteracoesDadosVeiculoEntity -> alteracoesDadosVeiculoEntity.setVeiculo(veiculoEntity));
        return veiculoEntity;
    }

    public static Veiculo veiculoEntityToVeiculo(final VeiculoEntity veiculoEntity) {
        return Veiculo.builder()
                .id(veiculoEntity.getId())
                .ano(veiculoEntity.getAno())
                .cor(veiculoEntity.getCor())
                .preco(veiculoEntity.getPreco())
                .marca(veiculoEntity.getMarca())
                .modelo(veiculoEntity.getModelo())
                .cpfCliente(veiculoEntity.getCpfCliente())
                .dataVenda(veiculoEntity.getDataVenda())
                .vendido(veiculoEntity.getVendido())
                .alteracoes(veiculoEntity.getAlteracoes().stream().map(AlteracoesDadosVeiculoMapper::altecoesEntityToAlteracoes).collect(Collectors.toList()))
                .build();
    }

    public static Veiculo veiculoFormToVeiculo(final VeiculoForm veiculoForm) {
        return Veiculo.builder()
                .ano(veiculoForm.getAno())
                .cor(veiculoForm.getCor())
                .preco(veiculoForm.getPreco())
                .marca(veiculoForm.getMarca())
                .modelo(veiculoForm.getModelo())
                .vendido(veiculoForm.getVendido())
                .build();
    }

}
