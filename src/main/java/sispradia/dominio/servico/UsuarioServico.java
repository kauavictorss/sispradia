package sispradia.dominio.servico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sispradia.dominio.modelo.Usuario;
import sispradia.dominio.repositorio.UsuarioRepositorio;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServico {

    private final UsuarioRepositorio repositorio;

    public Usuario cadastrar(Usuario usuario) {
        if (repositorio.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("Já existe um usuário com esse email!");
        }

        usuario.setAtivo(true);
        return repositorio.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return repositorio.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com o ID: " + id));
    }

    public Usuario buscarPorEmail(String email) {
        Usuario usuario = repositorio.findByEmail(email);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não encontrado com o email: " + email);
        }
        return usuario;
    }
    
    public List<Usuario> listarTodos() {
        return repositorio.findAll();
    }
    
    public List<Usuario> listarAtivos() {
        return repositorio.findByAtivoTrue();
    }
    
    public List<Usuario> listarInativos() {
        return repositorio.findByAtivoFalse();
    }
    
    public List<Usuario> buscarPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio");
        }
        return repositorio.findByNome(nome);
    }

    public Usuario atualizar(Usuario usuarioAtualizado, Usuario usuarioExistente) {
        if (!usuarioExistente.getEmail().equals(usuarioAtualizado.getEmail())) {
            if (repositorio.existsByEmail(usuarioAtualizado.getEmail())) {
                throw new IllegalArgumentException("Já existe outro usuário com o email: " + usuarioAtualizado.getEmail());
            }
        }

        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        
        // Só atualiza a senha se foi informada
        if (usuarioAtualizado.getSenha() != null && !usuarioAtualizado.getSenha().isEmpty()) {
            usuarioExistente.setSenha(usuarioAtualizado.getSenha());
        }

        return repositorio.save(usuarioExistente);
    }

    public void deletar(Long id) {
        Usuario usuario = buscarPorId(id);
        
        usuario.setAtivo(false);
        repositorio.save(usuario);
    }
    
    public void deletarPermanente(Long id) {
        if (!repositorio.existsById(id)) {
            throw new IllegalArgumentException("Usuário não encontrado com o ID: " + id);
        }
        repositorio.deleteById(id);
    }
}
