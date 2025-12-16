package sispradia.aplicacao.servico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sispradia.aplicacao.conversor.UsuarioConversor;
import sispradia.aplicacao.dto.usuario.CadastrarUsuarioDto;
import sispradia.aplicacao.dto.usuario.ListarUsuarioDto;
import sispradia.dominio.modelo.Usuario;
import sispradia.dominio.servico.UsuarioServico;

@Service
@RequiredArgsConstructor
public class UsuarioAppServico {

    private final UsuarioServico usuarioServico;
    private final UsuarioConversor conversor;

    public ListarUsuarioDto cadastrar(CadastrarUsuarioDto dto) {
        Usuario entidade = conversor.dtoParaEntidade(dto);
        Usuario salvo = usuarioServico.cadastrar(entidade);
        return conversor.entidadeParaDto(salvo);
    }

    public ListarUsuarioDto buscar(Long id) {
        Usuario usuario = usuarioServico.buscarPorId(id);
        return conversor.entidadeParaDto(usuario);
    }
}

