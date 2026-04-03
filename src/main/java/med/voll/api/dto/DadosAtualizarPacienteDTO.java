package med.voll.api.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarPacienteDTO(
    @NotNull
    Long id,

    String nome,
    String telefone,
    DadosCadastroEnderecoDTO endereco
) {}
