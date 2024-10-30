package br.com.revendaveiculo.infrastructure.adapter.output.persistence;

import br.com.revendaveiculo.infrastructure.adapter.output.persistence.entity.VeiculoEntity;
import br.com.revendaveiculo.infrastructure.adapter.output.persistence.repository.VeiculoRepository;
import br.com.revendaveiculo.infrastructure.adapter.output.persistence.mapper.VeiculoMapper;
import br.com.revendaveiculo.domain.model.Veiculo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class VeiculoRepositoryAdapter implements br.com.revendaveiculo.application.port.output.VeiculoRepository {

    private final VeiculoRepository veiculoRepository;

    public VeiculoRepositoryAdapter (VeiculoRepository veiculoRepository){
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public Veiculo cadastrarVeiculo(Veiculo veiculo) {
        VeiculoEntity veiculoEntity = veiculoRepository.save(VeiculoMapper.veiculoToEntity(veiculo));
        return VeiculoMapper.veiculoEntityToVeiculo(veiculoEntity);
    }

    @Override
    public Veiculo atualizarVeiculo(Veiculo veiculo) {
        VeiculoEntity veiculoEntity = veiculoRepository.save(VeiculoMapper.veiculoToEntity(veiculo));
        return VeiculoMapper.veiculoEntityToVeiculo(veiculoEntity);
    }

    @Override
    public List<Veiculo> buscarTodosVeiculos(final Boolean vendido){
        List<Veiculo> lstVeiculo = new ArrayList<>();
        for(VeiculoEntity veiculoEntity: veiculoRepository.findAllByVendidoOrderByPrecoAsc(vendido)){
            lstVeiculo.add(VeiculoMapper.veiculoEntityToVeiculo(veiculoEntity));
        }
        return lstVeiculo;
    }

    @Override
    public Optional<Veiculo> buscarVeiculoPorId (UUID id) {
        return veiculoRepository.findById(id).map(VeiculoMapper::veiculoEntityToVeiculo);
    }

}
