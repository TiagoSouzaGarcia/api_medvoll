package med.voll.api_medvoll.controller;

import jakarta.validation.Valid;
import med.voll.api_medvoll.paciente.*;
import med.voll.api_medvoll.repository.PacienteRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping("/save")
    @Transactional
    public ResponseEntity save(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriComponentsBuilder) {
        var paciente = new Paciente(dados);
        repository.save(paciente);

        var uri = uriComponentsBuilder.path("/pacientes/save/{id}").buildAndExpand(paciente.getId()).toUri();
        var dto = new DadosDetalhamentoPaciente(paciente);

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<DadosListagemPaciente>> list(@PageableDefault(page = 0, size = 10, sort = { "nome" }) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.inativar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findby-id/{id}")
    @Transactional
    public ResponseEntity findById(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        var dto = new DadosDetalhamentoPaciente(paciente);
        return ResponseEntity.ok(dto);
    }
}
