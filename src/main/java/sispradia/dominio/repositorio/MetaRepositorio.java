package sispradia.dominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sispradia.dominio.modelo.Meta;

public interface MetaRepositorio extends JpaRepository<Meta, Long> {
}
