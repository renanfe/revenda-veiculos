package br.com.revendaveiculo.adapter.driver.form;

import lombok.Getter;

import java.util.Date;

@Getter
public class VendaForm {

    private String cpfCliente;
    private Date dataVenda = new Date();

}
