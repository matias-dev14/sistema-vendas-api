package br.com.cassio.sistema.vendas.api.itemvenda;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemVendaRepository extends
        JpaRepository<ItemVenda, Long> {

}
