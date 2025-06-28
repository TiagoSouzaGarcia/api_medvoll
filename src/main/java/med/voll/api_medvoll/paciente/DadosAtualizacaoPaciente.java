package med.voll.api_medvoll.paciente;

import jakarta.validation.Valid;
import med.voll.api_medvoll.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(Long id,
                                       String nome,
                                       String telefone,
                                       @Valid DadosEndereco endereco) {
}
