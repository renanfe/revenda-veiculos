package br.com.revendaveiculo.infrastructure.adapter.output.persistence.mapper;

import br.com.revendaveiculo.application.port.request.body.VendaForm;
import br.com.revendaveiculo.domain.model.Venda;

public class VendaMapper {

    private VendaMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Venda vendaFormToVenda(VendaForm vendaForm){
        return Venda.builder()
                .cpfCliente(vendaForm.getCpfCliente())
                .dataVenda(vendaForm.getDataVenda())
                .build();

    }
}
