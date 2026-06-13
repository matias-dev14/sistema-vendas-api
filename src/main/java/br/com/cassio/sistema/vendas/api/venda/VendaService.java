package br.com.cassio.sistema.vendas.api.venda;

import br.com.cassio.sistema.vendas.api.exception.RecursoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VendaService {

    private final VendaRepository repository;

    public VendaService(VendaRepository repository) {
        this.repository = repository;
    }

    public List<Venda> listar() {
        return repository.findAll();
    }

    public Venda buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Venda não encontrada"));
    }

    public Venda cadastrar(Venda venda) {
        venda.setDataVenda(LocalDateTime.now());

        if (venda.getValorTotal() == null) {
            venda.setValorTotal(0.0);
        }

        return repository.save(venda);
    }
}