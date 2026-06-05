package br.com.cassio.sistema.vendas.api.itemvenda;

import br.com.cassio.sistema.vendas.api.produto.Produto;
import br.com.cassio.sistema.vendas.api.produto.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-venda")
public class ItemVendaController {

    private final ItemVendaRepository itemVendaRepository;
    private final ProdutoRepository produtoRepository;

    public ItemVendaController(
            ItemVendaRepository itemVendaRepository,
            ProdutoRepository produtoRepository) {
        this.itemVendaRepository = itemVendaRepository;
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<ItemVenda> listar() {
        return itemVendaRepository.findAll();
    }

    @PostMapping
    public ItemVenda cadastrar(@RequestBody ItemVenda itemVenda) {

        Produto produto = produtoRepository
                .findById(itemVenda.getProduto().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (produto.getQuantidadeEstoque() < itemVenda.getQuantidade()) {
            throw new RuntimeException("Estoque insuficiente");
        }

        itemVenda.setValorUnitario(produto.getPreco());
        itemVenda.setSubTotal(
                itemVenda.getQuantidade() * produto.getPreco()
        );

        produto.setQuantidadeEstoque(
                produto.getQuantidadeEstoque() - itemVenda.getQuantidade()
        );

        produtoRepository.save(produto);

        itemVenda.setProduto(produto);

        return itemVendaRepository.save(itemVenda);
    }
}