package med.voll.api_medvoll.controller;

import med.voll.api_medvoll.paciente.DadosCadastroPaciente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @GetMapping
    public void olaPacientes() {
        System.out.println("Olá pacientes!");
    }

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroPaciente dados) {
        System.out.println("dados recebidos: " + dados);
    }
}
