package br.com.revendaveiculo.infrastructure.adapter.output.persistence.entity;

import br.com.revendaveiculo.domain.model.EventoAlteracao;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "alteracoes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class AlteracoesDadosVeiculoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "id_veiculo", nullable = false)
    @Setter
    private VeiculoEntity veiculo;

    @Column(name = "data")
    private Date data;

    @Column(name = "evento")
    private EventoAlteracao eventoAlteracao;

}
