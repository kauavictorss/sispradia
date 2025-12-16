package sispradia.aplicacao.conversor;

import org.springframework.stereotype.Component;
import sispradia.aplicacao.dto.usuario.CadastrarUsuarioDto;
import sispradia.aplicacao.dto.usuario.ListarUsuarioDto;
import sispradia.dominio.modelo.Usuario;

@Component
public class UsuarioConversor {

    public Usuario dtoParaEntidade(CadastrarUsuarioDto dto) {
        return new Usuario(dto);
    }

    public ListarUsuarioDto entidadeParaDto(Usuario entidade) {
        return new ListarUsuarioDto(entidade);
    }
}

