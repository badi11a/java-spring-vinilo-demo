package cl.talento.vinilo.demo.repositorio;

import cl.talento.vinilo.demo.modelo.Vinilo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViniloRepository extends JpaRepository<Vinilo, Integer> {
}
