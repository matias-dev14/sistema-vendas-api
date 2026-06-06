package br.com.cassio.sistema.vendas.api.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private static final String SECRET = "minha-chave-secreta";

    public String gerarToken(String email) {
        return JWT.create()
                .withSubject(email)
                .sign(Algorithm.HMAC256(SECRET));
    }

    public String validarToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token)
                .getSubject();
    }
}