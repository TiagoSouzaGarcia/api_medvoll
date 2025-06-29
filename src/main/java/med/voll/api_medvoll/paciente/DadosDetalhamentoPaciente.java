package med.voll.api_medvoll.paciente;

import med.voll.api_medvoll.endereco.Endereco;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String cpf, Endereco endereco) {

    public DadosDetalhamentoPaciente(Paciente paciente) {
    this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getEndereco());
    }

}
