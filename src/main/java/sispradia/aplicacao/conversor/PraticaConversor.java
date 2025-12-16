package sispradia.aplicacao.conversor;

import org.springframework.stereotype.Component;
import sispradia.aplicacao.dto.pratica.CadastrarPraticaDto;
import sispradia.aplicacao.dto.pratica.ListarPraticaDto;
import sispradia.dominio.modelo.Pratica;

@Component
public class PraticaConversor {

    public Pratica dtoParaEntidade(CadastrarPraticaDto dto) {
        return new Pratica(dto);
    }

    public ListarPraticaDto entidadeParaDto(Pratica entidade) {
        return new ListarPraticaDto(entidade);
    }
}
