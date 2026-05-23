# 🎵 Music Stream API

API REST desenvolvida com Java e Spring Boot para gerenciamento de músicas e playlists.

O projeto permite cadastrar músicas, criar playlists e adicionar/remover músicas das playlists.

---

# 🚀 Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

---

# 📁 Estrutura do Projeto

```bash
src/main/java/br/com/eduD/spring_boot_essentials_music
│
├── controller
├── service
├── dto
├── database
│   ├── model
│   └── repository
├── exception
```

---

# 🎼 Funcionalidades

## Música
- Listar músicas
- Cadastrar música
- Remover música

## Playlist
- Criar playlist
- Listar playlists
- Buscar músicas da playlist
- Adicionar música na playlist
- Remover música da playlist
- Deletar playlist

---

# 🔗 Endpoints

## 🎵 Music Endpoints

### Buscar todas as músicas

```http
GET /v1/musics
```

### Cadastrar música

```http
POST /v1/musics
```

### Remover música

```http
DELETE /v1/musics/{id}
```

---

## 📂 Playlist Endpoints

### Buscar playlists

```http
GET /v1/playlist
```

### Buscar músicas da playlist

```http
GET /v1/playlist/{playlistId}
```

### Criar playlist

```http
POST /v1/playlist
```

### Adicionar música à playlist

```http
POST /v1/playlist/{playlistId}/musics/{musicId}
```

### Remover música da playlist

```http
DELETE /v1/playlist/{playlistId}/musics/{musicId}
```

### Deletar playlist

```http
DELETE /v1/playlist/{playlistId}
```

---

# ⚙️ Como executar o projeto

## 1️⃣ Clonar repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

---

## 2️⃣ Configurar banco PostgreSQL

Crie um banco:

```sql
CREATE DATABASE music_stream;
```

---

## 3️⃣ Configurar application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/music_stream
spring.datasource.username=postgres
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 4️⃣ Rodar aplicação

```bash
./mvnw spring-boot:run
```

Ou execute pela IDE.

---

# 🧠 Conceitos aplicados

- REST API
- DTO Pattern
- Camadas Controller / Service / Repository
- Relacionamento Many-to-Many
- Tratamento de exceções
- Boas práticas com Spring Boot

---

# 📌 Melhorias futuras

- Spring Security + JWT
- Swagger/OpenAPI
- Sistema de favoritos
- Busca de músicas
- Sistema de usuários
- Upload de músicas
- Testes unitários

---

# 👨‍💻 Autor

Desenvolvido por Eduardo Corrêa 🚀
