package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
<<<<<<< HEAD
=======
import org.springframework.http.ResponseEntity;
>>>>>>> developer
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import med.voll.api.dto.paciente.DadosAtualizarPacienteDTO;
import med.voll.api.dto.paciente.DadosCadastroPacientesDTO;
import med.voll.api.dto.paciente.DadosDetalhamentoPacienteDTO;
import med.voll.api.dto.paciente.DadosListagemPacienteDTO;
import med.voll.api.entities.Paciente;
import med.voll.api.interfaces.PacienteRepository;

<<<<<<< HEAD
import jakarta.validation.Valid;
import med.voll.api.dto.DadosAtualizarPacienteDTO;
import med.voll.api.dto.DadosCadastroPacientesDTO;
import med.voll.api.dto.DadosListagemPacienteDTO;
import med.voll.api.entities.Paciente;
import med.voll.api.interfaces.PacienteRepository;
=======
>>>>>>> developer

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
<<<<<<< HEAD
    public void cadastrarPaciente(@RequestBody @Valid DadosCadastroPacientesDTO dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPacienteDTO> listarPacientes(@PageableDefault(size = 10, sort = "nome" ) Pageable page) {
        return repository.findAllByAtivoTrue(page).map(DadosListagemPacienteDTO::new);
=======
    public ResponseEntity cadastrarPaciente(@RequestBody @Valid DadosCadastroPacientesDTO dados, UriComponentsBuilder uriBuilder) {
        var paciente = new Paciente(dados);
        
        repository.save(paciente);

        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPacienteDTO(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPacienteDTO>> listarPacientes(@PageableDefault(size = 10, sort = "nome" ) Pageable pageable) {
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemPacienteDTO::new);

        return ResponseEntity.ok(page);
>>>>>>> developer
    }

    @PutMapping
    @Transactional
<<<<<<< HEAD
    public void atualizar(@RequestBody @Valid DadosAtualizarPacienteDTO dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizar(dados);
=======
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarPacienteDTO dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPacienteDTO(paciente));
>>>>>>> developer
    }

    @DeleteMapping("/{id}")
    @Transactional 
<<<<<<< HEAD
    public void excluir(@PathVariable Long id){
        var paciente =  repository.getReferenceById(id);
        paciente.desativar();
    }  
}
=======
    public ResponseEntity excluir(@PathVariable Long id){
        var paciente =  repository.getReferenceById(id);
        paciente.desativar();

        return ResponseEntity.noContent().build();
    } 

    @GetMapping("/{id}")
    public ResponseEntity consultar(@PathVariable Long id){
        var paciente =  repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPacienteDTO(paciente));
    }  
}
>>>>>>> developer
