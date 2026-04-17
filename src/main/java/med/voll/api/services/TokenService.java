package med.voll.api.services;


import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import med.voll.api.entities.Usuario;


@Service
public class TokenService{
    
    @Value("${api.securuty.tokenJWT.segredo}")
    private  String segredo;

    public String gerarToken(Usuario usuario){
        try {
            
            Algorithm  algorithm = Algorithm.HMAC256(segredo.trim());

            

                return  JWT.create()
                    .withIssuer("API voll.med")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(Expiracao())
                    .sign(algorithm);

                
        }catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token", exception);
        }

       

    }

    private Instant Expiracao(){

    return OffsetDateTime.now(ZoneId.of("America/Sao_Paulo"))
                     .plusHours(2)
                     .toInstant();
    }


    public String getSubject(String tokenJwt){

        try {
            Algorithm  algorithm = Algorithm.HMAC256(segredo);
            return   JWT.require(algorithm)
                .withIssuer("API voll.med")
                .build()
                .verify(tokenJwt)
                .getSubject();
                
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT inválido ou expirado", exception);
        }
    }
    
}