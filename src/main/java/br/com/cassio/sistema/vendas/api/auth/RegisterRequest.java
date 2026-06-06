package br.com.cassio.sistema.vendas.api.auth;

public record RegisterRequest(
        String nome,
        String email,
        String senha
    ) {

}
