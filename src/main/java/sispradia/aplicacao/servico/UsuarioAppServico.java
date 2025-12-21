package sispradia.aplicacao.servico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sispradia.aplicacao.conversor.UsuarioConversor;
import sispradia.aplicacao.dto.usuario.AtualizarUsuarioDto;
import sispradia.aplicacao.dto.usuario.CadastrarUsuarioDto;
import sispradia.aplicacao.dto.usuario.ListarUsuarioDto;
import sispradia.dominio.modelo.Usuario;
import sispradia.dominio.servico.UsuarioServico;

import java.util.List;

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

    public ListarUsuarioDto buscarPorEmail(String email) {
        Usuario usuario = usuarioServico.buscarPorEmail(email);
        return conversor.entidadeParaDto(usuario);
    }
    
    public List<ListarUsuarioDto> listarTodos() {
        List<Usuario> usuarios = usuarioServico.listarTodos();
        return conversor.entidadesParaDtos(usuarios);
    }
    
    public List<ListarUsuarioDto> listarAtivos() {
        List<Usuario> usuarios = usuarioServico.listarAtivos();
        return conversor.entidadesParaDtos(usuarios);
    }
    
    public List<ListarUsuarioDto> listarInativos() {
        List<Usuario> usuarios = usuarioServico.listarInativos();
        return conversor.entidadesParaDtos(usuarios);
    }
    
    public List<ListarUsuarioDto> buscarPorNome(String nome) {
        List<Usuario> usuarios = usuarioServico.buscarPorNome(nome);
        return conversor.entidadesParaDtos(usuarios);
    }

    public ListarUsuarioDto atualizar(AtualizarUsuarioDto dto) {
        Usuario usuarioExistente = usuarioServico.buscarPorId(dto.getId());
        
        Usuario usuarioAtualizado = conversor.atualizarDtoParaEntidade(dto);
        
        Usuario usuarioSalvo = usuarioServico.atualizar(usuarioAtualizado, usuarioExistente);
        
        return conversor.entidadeParaDto(usuarioSalvo);
    }

    public void deletar(Long id) {
        usuarioServico.deletar(id);
    }
}

