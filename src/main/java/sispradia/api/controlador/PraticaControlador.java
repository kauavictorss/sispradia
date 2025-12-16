package sispradia.api.controlador;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sispradia.aplicacao.dto.pratica.CadastrarPraticaDto;
import sispradia.aplicacao.dto.pratica.ListarPraticaDto;
import sispradia.aplicacao.servico.PraticaAppServico;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/praticas")
public class PraticaControlador {

    private final PraticaAppServico servico;

    @PostMapping
    @Transactional
    public ListarPraticaDto cadastrar(@RequestBody @Valid CadastrarPraticaDto dados) {
        return servico.cadastrar(dados);
    }
}
