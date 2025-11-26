package sispradia.api.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "meta")
@Getter
@Setter
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;

    @Column(name = "quantidade_objetivo")
    private int quantidadeObjetivo;

    @Enumerated(EnumType.STRING)
    private Periodo periodo;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "habito_id")
    private Habito habito;
}
