package sispradia.api.controlador;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sispradia.aplicacao.dto.usuario.AtualizarUsuarioDto;
import sispradia.aplicacao.dto.usuario.CadastrarUsuarioDto;
import sispradia.aplicacao.dto.usuario.ListarUsuarioDto;
import sispradia.aplicacao.servico.UsuarioAppServico;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioControlador {

    private final UsuarioAppServico servico;

    @PostMapping
    @Transactional
    public ResponseEntity<ListarUsuarioDto> cadastrar(@RequestBody @Valid CadastrarUsuarioDto dados) {
        ListarUsuarioDto usuario = servico.cadastrar(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<ListarUsuarioDto>> listarAtivos() {
        List<ListarUsuarioDto> usuarios = servico.listarAtivos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/inativos")
    public ResponseEntity<List<ListarUsuarioDto>> listarInativos() {
        List<ListarUsuarioDto> usuarios = servico.listarInativos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ListarUsuarioDto>> buscarPorNome(@RequestParam String nome) {
        List<ListarUsuarioDto> usuarios = servico.buscarPorNome(nome);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ListarUsuarioDto> buscarPorEmail(@PathVariable String email) {
        ListarUsuarioDto usuario = servico.buscarPorEmail(email);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<ListarUsuarioDto>> listarTodos() {
        List<ListarUsuarioDto> usuarios = servico.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListarUsuarioDto> buscarPorId(@PathVariable Long id) {
        ListarUsuarioDto usuario = servico.buscar(id);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ListarUsuarioDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarUsuarioDto dados) {
        dados.setId(id);
        ListarUsuarioDto usuario = servico.atualizar(dados);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        servico.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
