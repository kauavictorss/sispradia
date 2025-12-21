package sispradia.dominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sispradia.dominio.modelo.Usuario;

import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);

    Usuario findByEmail(String email);

    List<Usuario> findByAtivoTrue();
    
    List<Usuario> findByAtivoFalse();

    List<Usuario> findByNomeContainingIgnoreCase(String nome);
}
