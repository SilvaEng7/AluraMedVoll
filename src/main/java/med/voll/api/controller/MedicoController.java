package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.DadosCadastroMedicoDTO;
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

}     