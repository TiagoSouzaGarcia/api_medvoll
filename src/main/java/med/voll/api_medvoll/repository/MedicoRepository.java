package med.voll.api_medvoll.repository;

import med.voll.api_medvoll.medico.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
