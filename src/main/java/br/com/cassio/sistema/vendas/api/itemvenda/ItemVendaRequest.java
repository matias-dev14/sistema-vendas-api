package br.com.cassio.sistema.vendas.api.itemvenda;

import br.com.cassio.sistema.vendas.api.produto.Produto;
import br.com.cassio.sistema.vendas.api.venda.Venda;

public record ItemVendaRequest(
        Integer quantidade,
        Venda venda,
        Produto produto
) {
}