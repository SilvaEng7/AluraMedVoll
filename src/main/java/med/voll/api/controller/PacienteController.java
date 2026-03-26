package med.voll.api.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
=======
>>>>>>> feature/listar-medico
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import jakarta.validation.Valid;
import med.voll.api.dto.DadosCadastroPacientesDTO;
import med.voll.api.entities.Paciente;
import med.voll.api.interfaces.PacienteRepository;
=======
import med.voll.api.dto.DadosCadastroPacientesDTO;
>>>>>>> feature/listar-medico

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

<<<<<<< HEAD
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarPaciente(@RequestBody @Valid DadosCadastroPacientesDTO dados) {
        repository.save(new Paciente(dados));
=======
    @PostMapping
    public void cadastrarPaciente(@RequestBody DadosCadastroPacientesDTO dados) {
    System.out.println(dados);
>>>>>>> feature/listar-medico
    }

}