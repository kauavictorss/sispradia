package sispradia.aplicacao.dto.pratica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CadastrarPraticaDto {

    @NotBlank(message = "O título da prática é obrigatório")
    private String titulo;

    private String descricao;

    @NotNull(message = "O ID do usuário é obrigatório")
    private Long usuarioId;

    private Long categoriaId;

}
