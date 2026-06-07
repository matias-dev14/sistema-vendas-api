package br.com.cassio.sistema.vendas.api.cliente;

public record ClienteRequest(
        String nome,
        String email,
        String telefone
) {

}
