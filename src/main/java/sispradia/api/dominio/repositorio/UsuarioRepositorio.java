package sispradia.api.dominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sispradia.api.dominio.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
