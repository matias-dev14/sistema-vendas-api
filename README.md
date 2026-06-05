# Sistema de Vendas API

API REST desenvolvida com Java e Spring Boot para gerenciamento de clientes.

## Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven
* Hibernate
* Git
* GitHub

## Funcionalidades

### Clientes

* Cadastrar cliente
* Listar clientes
* Buscar cliente por ID
* Atualizar cliente
* Excluir cliente

## Estrutura do Projeto

```text
src
├── main
│   ├── java
│   │   └── br.com.cassio.sistema.vendas.api
│   └── resources
└── test
```

## Endpoints

### Listar clientes

```http
GET /clientes
```

### Buscar cliente por ID

```http
GET /clientes/{id}
```

### Cadastrar cliente

```http
POST /clientes
```

Exemplo de requisição:

```json
{
  "nome": "Cassio Matias",
  "email": "cassio@email.com",
  "telefone": "81999999999"
}
```

### Atualizar cliente

```http
PUT /clientes/{id}
```

### Excluir cliente

```http
DELETE /clientes/{id}
```

## Banco de Dados

PostgreSQL

Banco utilizado:

```sql
sistema_vendas
```

## Como Executar

### Clonar o projeto

```bash
git clone https://github.com/matias-dev14/sistema-vendas-api.git
```

### Entrar na pasta

```bash
cd sistema-vendas-api
```

### Executar a aplicação

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

A aplicação ficará disponível em:

```text
http://localhost:8080
```

## Próximas Implementações

* CRUD de Produtos
* CRUD de Vendas
* DTOs
* Service Layer
* Tratamento Global de Exceções
* Swagger/OpenAPI
* Autenticação JWT
* Deploy em nuvem

## Autor

Cássio Matias Pereira

GitHub:
https://github.com/matias-dev14
