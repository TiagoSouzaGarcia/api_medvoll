package med.voll.api_medvoll.controller;

import jakarta.validation.Valid;
import med.voll.api_medvoll.paciente.DadosCadastroPaciente;
import med.voll.api_medvoll.paciente.Paciente;
import med.voll.api_medvoll.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @GetMapping
    public void olaPacientes() {
        System.out.println("Olá pacientes!");
    }

    @PostMapping("/save")
    @Transactional
    public void save(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }
}
