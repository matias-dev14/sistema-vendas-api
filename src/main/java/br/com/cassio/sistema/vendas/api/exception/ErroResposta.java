package br.com.cassio.sistema.vendas.api.exception;

import java.time.LocalDateTime;

public record ErroResposta(
        LocalDateTime dataHora,
        int status,
        String error,
        String message
        
) {
    
}
