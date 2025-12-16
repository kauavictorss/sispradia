package sispradia.dominio.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sispradia.aplicacao.dto.usuario.CadastrarUsuarioDto;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "ativo")
    private boolean ativo;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "usuario")
    List<Pratica> praticas;

    public Usuario(@Valid CadastrarUsuarioDto dados) {
        this.ativo = true;
        this.nome = dados.getNome();
        this.email = dados.getEmail();
        this.senha = dados.getSenha();
    }

    @PrePersist
    protected void onCreate() {
        dataCriacao = LocalDateTime.now();
    }
}
