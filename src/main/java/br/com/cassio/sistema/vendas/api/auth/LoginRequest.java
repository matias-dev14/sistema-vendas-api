package br.com.cassio.sistema.vendas.api.auth;

public record LoginRequest(
        String email,
        String senha
    ) {

}