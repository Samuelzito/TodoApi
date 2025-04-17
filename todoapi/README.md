# ✅ TodoAPI – API REST de Tarefas com Spring Boot

Esta é uma API REST para gerenciamento de tarefas (ToDo List), desenvolvida com Java e Spring Boot. A aplicação permite cadastrar, listar, atualizar e remover tarefas, com suporte a filtros por status e data limite. Inclui tratamento global de exceções e segue arquitetura em camadas.

---

## 🚀 Funcionalidades

- ✅ Criar nova tarefa
- ✅ Listar todas as tarefas
- ✅ Buscar tarefa por ID
- ✅ Atualizar tarefa
- ✅ Remover tarefa
- ✅ Filtrar tarefas por status
- ✅ Filtrar tarefas por data limite
- ✅ Tratamento global de exceções (com mensagens amigáveis)

---

## 🛠️ Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Lombok
- Banco H2 (em memória)
- Maven

---

## ▶️ Como executar o projeto

### Pré-requisitos:
- Java 17+
- Maven

### Passos:

1. Clone o repositório:
```bash
git clone https://github.com/Samuelzito/todoapi.git
Navegue até a pasta do projeto:

bash
Copiar
Editar
cd todoapi
Compile e execute:

bash
Copiar
Editar
./mvnw spring-boot:run
Acesse via Postman ou outra ferramenta de API:

bash
Copiar
Editar
http://localhost:8080/tasks
📬 Endpoints disponíveis
➕ Criar tarefa
POST /tasks

json
Copiar
Editar
{
  "titulo": "Estudar Spring Boot",
  "descricao": "Praticar APIs REST com Java",
  "dataLimite": "2025-04-30"
}
📥 Listar todas as tarefas
GET /tasks

🔍 Buscar tarefa por ID
GET /tasks/{id}

🎯 Filtrar tarefas por status
GET /tasks/status?status=PENDENTE

🗓️ Filtrar tarefas por data limite
GET /tasks/data?data=2025-04-30

♻️ Atualizar tarefa
PUT /tasks/{id}

json
Copiar
Editar
{
  "id": 1,
  "titulo": "Tarefa atualizada",
  "descricao": "Conteúdo atualizado com sucesso",
  "dataLimite": "2025-05-05",
  "status": "PENDENTE"
}
❌ Remover tarefa
DELETE /tasks/{id}

⚠️ Tratamento de erros
A API possui um manipulador global de exceções que retorna mensagens personalizadas e padronizadas.

Exemplo:
json
Copiar
Editar
{
  "message": "Tarefa com ID 99 não encontrada.",
  "status": 404,
  "timestamp": "2025-04-17T21:30:05"
}
🧠 Autor
Feito com 💙 por Samuel Moraes