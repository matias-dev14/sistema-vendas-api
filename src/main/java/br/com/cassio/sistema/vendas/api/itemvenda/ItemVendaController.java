package br.com.cassio.sistema.vendas.api.itemvenda;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-venda")
public class ItemVendaController {

    private final ItemVendaRepository repository;

    public ItemVendaController(ItemVendaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ItemVenda> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ItemVenda cadastrar(@RequestBody ItemVenda itemVenda) {
        itemVenda.setSubTotal(
                itemVenda.getQuantidade() *
                itemVenda.getValorUnitario()
        );

        return repository.save(itemVenda);
    }
}