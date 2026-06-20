package br.com.cassio.sistema.vendas.api.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveBloquearAcessoSemToken() throws Exception {
        mockMvc.perform(get("/clientes"))
                .andExpect(status().isForbidden());
    }

    @Test
    void deveCadastrarUsuario() throws Exception {
        String email = "usuario." + UUID.randomUUID() + "@email.com";

        String json = """
                {
                  "nome": "Usuario Teste",
                  "email": "%s",
                  "senha": "123456"
                }
                """.formatted(email);

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    void deveRealizarLogin() throws Exception {
        String email = "login." + UUID.randomUUID() + "@email.com";

        String cadastroJson = """
                {
                  "nome": "Usuario Login",
                  "email": "%s",
                  "senha": "123456"
                }
                """.formatted(email);

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(cadastroJson))
                .andExpect(status().isOk());

        String loginJson = """
                {
                  "email": "%s",
                  "senha": "123456"
                }
                """.formatted(email);

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginJson))
                .andExpect(status().isOk());
    }
}