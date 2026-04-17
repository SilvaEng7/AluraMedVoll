package med.voll.api.infra.exceptions.dto;

import org.springframework.validation.FieldError;

 public record DadosErro400DTO(
    String campo,
    String mensagem
)
{
    
    public DadosErro400DTO(FieldError erro){
        this(   
            erro.getField(),
            erro.getDefaultMessage()
        );
    }
}