package sispradia.api.dominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sispradia.api.dominio.modelo.Habito;

public interface HabitoRepositorio extends JpaRepository<Habito, Long> {
}
