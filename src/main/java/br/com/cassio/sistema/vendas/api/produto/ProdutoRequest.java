package br.com.cassio.sistema.vendas.api.produto;

public record ProdutoRequest(
        String nome,
        String descricao,
        Double preco,
        Integer quantidadeEstoque
) {
}