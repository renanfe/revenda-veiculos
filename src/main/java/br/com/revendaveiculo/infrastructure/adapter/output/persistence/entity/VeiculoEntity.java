package br.com.revendaveiculo.infrastructure.adapter.output.persistence.entity;

import br.com.revendaveiculo.domain.model.Cor;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "veiculo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class VeiculoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "cor")
    private Cor cor;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name= "vendido")
    private Boolean vendido;

    @Column(name= "cpf_cliente")
    private String cpfCliente;

    @Column(name= "data_venda")
    private Date dataVenda;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<AlteracoesDadosVeiculoEntity> alteracoes = new ArrayList<>();

}
