package br.com.cassio.sistema.vendas.api.venda;

import br.com.cassio.sistema.vendas.api.cliente.Cliente;

public record VendaRequest(
        Cliente cliente
) {
}