[//]: # (# 🔩 IronCalc API)

[//]: # ()
[//]: # (API RESTful desenvolvida com **Spring Boot**, com autenticação via **JWT**, persistência em **PostgreSQL**, documentação via **Swagger/OpenAPI** e migrações de banco de dados com **Flyway**.)

[//]: # ()
[//]: # (---)

[//]: # ()
[//]: # (## 📋 Índice)

[//]: # ()
[//]: # (- [Tecnologias]&#40;#-tecnologias&#41;)

[//]: # (- [Pré-requisitos]&#40;#-pré-requisitos&#41;)

[//]: # (- [Configuração do Ambiente]&#40;#-configuração-do-ambiente&#41;)

[//]: # (- [Executando a Aplicação]&#40;#-executando-a-aplicação&#41;)

[//]: # (- [Documentação da API]&#40;#-documentação-da-api&#41;)

[//]: # (- [Estrutura do Projeto]&#40;#-estrutura-do-projeto&#41;)

[//]: # ()
[//]: # (---)

[//]: # ()
[//]: # (## 🛠 Tecnologias)

[//]: # ()
[//]: # (| Tecnologia              | Versão     |)

[//]: # (|-------------------------|------------|)

[//]: # (| Java                    | 17         |)

[//]: # (| Spring Boot             | 4.1.1      |)

[//]: # (| Spring Security + JWT   | JJWT 0.12.6|)

[//]: # (| Spring Data JPA         | -          |)

[//]: # (| PostgreSQL              | -          |)

[//]: # (| Flyway                  | -          |)

[//]: # (| Springdoc OpenAPI       | 2.8.13     |)

[//]: # (| Lombok                  | 1.18.46    |)

[//]: # (| Docker / Docker Compose | -          |)

[//]: # ()
[//]: # (---)

[//]: # ()
[//]: # (## ✅ Pré-requisitos)

[//]: # ()
[//]: # (- [Java 17+]&#40;https://adoptium.net/&#41;)

[//]: # (- [Maven 3.8+]&#40;https://maven.apache.org/&#41; ou use o wrapper `./mvnw`)

[//]: # (- [Docker e Docker Compose]&#40;https://www.docker.com/&#41;)

[//]: # ()
[//]: # (---)

[//]: # ()
[//]: # (## ⚙️ Configuração do Ambiente)

[//]: # ()
[//]: # (1. **Clone o repositório:**)

[//]: # ()
[//]: # (```bash)

[//]: # (git clone https://github.com/seu-usuario/api-iron-calc.git)

[//]: # (cd api-iron-calc)

[//]: # (```)

[//]: # ()
[//]: # (2. **Configure as variáveis de ambiente:**)

[//]: # ()
[//]: # (Copie o arquivo de exemplo e preencha com os seus valores:)

[//]: # ()
[//]: # (```bash)

[//]: # (cp .env.example .env)

[//]: # (```)

[//]: # (Edite o arquivo .env com suas configurações &#40;banco de dados, JWT secret, e-mail, etc.&#41;.)

[//]: # ()
[//]: # (---)

[//]: # ()
[//]: # (## ▶️ Executando a Aplicação)

[//]: # (### Com Docker Compose &#40;recomendado&#41;)

[//]: # (Sobe o banco de dados PostgreSQL e a aplicação:)

[//]: # ()
[//]: # (```bash)

[//]: # (docker-compose up -d)

[//]: # (```)

[//]: # ()
[//]: # (### Localmente &#40;sem Docker para a aplicação&#41;)

[//]: # (Suba apenas o banco de dados:)

[//]: # ()
[//]: # (```bash)

[//]: # (docker-compose up -d db)

[//]: # (```)

[//]: # (Em seguida, execute a aplicação:)

[//]: # ()
[//]: # (```bash)

[//]: # (./mvnw spring-boot:run)

[//]: # (```)

[//]: # ()
[//]: # (As migrações do banco de dados são executadas automaticamente pelo Flyway na inicialização.)

[//]: # ()
[//]: # (---)

[//]: # ()
[//]: # (## 📖 Documentação da API)

[//]: # (Com a aplicação em execução, acesse a documentação interativa via Swagger UI:)

[//]: # ()
[//]: # (```bash)

[//]: # (http://localhost:8080/swagger-ui/index.html)

[//]: # (```)

[//]: # (A especificação OpenAPI &#40;JSON&#41; está disponível em:)

[//]: # ()
[//]: # (```bash)

[//]: # (http://localhost:8080/v3/api-docs)

[//]: # (```)

[//]: # ()
[//]: # (Os endpoints de documentação são públicos e não requerem autenticação.)

[//]: # ()
[//]: # (---)

[//]: # ()
[//]: # (## 📁 Estrutura do Projeto)

[//]: # (```bash)

[//]: # (src/)

[//]: # (└── main/)

[//]: # (├── java/com/carvalho/ironcalc/)

[//]: # (│   ├── config/         # Configurações &#40;Security, etc.&#41;)

[//]: # (│   ├── controller/     # Controladores REST)

[//]: # (│   ├── model/          # Entidades JPA)

[//]: # (│   ├── repository/     # Repositórios Spring Data)

[//]: # (│   ├── service/        # Regras de negócio)

[//]: # (│   └── IronCalcApplication.java)

[//]: # (└── resources/)

[//]: # (├── db/migration/       # Scripts Flyway)

[//]: # (└── application.properties)

[//]: # (```)

[//]: # (---)

[//]: # ()
[//]: # (## 🔐 Autenticação)

[//]: # ()
[//]: # (A API utiliza autenticação via **JWT &#40;Bearer Token&#41;**. Para acessar os endpoints protegidos:)

[//]: # ()
[//]: # (1. Realize o login para obter o token. )

[//]: # (2. Inclua o token no header das requisições:)

[//]: # ()
[//]: # (```bash)

[//]: # (Authorization: Bearer <seu-token>)

[//]: # (```)

[//]: # ()

# 🔩IronCalc API

RESTful API developed with **Spring Boot**, with authentication via **JWT**, persistence in **PostgreSQL**, documentation via **Swagger/OpenAPI**, and database migrations with **Flyway**.

---

## 📋 Index

- [Technologies](#-technologies)
- [Prerequisites](#-prerequisites)
- [Environment Configuration](#-environment-configuration)
- [Running the Application](#-running-the-application)
- [API Documentation](#-API-documentation)
- [Project Structure](#-project-structure)

---

## 🛠 Technologies

| Technology            | Version     |
|-----------------------|-------------|
| Java                  | 17          |
| Spring Boot           | 4.1.1       |
| Spring Security + JWT | JJWT 0.12.6 |
| Spring Data JPA       | -           |
| PostgreSQL            | -           |
| Flyway                | -           |
| Springdoc OpenAPI     | 2.8.13      |
| Lombok                | 1.18.46     |
| Docker/Docker Compose | -           |

---

## ✅ Prerequisites

- [Java 17+](https://adoptium.net/)
- [Maven 3.8+](https://maven.apache.org/) or use the `./mvnw` wrapper

- [Docker and Docker Compose](https://www.docker.com/)

---

## ⚙️ Environment Setup

1. **Clone the repository:**

```bash
clone from git https://github.com/your-username/api-iron-calc.git
cd api-iron-calc
```

2. **Configure environment variables:**

Copy the example file and fill it with your values:

```bash
cp .env.example .env
```
Edit the .env file with your settings (database of (Data, JWT Secret, email, etc.).

---

## ▶️ Running the Application
### With Docker Compose (recommended) View the PostgreSQL database and the application:

```bash
docker-compose up -d

```

### Locally (without Docker for the application) Start only the database:

```bash
docker-compose up -d db

```
Then, run an application:

```bash
./mvnw spring-boot:run
```

Database migrations are performed automatically by Flyway at startup.

---

## 📖 API Documentation
With the application running, access the interactive documentation via Swagger UI:

```bash
http://localhost:8080/swagger-ui/index.html
```
The OpenAPI (JSON) design is available at:

```bash
http://localhost:8080/v3/api-docs
```

The documentation endpoints are public and do not require authentication.

---

## 📁 Project Structure
```bash
source/
└── main/
├── java/com/carvalho/ironcalc/
│ ├── config/           # Configurations (Security, etc.)
│ ├── controller/       # REST Controllers
│ ├── model/            # JPA Entities
│ ├── repository/       # Spring Data Repositories
│ ├── service/          # Business Rules
│ └── IronCalcApplication.java
└── resources/
├── db/migration/       # Flyway Scripts
└── application.properties
```
---

## 🔐 Authentication

The API uses authentication via **JWT (Bearer Token)**. To access protected endpoints:

1. Log in to obtain the token.

2. Include the token in the request header:

```bash
Authorization: Bearer <your-token>
```