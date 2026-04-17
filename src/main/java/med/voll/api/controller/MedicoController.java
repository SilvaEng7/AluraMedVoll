package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
<<<<<<< HEAD
=======
import org.springframework.http.ResponseEntity;
>>>>>>> developer
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
<<<<<<< HEAD
import med.voll.api.dto.DadosAtualizarMedicoDTO;
import med.voll.api.dto.DadosCadastroMedicoDTO;
import med.voll.api.dto.DadosListagemMedicoDTO;
=======
import med.voll.api.dto.medico.DadosAtualizarMedicoDTO;
import med.voll.api.dto.medico.DadosCadastroMedicoDTO;
import med.voll.api.dto.medico.DadosDetalhamentoMedicoDTO;
import med.voll.api.dto.medico.DadosListagemMedicoDTO;
>>>>>>> developer
import med.voll.api.entities.Medico;
import med.voll.api.interfaces.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @org.springframework.transaction.annotation.Transactional
<<<<<<< HEAD
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicoDTO dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedicoDTO> listar(
        @org.springframework.data.web.PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable).map(DadosListagemMedicoDTO::new);
=======
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedicoDTO dados, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(dados);
        
        repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedicoDTO(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedicoDTO>> listar(
        @org.springframework.data.web.PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemMedicoDTO::new);

        return ResponseEntity.ok(page);
>>>>>>> developer
    }

    @PutMapping
    @org.springframework.transaction.annotation.Transactional
<<<<<<< HEAD
    public void atualizar(@RequestBody @Valid DadosAtualizarMedicoDTO dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizar(dados);
=======
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarMedicoDTO dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizar(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedicoDTO(medico));
>>>>>>> developer
    }

    @DeleteMapping("/{id}")
    @org.springframework.transaction.annotation.Transactional
<<<<<<< HEAD
    public void excluir(@org.springframework.web.bind.annotation.PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.desativar();
=======
    public ResponseEntity excluir(@org.springframework.web.bind.annotation.PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.desativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity consultar(@org.springframework.web.bind.annotation.PathVariable Long id){
        var medico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoMedicoDTO(medico));
>>>>>>> developer
    }
}