# 📚 API de Cursos de Programação

Este projeto é uma API fictícia desenvolvida como parte de um desafio prático. O objetivo é permitir a criação, leitura, atualização e exclusão de cursos, além de alternar o status de um curso entre ativo e inativo.

---

## 🛠️ Tecnologias Utilizadas

- Java
- Spring Boot
- JPA / Hibernate
- Banco de dados (ex: H2, PostgreSQL, MySQL)
- Lombok
- Swagger (opcional)
- Postman ou Insomnia (para testes)

---

## 🚀 Funcionalidades

### ✅ Criar curso

**Rota:** `POST /cursos`

Cria um novo curso com os campos obrigatórios:

```json
{
  "name": "Curso de Java",
  "category": "Backend"
}
```

Campos gerados automaticamente:
- `id` (UUID ou Long)
- `created_at` (data de criação)
- `updated_at` (data da última atualização)
- `active` (padrão: `true`)

---

### 📖 Listar cursos

**Rota:** `GET /cursos`

Retorna todos os cursos cadastrados.

Filtros opcionais por **query params**:

- `name`: filtra pelo nome do curso
- `category`: filtra pela categoria do curso

**Exemplo:**
```
GET /cursos?name=Java&category=Backend
```

---

### ✏️ Atualizar curso

**Rota:** `PUT /cursos/{id}`

Atualiza os campos `name` e/ou `category` de um curso existente.

**Exemplo de body:**
```json
{
  "name": "Curso Avançado de Java"
}
```

📌 Observações:
- O campo `active` é ignorado nessa rota.
- O campo `updated_at` é atualizado automaticamente.

---

### 🗑️ Deletar curso

**Rota:** `DELETE /cursos/{id}`

Remove um curso do banco de dados pelo seu ID.

---

### 🔄 Alterar status do curso (ativo/inativo)

**Rota:** `PATCH /cursos/{id}/active`

Alterna o status do curso entre `ativo` e `inativo` (`true` e `false`).

---

## ✅ Validações

- Os campos `name` e `category` são obrigatórios nas rotas `POST` e `PUT`.
- O campo `active` só pode ser modificado pela rota `PATCH`.

---

## 💡 Anotações Técnicas

- `@CreationTimestamp`: preenche automaticamente o campo `created_at` na criação.
- `@UpdateTimestamp`: atualiza automaticamente o campo `updated_at` em cada atualização.

---

## 🎯 Possíveis Melhorias

- Implementar tratamento global de exceções (ex: curso não encontrado).
- Adicionar testes automatizados.
- Utilizar ENUM para status ativo/inativo.
- Documentar a API com Swagger.

---

## ▶️ Como Executar o Projeto

1. Clone o repositório:
   ```
   git clone https://github.com/seu-usuario/api-cursos.git
   ```

2. Configure o banco de dados (ou utilize o banco H2 em memória)

3. Execute a aplicação:
   ```
   ./mvnw spring-boot:run
   ```

4. Acesse os endpoints com:
   - Postman ou Insomnia   

---

## 👨‍💻 Autor

Desenvolvido como parte de um desafio prático com foco em APIs RESTful usando Spring Boot.
