package sispradia.dominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sispradia.dominio.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
