package br.com.cassio.sistema.vendas.api.produto;

public record ProdutoResponse(
        Long id,
        String nome,
        String descricao,
        Double preco,
        Integer quantidadeEstoque
) {
    public ProdutoResponse(Produto produto) {
        this(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getQuantidadeEstoque()
        );
    }
}