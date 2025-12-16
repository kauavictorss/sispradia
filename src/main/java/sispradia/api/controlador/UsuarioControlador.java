package sispradia.api.controlador;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sispradia.aplicacao.dto.usuario.CadastrarUsuarioDto;
import sispradia.aplicacao.dto.usuario.ListarUsuarioDto;
import sispradia.aplicacao.servico.UsuarioAppServico;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioControlador {

    private final UsuarioAppServico servico;

    @PostMapping
    @Transactional
    public ListarUsuarioDto cadastrar(@RequestBody @Valid CadastrarUsuarioDto dados) {
        return servico.cadastrar(dados);
    }

    @GetMapping("/{id}")
    public ListarUsuarioDto listarUsuarios(@PathVariable Long id) {
        return servico.buscar(id);
    }
}
