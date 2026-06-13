package br.com.cassio.sistema.vendas.api.itemvenda;

import br.com.cassio.sistema.vendas.api.produto.Produto;
import br.com.cassio.sistema.vendas.api.venda.Venda;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-venda")
public class ItemVendaController {

    private final ItemVendaService service;

    public ItemVendaController(ItemVendaService service) {
        this.service = service;
    }

    @GetMapping
    public List<ItemVendaResponse> listar() {
        return service.listar()
                .stream()
                .map(ItemVendaResponse::new)
                .toList();
    }

    @PostMapping
    public ItemVendaResponse cadastrar(@RequestBody ItemVendaRequest request) {
        ItemVenda itemVenda = new ItemVenda();

        itemVenda.setQuantidade(request.quantidade());

        Venda venda = request.venda();
        Produto produto = request.produto();

        itemVenda.setVenda(venda);
        itemVenda.setProduto(produto);

        return new ItemVendaResponse(service.cadastrar(itemVenda));
    }
}