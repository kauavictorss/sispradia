package sispradia.dominio.servico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sispradia.dominio.modelo.Pratica;
import sispradia.dominio.modelo.Usuario;
import sispradia.dominio.repositorio.PraticaRepositorio;

@Service
@RequiredArgsConstructor
public class PraticaServico {

    private final PraticaRepositorio repositorio;

    public Pratica cadastrar(Pratica pratica, Usuario usuario) {
        if (repositorio.existsByTituloAndUsuarioId(pratica.getTitulo(), usuario.getId())) {
            throw new IllegalArgumentException("Você já tem uma prática cadastrada com o título: " + pratica.getTitulo());
        }

        pratica.setAtivo(true);
        pratica.setUsuario(usuario);

        return repositorio.save(pratica);
    }

}

