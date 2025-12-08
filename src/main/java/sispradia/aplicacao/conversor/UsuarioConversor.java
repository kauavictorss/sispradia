package sispradia.aplicacao.conversor;

import org.springframework.stereotype.Component;
import sispradia.aplicacao.dto.CadastrarUsuarioDto;
import sispradia.aplicacao.dto.ListarUsuarioDto;
import sispradia.dominio.modelo.Usuario;

@Component
public class UsuarioConversor {

    public Usuario dtoParaEntidade(CadastrarUsuarioDto dados) {
        return new Usuario(dados);
    }

    public ListarUsuarioDto entidadeParaDto(Usuario entidade) {
        return new ListarUsuarioDto(entidade);
    }
}

