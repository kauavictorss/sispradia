package sispradia.aplicacao.servico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sispradia.aplicacao.conversor.PraticaConversor;
import sispradia.aplicacao.dto.pratica.CadastrarPraticaDto;
import sispradia.aplicacao.dto.pratica.ListarPraticaDto;
import sispradia.dominio.modelo.Pratica;
import sispradia.dominio.modelo.Usuario;
import sispradia.dominio.repositorio.UsuarioRepositorio;
import sispradia.dominio.servico.PraticaServico;

@Service
@RequiredArgsConstructor
public class PraticaAppServico {

    private final PraticaConversor conversor;
    private final PraticaServico servico;
    private final UsuarioRepositorio usuarioRepo;

    public ListarPraticaDto cadastrar(CadastrarPraticaDto dto) {

        Usuario usuario = usuarioRepo.findById(dto.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com o ID: " + dto.getUsuarioId()));

        Pratica entidade = conversor.dtoParaEntidade(dto);

        Pratica salva = servico.cadastrar(entidade, usuario);

        return conversor.entidadeParaDto(salva);
    }
}
