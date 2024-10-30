package br.com.revendaveiculo.adapter.driven.infra;

import br.com.revendaveiculo.adapter.driven.infra.entity.VeiculoEntity;
import br.com.revendaveiculo.adapter.driven.infra.jpa.VeiculoRepositoryJPA;
import br.com.revendaveiculo.adapter.utils.VeiculoMapper;
import br.com.revendaveiculo.core.application.ports.VeiculoRepository;
import br.com.revendaveiculo.core.domain.Veiculo;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class VeiculoRepositoryImpl implements VeiculoRepository {

    private final VeiculoRepositoryJPA veiculoRepositoryJPA;

    public VeiculoRepositoryImpl(VeiculoRepositoryJPA veiculoRepositoryJPA){
        this.veiculoRepositoryJPA = veiculoRepositoryJPA;
    }

    @Override
    public Veiculo cadastrarVeiculo(Veiculo veiculo) {
        VeiculoEntity veiculoEntity = veiculoRepositoryJPA.save(VeiculoMapper.veiculoToEntity(veiculo));
        return VeiculoMapper.veiculoEntityToVeiculo(veiculoEntity);
    }

    @Override
    public Veiculo atualizarVeiculo(Veiculo veiculo) {
        VeiculoEntity veiculoEntity = veiculoRepositoryJPA.save(VeiculoMapper.veiculoToEntity(veiculo));
        return VeiculoMapper.veiculoEntityToVeiculo(veiculoEntity);
    }

    @Override
    public List<Veiculo> buscarTodosVeiculos(final Boolean vendido){
        List<Veiculo> lstVeiculo = new ArrayList<>();
        for(VeiculoEntity veiculoEntity: veiculoRepositoryJPA.findAllByVendidoOrderByPrecoAsc(vendido)){
            lstVeiculo.add(VeiculoMapper.veiculoEntityToVeiculo(veiculoEntity));
        }
        return lstVeiculo;
    }

    @Override
    public Optional<Veiculo> buscarVeiculoPorId (UUID id) {
        return veiculoRepositoryJPA.findById(id).map(VeiculoMapper::veiculoEntityToVeiculo);
    }

}
