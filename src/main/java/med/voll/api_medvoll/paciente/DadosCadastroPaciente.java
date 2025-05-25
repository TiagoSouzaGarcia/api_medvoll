package med.voll.api_medvoll.paciente;

import med.voll.api_medvoll.endereco.DadosEndereco;

public record DadosCadastroPaciente(String nome, String email, String telefone, String cpf, DadosEndereco endereco) {
}
