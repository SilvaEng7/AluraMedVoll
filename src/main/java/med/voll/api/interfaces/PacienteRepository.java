package med.voll.api.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import med.voll.api.entities.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
}
