package sispradia.dominio.servico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sispradia.dominio.modelo.Usuario;
import sispradia.dominio.repositorio.UsuarioRepositorio;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UsuarioServico {

    private final UsuarioRepositorio repositorio;

    public Usuario cadastrar(Usuario usuario) {
        if (repositorio.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("Já existe um usuário com esse email");
        }

        usuario.setDataCriacao(LocalDateTime.now());
        usuario.setAtivo(true);

        return repositorio.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return repositorio.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
