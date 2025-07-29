# Simple Product Management API

Uma aplicação Spring Boot simples para gerenciamento de produtos, utilizando banco de dados H2 em memória e operações CRUD básicas através de endpoints REST.

## 📋 Sobre o Projeto

Esta é uma API REST que permite criar e consultar produtos através de métodos HTTP POST e GET. A aplicação foi desenvolvida com Spring Boot e utiliza JPA/Hibernate para persistência de dados no banco H2.

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 Database** (banco em memória)
- **Maven** (gerenciamento de dependências)
- **Lombok** (redução de código boilerplate)

## 📁 Estrutura do Projeto

```
src/
├── main/
│   └── java/
│       └── br/com/vitech/simpleapp/
│           ├── controllers/
│           │   └── ProductController.java
│           ├── model/
│           │   ├── dtos/
│           │   │   └── ProductReceivedDTO.java
│           │   └── entities/
│           │       └── Product.java
│           ├── repositories/
│           │   └── ProductRepository.java
│           └── services/
│               ├── IProductService.java
│               └── ProductService.java
```

## 🚀 Como Executar

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6+

### Passos para execução

1. **Clone o repositório:**
```bash
git clone <url-do-repositorio>
cd simple-app
```

2. **Execute a aplicação:**
```bash
mvn spring-boot:run
```

3. **A aplicação estará disponível em:**
```
http://localhost:8080
```

## 📊 Banco de Dados H2

O banco H2 está configurado para rodar em memória. Para acessar o console web do H2:

- **URL:** http://localhost:8080/h2-console
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** *(deixe em branco)*

## 🔗 Endpoints da API

### Criar Produto
- **URL:** `POST /products`
- **Content-Type:** `application/json`
- **Body:**
```json
{
    "name": "Produto Exemplo",
    "price": 29.99,
    "quantity": 100
}
```
- **Resposta:** `201 Created`
```json
{
    "id": 1,
    "name": "Produto Exemplo", 
    "price": 29.99,
    "quantity": 100
}
```

### Buscar Produto por ID
- **URL:** `GET /products/{id}`
- **Resposta:** `200 OK`
```json
{
    "id": 1,
    "name": "Produto Exemplo",
    "price": 29.99,
    "quantity": 100
}
```

## 📝 Exemplos de Uso

### Usando cURL

**Criar um produto:**
```bash
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Notebook",
    "price": 2500.00,
    "quantity": 10
  }'
```

**Buscar um produto:**
```bash
curl -X GET http://localhost:8080/products/1
```

### Usando Postman

1. **POST** para `http://localhost:8080/products`
   - Headers: `Content-Type: application/json`
   - Body (raw JSON):
   ```json
   {
     "name": "Mouse Gamer",
     "price": 150.00,
     "quantity": 25
   }
   ```

2. **GET** para `http://localhost:8080/products/1`

## ⚙️ Configurações

### Dependências necessárias no `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

### Configuração do `application.properties`:

```properties
# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# H2 Console (para desenvolvimento)
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## 🏗️ Arquitetura

A aplicação segue uma arquitetura em camadas:

- **Controller Layer:** Responsável por receber as requisições HTTP e retornar as respostas
- **Service Layer:** Contém a lógica de negócio da aplicação
- **Repository Layer:** Responsável pela persistência e acesso aos dados
- **Model Layer:** Define as entidades e DTOs utilizados na aplicação

## 🔧 Possíveis Melhorias

- Implementar operações UPDATE e DELETE
- Adicionar validações nos campos de entrada
- Implementar tratamento de exceções personalizado
- Adicionar paginação na listagem de produtos
- Implementar testes unitários e de integração
- Adicionar documentação da API com Swagger/OpenAPI

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

---

**Desenvolvido por:** Vitech  
**Versão:** 1.0.0
