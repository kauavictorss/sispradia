package sispradia.aplicacao.dto.pratica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sispradia.dominio.modelo.Pratica;

@Getter
@AllArgsConstructor
public class ListarPraticaDto {

    private Long id;
    private String titulo;
    private String descricao;

    public ListarPraticaDto(Pratica entidade) {
        this.id = entidade.getId();
        this.titulo = entidade.getTitulo();
        this.descricao = entidade.getDescricao();
    }
}
