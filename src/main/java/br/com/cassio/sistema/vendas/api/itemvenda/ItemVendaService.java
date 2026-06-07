package br.com.cassio.sistema.vendas.api.itemvenda;

import br.com.cassio.sistema.vendas.api.exception.RecursoNaoEncontradoException;
import br.com.cassio.sistema.vendas.api.exception.RegraNegocioException;
import br.com.cassio.sistema.vendas.api.produto.Produto;
import br.com.cassio.sistema.vendas.api.produto.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemVendaService {

    private final ItemVendaRepository itemVendaRepository;
    private final ProdutoRepository produtoRepository;

    public ItemVendaService(
            ItemVendaRepository itemVendaRepository,
            ProdutoRepository produtoRepository) {
        this.itemVendaRepository = itemVendaRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<ItemVenda> listar() {
        return itemVendaRepository.findAll();
    }

    public ItemVenda cadastrar(ItemVenda itemVenda) {
        Produto produto = produtoRepository
                .findById(itemVenda.getProduto().getId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado"));

        if (produto.getQuantidadeEstoque() < itemVenda.getQuantidade()) {
            throw new RegraNegocioException("Estoque insuficiente");
        }

        itemVenda.setValorUnitario(produto.getPreco());
        itemVenda.setSubTotal(itemVenda.getQuantidade() * produto.getPreco());

        produto.setQuantidadeEstoque(
                produto.getQuantidadeEstoque() - itemVenda.getQuantidade()
        );

        produtoRepository.save(produto);
        itemVenda.setProduto(produto);

        return itemVendaRepository.save(itemVenda);
    }
}