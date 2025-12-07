package sispradia.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "registro_diario")
public class RegistroDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_registro", nullable = false)
    private LocalDate dataRegistro;

    @Column(name = "feito")
    private boolean concluido;

    @Column(name = "observacao")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "pratica_id")
    private Pratica pratica;
}
