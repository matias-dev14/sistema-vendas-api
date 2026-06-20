# Sistema de Vendas API

API REST desenvolvida com Java e Spring Boot para gerenciamento de clientes, produtos e vendas.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 4
- Spring Data JPA
- Spring Security
- JWT
- PostgreSQL
- Docker
- Docker Compose
- Swagger / OpenAPI
- JUnit 5
- GitHub Actions
- Render

## API Online

https://sistema-vendas-api-1.onrender.com

## Documentação Swagger

https://sistema-vendas-api-1.onrender.com/swagger-ui/index.html

## Funcionalidades

### Clientes

- Cadastrar cliente
- Buscar cliente por ID
- Atualizar cliente
- Remover cliente
- Listar clientes

### Produtos

- Cadastrar produto
- Buscar produto por ID
- Atualizar produto
- Remover produto
- Listar produtos

### Vendas

- Registrar venda
- Consultar vendas
- Gerenciar itens da venda

## Arquitetura

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
PostgreSQL
```

## Executar Localmente

### Clonar repositório

```bash
git clone https://github.com/matias-dev14/sistema-vendas-api.git
cd sistema-vendas-api
```

### Executar com Maven

```bash
./mvnw spring-boot:run
```

ou no Windows:

```bash
mvnw.cmd spring-boot:run
```

## Executar com Docker

```bash
docker compose up --build
```

## Executar Testes

```bash
./mvnw test
```

## Integração Contínua

O projeto utiliza GitHub Actions para:

- Build automático
- Execução de testes
- Validação de Pull Requests

## Segurança

- Autenticação JWT
- Spring Security
- Controle de acesso por token

## Deploy

Aplicação publicada no Render:

https://sistema-vendas-api-1.onrender.com

## Autor

Cássio Matias Pereira

GitHub:
https://github.com/matias-dev14

LinkedIn:
https://github.com/matias-dev14