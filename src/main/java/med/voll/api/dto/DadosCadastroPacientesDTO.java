package med.voll.api.dto;

<<<<<<< HEAD
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



public record DadosCadastroPacientesDTO(
    @NotBlank
    String nome,

    @NotBlank
    @Email
    String email,

    @NotBlank
    String telefone,

    @NotBlank
    String cpf,

    @NotNull
    @Valid
    DadosCadastroEnderecoDTO endereco	
=======
public record DadosCadastroPacientesDTO(

String nome,
String email,
String telefone,
String cpf,
DadosCadastroEnderecoDTO endereco	
>>>>>>> feature/listar-medico

){}