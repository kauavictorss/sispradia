package sispradia.aplicacao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sispradia.dominio.modelo.Usuario;

@Getter
@AllArgsConstructor
public class ListarUsuarioDto {

    private Long id;
    private String nome;
    private String email;

    public ListarUsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }
}
