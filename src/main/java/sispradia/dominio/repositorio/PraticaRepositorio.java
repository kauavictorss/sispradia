package sispradia.dominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sispradia.dominio.modelo.Pratica;

public interface PraticaRepositorio extends JpaRepository<Pratica, Long> {
}
