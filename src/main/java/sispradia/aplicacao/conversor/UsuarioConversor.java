package sispradia.aplicacao.conversor;

import org.springframework.stereotype.Component;
import sispradia.aplicacao.dto.usuario.AtualizarUsuarioDto;
import sispradia.aplicacao.dto.usuario.CadastrarUsuarioDto;
import sispradia.aplicacao.dto.usuario.ListarUsuarioDto;
import sispradia.dominio.modelo.Usuario;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioConversor {

    public Usuario dtoParaEntidade(CadastrarUsuarioDto dto) {
        return new Usuario(dto);
    }

    public Usuario atualizarDtoParaEntidade(AtualizarUsuarioDto dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        return usuario;
    }

    public ListarUsuarioDto entidadeParaDto(Usuario entidade) {
        return new ListarUsuarioDto(entidade);
    }
    
    public List<ListarUsuarioDto> entidadesParaDtos(List<Usuario> entidades) {
        return entidades.stream()
                .map(this::entidadeParaDto)
                .collect(Collectors.toList());
    }
}

