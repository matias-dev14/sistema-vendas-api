package br.com.cassio.sistema.vendas.api.cliente;

public record ClienteResponse(
        Long id,
        String nome,
        String email,
        String telefone
) {
   public ClienteResponse(Cliente cliente) {
        this(cliente.getId(),
         cliente.getNome(), cliente.getEmail(),
          cliente.getTelefone()
        );
    }
    
}
