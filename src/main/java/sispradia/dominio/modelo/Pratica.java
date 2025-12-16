package sispradia.dominio.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sispradia.aplicacao.dto.pratica.CadastrarPraticaDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "pratica")
public class Pratica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "criado_em", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "ativo")
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaPratica categoria;

    public Pratica(CadastrarPraticaDto dto) {
        this.ativo = true;
        this.titulo = dto.getTitulo();
        this.descricao = dto.getDescricao();
    }

    @PrePersist
    protected void onCreate() {
        dataCriacao = LocalDateTime.now();
    }
}
