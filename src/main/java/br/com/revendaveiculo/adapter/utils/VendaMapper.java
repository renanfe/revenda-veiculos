package br.com.revendaveiculo.adapter.utils;

import br.com.revendaveiculo.adapter.driver.form.VendaForm;
import br.com.revendaveiculo.core.domain.Venda;

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
