# 💰 Wallet API

![Java](https://img.shields.io/badge/Java-8-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.3.4-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)
![Docker](https://img.shields.io/badge/Docker-Enabled-blue)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

API REST para controle de carteira financeira, desenvolvida com **Spring Boot**, **Java 8** e **PostgreSQL**, utilizando boas práticas de arquitetura, segurança e versionamento de banco.

---

## 📘 Trabalho Engineering Software Development

Este trabalho foi desenvolvido com base na construção de um **Test Suite**, com o objetivo de validar o correto funcionamento do microsserviço por meio de testes automatizados.

### 📁 Organização da estrutura de testes
```
src/test/java
 └── com.wallet
     ├── controller
     │   └── UserControllerTest.java
     ├── repository
     │   └── UserRepositoryTest.java
     |   └── WalletItemRepositoryTest      
     └── service
         └── UserServiceTest.java
         └── WalletItemServiceTest.java
```
---

## 📋 Funcionalidades

- ✅ CRUD de usuários
- 🔐 Autenticação e autorização com **JWT**
- 🗄️ Persistência com **Spring Data JPA**
- 🔄 Versionamento de banco com **Flyway**
- ⚡ Cache com **EhCache**
- 📄 Documentação automática com **Swagger**
- 🧪 Testes com **JUnit** e **Mockito**
- 🐳 Execução local via **Docker + Docker Compose**

---

## 🧱 Tecnologias utilizadas

- Java 8
- Spring Boot 2.3.4
- Spring Security
- Spring Data JPA
- PostgreSQL
- Flyway
- Lombok
- Swagger (Springfox)
- EhCache
- Docker & Docker Compose
- Maven

---

## 📂 Estrutura do projeto (simplificada)

```text
root/
├── docker/
│   ├── Dockerfile
│   └── docker-compose.yml
├── src/
├── pom.xml
└── README.md
```

---

## 🚀 Como executar a aplicação (Docker)
### 🔧 Pré-requisitos

Antes de começar, você precisa ter instalado na sua máquina:

- ✅ Docker  
- ✅ Docker Compose  
- ✅ Git  

---

## 1️⃣ Clonar o repositório
```
git clone https://github.com/ThaysonRodrigues/walletAPI.git
cd walletAPI
```

---

## 2️⃣ Acessar a pasta do Docker
```
cd docker
```

---

## 3️⃣ Buildar e subir a aplicação
```
docker compose up -d --build
```

📌 **Esse comando irá:**
- Buildar a aplicação Java via Dockerfile
- Subir o PostgreSQL
- Subir a Wallet API
- Executar as migrations automaticamente com Flyway  

---

## 4️⃣ Verificar containers em execução
```
docker compose ps
```

---

## 🔐 Autenticação
### ➕ Criar usuário

**Endpoint:**
```http
POST /v1/user
{
  "name": "Usuário Teste",
  "email": "user@email.com",
  "password": "123456"
}
```

---

## 🔑 Autenticar e obter token JWT
**Endpoint:**
```http
POST /v1/auth
{
  "email": "user@email.com",
  "password": "123456"
}
```
📌 **O token retornado deve ser enviado no header:**

```http
Authorization: Bearer <seu_token_jwt>
```

---

## 🧪 Executar testes
```
mvn test
```

---

## 🛑 Parar a aplicação
```
docker compose down
```

---

## 🧹 Limpar containers, imagens e volumes (opcional)
```
docker compose down -v --rmi all
```

---

## 📝 Observações importantes
- As credenciais de banco são configuradas via variáveis de ambiente no `docker-compose.yml`
- O Flyway é responsável pela criação e versionamento das tabelas
- A aplicação roda com usuário **não-root** dentro do container (boa prática de segurança)