package med.voll.api_medvoll.repository;

import med.voll.api_medvoll.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
