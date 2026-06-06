package br.com.cassio.sistema.vendas.api.auth;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")  
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senha;
}
