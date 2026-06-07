# Sistema de Vendas API

API REST desenvolvida com Spring Boot para gerenciamento de clientes, produtos, vendas e itens de venda.

## Tecnologias Utilizadas

* Java 21
* Spring Boot 4
* Spring Data JPA
* Spring Security
* JWT (JSON Web Token)
* PostgreSQL
* Swagger/OpenAPI
* Maven
* Lombok

## Funcionalidades

### Clientes

* Cadastrar cliente
* Listar clientes
* Buscar cliente por ID
* Atualizar cliente
* Remover cliente

### Produtos

* Cadastrar produto
* Listar produtos
* Buscar produto por ID
* Atualizar produto
* Remover produto

### Vendas

* Registrar venda
* Consultar vendas

### Itens de Venda

* Adicionar itens à venda
* Cálculo automático de subtotal
* Controle automático de estoque

### Segurança

* Cadastro de usuários
* Login com JWT
* Proteção de endpoints com Spring Security
* Acesso autenticado via Bearer Token

## Arquitetura

O projeto segue arquitetura em camadas:

* Controller
* Service
* Repository
* DTO
* Security
* Exception

## Documentação da API

Após iniciar a aplicação:

http://localhost:8080/swagger-ui/index.html

## Autenticação

### Registrar usuário

POST /auth/register

### Realizar login

POST /auth/login

Exemplo:

```json
{
  "email": "usuario@email.com",
  "senha": "123456"
}
```

Retorno:

```json
{
  "token": "jwt-token"
}
```

## Banco de Dados

PostgreSQL

Configuração em:

```properties
application.properties
```

## Executando o Projeto

Clone o repositório:

```bash
git clone https://github.com/matias-dev14/sistema-vendas-api.git
```

Acesse a pasta:

```bash
cd sistema-vendas-api
```

Execute:

```bash
./mvnw spring-boot:run
```

## Funcionalidades Implementadas

* CRUD de Clientes
* CRUD de Produtos
* CRUD de Vendas
* CRUD de Itens de Venda
* Controle de Estoque
* Tratamento Global de Exceções
* Swagger/OpenAPI
* JWT Authentication
* Spring Security
* Service Layer
* DTOs (Request/Response)

## Próximas Evoluções

* Testes Automatizados (JUnit e MockMvc)
* Docker
* Deploy em Nuvem
* CI/CD
