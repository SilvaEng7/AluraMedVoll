package med.voll.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public record DadosCadastroEnderecoDTO (
    @NotBlank
    String logradouro,
    
    @NotBlank   
    String bairro,
    
    @Pattern(regexp = "\\d{8}")
    @NotBlank
    String cep,
    
    @NotBlank
    String cidade,
    
    @NotBlank
    String uf,

    String complemento,
    String numero
){}