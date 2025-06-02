package med.voll.api_medvoll.controller;

import jakarta.validation.Valid;
import med.voll.api_medvoll.medico.DadosCadastroMedico;
import med.voll.api_medvoll.medico.DadosListagemMedico;
import med.voll.api_medvoll.medico.Medico;
import med.voll.api_medvoll.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping("/save")
    @Transactional
    public void save(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public List<DadosListagemMedico> list() {
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
    }

}
