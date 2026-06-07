package br.com.cassio.sistema.vendas.api.venda;

import br.com.cassio.sistema.vendas.api.cliente.Cliente;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService service;

    public VendaController(VendaService service) {
        this.service = service;
    }

    @GetMapping
    public List<VendaResponse> listar() {
        return service.listar()
                .stream()
                .map(VendaResponse::new)
                .toList();
    }

    @GetMapping("/{id}")
    public VendaResponse buscarPorId(@PathVariable Long id) {
        return new VendaResponse(service.buscarPorId(id));
    }

    @PostMapping
    public VendaResponse cadastrar(@RequestBody VendaRequest request) {

        Venda venda = new Venda();

        Cliente cliente = request.cliente();
        venda.setCliente(cliente);

        return new VendaResponse(service.cadastrar(venda));
    }
}