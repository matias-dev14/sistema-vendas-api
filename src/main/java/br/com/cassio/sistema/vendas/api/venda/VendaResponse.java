package br.com.cassio.sistema.vendas.api.venda;

import java.time.LocalDateTime;

public record VendaResponse(
        Long id,
        LocalDateTime dataVenda,
        Double valorTotal,
        Long clienteId,
        String clienteNome
) {
    public VendaResponse(Venda venda) {
        this(
                venda.getId(),
                venda.getDataVenda(),
                venda.getValorTotal(),
                venda.getCliente() != null ? venda.getCliente().getId() : null,
                venda.getCliente() != null ? venda.getCliente().getNome() : null
        );
    }
}