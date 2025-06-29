package med.voll.api_medvoll.controller;

import jakarta.validation.Valid;
import med.voll.api_medvoll.medico.*;
import med.voll.api_medvoll.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping("/save")
    @Transactional
    public ResponseEntity save(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriComponentsBuilder) {
        var medico = new Medico(dados);
        repository.save(medico);

        var uri = uriComponentsBuilder.path("/medicos/save/{id}").buildAndExpand(medico.getId()).toUri();
        var dto = new DadosDetalhamentoMedico(medico);

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<DadosListagemMedico>> list(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosUpdateMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findby-id/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        var dto = new DadosDetalhamentoMedico(medico);
        return ResponseEntity.ok(dto);
    }
}
