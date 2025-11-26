package sispradia.dominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sispradia.dominio.modelo.Habito;

public interface HabitoRepositorio extends JpaRepository<Habito, Long> {
}
