package br.com.cassio.sistema.vendas.api.auth;

import br.com.cassio.sistema.vendas.api.security.TokenService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthController(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            TokenService tokenService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public Usuario register(@RequestBody RegisterRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenha(passwordEncoder.encode(request.senha()));

        return usuarioRepository.save(usuario);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request) {
        Usuario usuario = usuarioRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        boolean senhaValida = passwordEncoder.matches(
                request.senha(),
                usuario.getSenha()
        );

        if (!senhaValida) {
            throw new RuntimeException("Senha inválida");
        }

        String token = tokenService.gerarToken(usuario.getEmail());

        return new TokenResponse(token);
    }
}