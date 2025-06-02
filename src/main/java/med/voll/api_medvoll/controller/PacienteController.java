package med.voll.api_medvoll.controller;

import jakarta.validation.Valid;
import med.voll.api_medvoll.paciente.DadosCadastroPaciente;
import med.voll.api_medvoll.paciente.DadosListagemPaciente;
import med.voll.api_medvoll.paciente.Paciente;
import med.voll.api_medvoll.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping("/save")
    @Transactional
    public void save(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> list(@PageableDefault(size = 10, sort = "nome")Pageable page) {
        return repository.findAll(page).map(DadosListagemPaciente::new);
    }
}
