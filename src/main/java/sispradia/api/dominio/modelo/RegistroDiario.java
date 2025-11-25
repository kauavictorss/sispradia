package sispradia.api.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "registro_diario")
@Getter
@Setter
public class RegistroDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_registro", nullable = false)
    private LocalDate dataRegistro;

    @Column(name = "feito")
    private boolean concluido;

    private String observacao;

    @ManyToOne
    @JoinColumn(name = "habito_id")
    private Habito habito;
}
