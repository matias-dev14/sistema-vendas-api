package br.com.cassio.sistema.vendas.api.itemvenda;

public record ItemVendaResponse(
        Long id,
        Integer quantidade,
        Double valorUnitario,
        Double subTotal,
        Long produtoId,
        String produtoNome
) {
    public ItemVendaResponse(ItemVenda itemVenda) {
        this(
                itemVenda.getId(),
                itemVenda.getQuantidade(),
                itemVenda.getValorUnitario(),
                itemVenda.getSubTotal(),
                itemVenda.getProduto() != null ? itemVenda.getProduto().getId() : null,
                itemVenda.getProduto() != null ? itemVenda.getProduto().getNome() : null
        );
    }
}