package med.voll.api.infra;

import org.springframework.validation.FieldError;

 record DadosErro400DTO(
    String campo,
    String mensagem
)
{
    
    protected DadosErro400DTO(FieldError erro){
        this(   
            erro.getField(),
            erro.getDefaultMessage()
        );
    }
}