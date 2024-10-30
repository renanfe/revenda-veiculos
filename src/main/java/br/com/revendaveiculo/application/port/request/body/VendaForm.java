package br.com.revendaveiculo.application.port.request.body;

import lombok.Getter;

import java.util.Date;

@Getter
public class VendaForm {

    private String cpfCliente;
    private Date dataVenda = new Date();

}
