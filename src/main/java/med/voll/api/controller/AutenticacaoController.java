package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.usuario.DadosLoginDTO;
import med.voll.api.entities.Usuario;
import med.voll.api.services.TokenService;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    AuthenticationManager manager;

    @Autowired
    TokenService TokenService;

    @PostMapping
    public ResponseEntity logar(@RequestBody @Valid DadosLoginDTO dados){

        var token = new UsernamePasswordAuthenticationToken(dados.username(), dados.senha());

        var authentication = manager.authenticate(token);

        return ResponseEntity.ok(TokenService.gerarToken( (Usuario) authentication.getPrincipal()));

        
    }
    
}