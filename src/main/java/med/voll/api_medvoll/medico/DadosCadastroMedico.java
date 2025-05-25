package med.voll.api_medvoll.medico;

import med.voll.api_medvoll.endereco.DadosEndereco;

//Implementado definitivamente na versão 16 records são um recurso que permite criar uma classe imutável, contendo apenas atributos, construtor e métodos de leitura. É util para criar classes DTO, já que seu objetivo é apenas representar dados que serão recebidos ou devolvidos pela API, sem nenhum comportamento.
public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
}
