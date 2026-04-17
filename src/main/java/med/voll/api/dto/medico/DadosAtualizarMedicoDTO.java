package med.voll.api.dto.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.endereco.DadosCadastroEnderecoDTO;

public record DadosAtualizarMedicoDTO(
    @NotNull
    Long id,
    
    String nome,
    String telefone,
    DadosCadastroEnderecoDTO endereco
) {}    
