package br.com.cassio.sistema.vendas.api.venda;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaRepository repository;

    public VendaController(VendaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Venda> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Venda buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Venda cadastrar(@RequestBody Venda venda) {
        venda.setDataVenda(LocalDateTime.now());
        return repository.save(venda);
    }
}