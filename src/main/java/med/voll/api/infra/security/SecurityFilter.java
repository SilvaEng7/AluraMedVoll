package med.voll.api.infra.security;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.voll.api.interfaces.UsuarioRepository;
import med.voll.api.services.TokenService;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)         
            throws IOException, ServletException{
                
                var tokenJwt = recuperarToken(request).trim();

               if (tokenJwt != null){
                 var subject = tokenService.getSubject(tokenJwt);

                 var usuario = repository.findByUsername(subject);

                 var authentication = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());

                 SecurityContextHolder.getContext().setAuthentication(authentication);
                 
            }
              

            filterChain.doFilter(request, response);
        }


    private String recuperarToken(HttpServletRequest request){

       var authorizationHeader =  request.getHeader("Authorization");
    
        if(authorizationHeader != null){
            return authorizationHeader.substring(7);
        }
       
       return null;
    }
    
    
       
}

