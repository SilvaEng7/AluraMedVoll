package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.DadosAtualizarMedicoDTO;
import med.voll.api.dto.DadosCadastroMedicoDTO;
import med.voll.api.dto.DadosListagemMedicoDTO;
import med.voll.api.entities.Medico;
import med.voll.api.interfaces.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @org.springframework.transaction.annotation.Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicoDTO dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedicoDTO> listar(
        @org.springframework.data.web.PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        return repository.findAll(pageable).map(DadosListagemMedicoDTO::new);
    }

    @PutMapping
    @org.springframework.transaction.annotation.Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarMedicoDTO dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizar(dados);
    }
}