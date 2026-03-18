package med.voll.api.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import med.voll.api.entities.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    
}

