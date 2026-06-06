package br.com.cassio.sistema.vendas.api.itemvenda;

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
    public List<ItemVenda> listar() {
        return service.listar();
    }

    @PostMapping
    public ItemVenda cadastrar(@RequestBody ItemVenda itemVenda) {
        return service.cadastrar(itemVenda);
    }
}