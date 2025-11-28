package sispradia.api.controlador;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sispradia.aplicacao.dto.CadastrarUsuarioDto;
import sispradia.aplicacao.dto.ListarUsuarioDto;
import sispradia.dominio.modelo.Usuario;
import sispradia.dominio.repositorio.UsuarioRepositorio;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioControlador {

    private final UsuarioRepositorio repositorio;

    @PostMapping
    @Transactional
    public void cadastrarUsuario(@RequestBody @Valid CadastrarUsuarioDto dados) {
        repositorio.save(new Usuario(dados));
    }

    @GetMapping("/{id}")
    public List<ListarUsuarioDto> listarUsuarios(@PathVariable Long id) {
        return repositorio.findById(id)
                .map(ListarUsuarioDto::new)
                .map(Collections::singletonList)
                .orElse(Collections.emptyList());
    }
}
