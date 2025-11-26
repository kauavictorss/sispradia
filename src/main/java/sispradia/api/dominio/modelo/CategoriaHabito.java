package sispradia.api.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria_habito")
@Getter
@Setter
public class CategoriaHabito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    List<Habito> habitos;
}
