# Calculadora de Materiais para Obra Residencial

Projeto em Java + Spring Boot para atender a atividade avaliativa de Desenvolvimento de Sistemas.

## Funcionalidades
- Cálculo do volume de concreto para vigas baldrame
- Cálculo da quantidade de tijolos
- Cálculo de orçamento completo (cimento, areia, brita e tijolos) com persistência em banco de dados
- Telas em Jakarta Faces (JSF) para solicitação e busca de orçamentos
- API REST organizada em camadas
- Teste automatizado básico

## Tecnologias
- Java 17
- Spring Boot
- Spring Web
- Spring Validation
- Spring Data JPA
- H2 Database
- Jakarta Faces (JSF) via JoinFaces
- Maven


A aplicação sobe em:
- API: `http://localhost:8080`
- Swagger: http://localhost:8080/swagger-ui/index.html

### Telas JSF
- Solicitação de orçamento: http://localhost:8080/orcamento.xhtml
- Busca de orçamento: http://localhost:8080/busca.xhtml


## Endpoints
### 1) Calcular volume de concreto
`POST /api/materiais/concreto`

### 2) Calcular quantidade de tijolos
`POST /api/materiais/tijolos`

### 3) Criar orçamento
`POST /api/orcamentos`

### 4) Listar todos os orçamentos
`GET /api/orcamentos`

### 5) Buscar orçamento por número
`GET /api/orcamentos/numero/{numero}`

### 6) Buscar orçamentos por nome do cliente
`GET /api/orcamentos/usuario?nome={nome}`