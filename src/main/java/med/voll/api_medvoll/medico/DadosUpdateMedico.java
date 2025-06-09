package med.voll.api_medvoll.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api_medvoll.endereco.DadosEndereco;

public record DadosUpdateMedico(
        @NotNull Long id,
        String nome,
        String telefone,
        DadosEndereco endereco)
{}
