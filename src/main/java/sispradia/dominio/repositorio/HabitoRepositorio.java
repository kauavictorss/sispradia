package sispradia.dominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sispradia.dominio.modelo.Pratica;

public interface HabitoRepositorio extends JpaRepository<Pratica, Long> {
}
