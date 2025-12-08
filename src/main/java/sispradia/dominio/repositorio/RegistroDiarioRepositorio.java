package sispradia.dominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sispradia.dominio.modelo.RegistroDiario;

public interface RegistroDiarioRepositorio extends JpaRepository<RegistroDiario, Long> {
}
