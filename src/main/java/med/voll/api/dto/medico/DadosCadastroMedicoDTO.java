package med.voll.api.dto.medico;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.dto.endereco.DadosCadastroEnderecoDTO;
import med.voll.api.enums.Especialidade;

public record DadosCadastroMedicoDTO (

    
    @NotBlank
    String nome,
    
    @NotBlank
    @Email
    String email,
    
    @NotBlank
    String telefone,

    @NotNull
    Especialidade especialidade,
    
    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    String crm,
    
    @NotNull
    @Valid
    DadosCadastroEnderecoDTO endereco
 
){}
