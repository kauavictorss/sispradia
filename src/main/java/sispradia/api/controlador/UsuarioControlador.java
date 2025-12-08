package sispradia.api.controlador;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sispradia.aplicacao.dto.CadastrarUsuarioDto;
import sispradia.aplicacao.dto.ListarUsuarioDto;
import sispradia.aplicacao.servico.UsuarioAplicacaoServico;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioControlador {

    private final UsuarioAplicacaoServico servico;

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
