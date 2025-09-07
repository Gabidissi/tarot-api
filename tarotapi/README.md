# TarotAPI

Uma API simples para gerenciar jogos de Tarot e leituras ou compreensão de cartas individuais.  
O baralho contém todas as **78 cartas** (22 Arcanos Maiores + 56 Menores).

---

## Como rodar o projeto

1. Baixe ou clone este repositório.
3. Execute a classe principal `TarotapiApplication.java`.
4. A API estará disponível em: http://localhost:8080/api 

---

## Endpoints

| Método | Endpoint | Descrição |
|--------|---------|-----------|
| GET    | /cartas | Lista todas as cartas do Tarot |
| GET    | /cartas/{id} | Busca uma carta pelo ID |
| GET    | /jogos | Lista todos os jogos criados |
| GET    | /jogos/{id} | Busca um jogo pelo ID |
| POST   | /jogos | Cria um novo jogo |
| PUT    | /jogos/{id} | Atualiza um jogo existente |
| DELETE | /jogos/{id} | Remove um jogo pelo ID |

### Cartas

#### **GET /api/cartas**
Lista todas as cartas do Tarot.

Exemplo:
```http
GET http://localhost:8080/api/cartas  
```

Resposta:
```
[
  {
    "id": 1,
    "nome": "O Louco",
    "arcano": "Maior",
    "significado": "Novos começos, liberdade, espontaneidade"
  },
  {
    "id": 2,
    "nome": "O Mago",
    "arcano": "Maior",
    "significado": "Criatividade, iniciativa, poder pessoal"
  }
]
```

#### GET /api/cartas/{id}

Busca uma carta pelo ID.

Exemplo:
```
GET http://localhost:8080/api/cartas/1
```
Resposta:
```
{
  "id": 1,
  "nome": "O Louco",
  "arcano": "Maior",
  "significado": "Novos começos, liberdade, espontaneidade"
}
```
---
### Jogos

#### GET /api/jogos

Lista todos os jogos já criados.


Exemplo:
```
GET http://localhost:8080/api/jogos
```
Resposta:
```
[
  {
    "id": 1,
    "nome": "Leitura do Dia",
    "cartas": [
      { "id": 1, "posicao": "Presente" },
      { "id": 13, "posicao": "Desafio" },
      { "id": 22, "posicao": "Conselho" }
    ]
  }
]
```

#### GET /api/jogos/{id}

Busca um jogo pelo ID.

Exemplo:

```
GET http://localhost:8080/api/jogos/1
```
Resposta: 
```
{
  "id": 1,
  "nome": "Leitura do Dia",
  "cartas": [
    { "id": 1, "posicao": "Presente" },
    { "id": 13, "posicao": "Desafio" },
    { "id": 22, "posicao": "Conselho" }
  ]
}
```

#### POST /api/jogos
Cria um novo jogo.

Exemplo:
```
POST http://localhost:8080/api/jogos
Content-Type: application/json

{
  "nome": "Tiragem Passado-Presente-Futuro",
  "cartas": [
    { "id": 10, "posicao": "Passado" },
    { "id": 20, "posicao": "Presente" },
    { "id": 30, "posicao": "Futuro" }
  ]
}
```
Resposta:
```
{
  "id": 2,
  "nome": "Tiragem Passado-Presente-Futuro",
  "cartas": [
    { "id": 10, "posicao": "Passado" },
    { "id": 20, "posicao": "Presente" },
    { "id": 30, "posicao": "Futuro" }
  ]
}
```

#### PUT /api/jogos/{id}

Atualiza um jogo existente.

Exemplo:
```
PUT http://localhost:8080/api/jogos/2
Content-Type: application/json

{
  "nome": "Tiragem Ampliada",
  "cartas": [
    { "id": 15, "posicao": "Passado" },
    { "id": 25, "posicao": "Presente" },
    { "id": 35, "posicao": "Futuro" }
  ]
}
```
Resposta:

```
{
  "id": 2,
  "nome": "Tiragem Ampliada",
  "cartas": [
    { "id": 15, "posicao": "Passado" },
    { "id": 25, "posicao": "Presente" },
    { "id": 35, "posicao": "Futuro" }
  ]
}
```

#### DELETE /api/jogos/{id}
Exemplo:
```
DELETE http://localhost:8080/api/jogos/2
```
Resposta:
```
"Jogo removido com sucesso"
```
---
## Status Codes

**200 OK →** Sucesso nas requisições.

**201 Created →** Novo jogo criado com sucesso.

**400 Bad Request →** Erro de validação (faltou nome ou cartas).

**404 Not Found →** Carta ou jogo não encontrado.

---
## Campos Obrigatórios
### Jogos
Para criar ou atualizar um jogo (POST ou PUT), os seguintes campos são obrigatórios:

**nome →** obrigatório, tipo String, não pode ser vazio.

**cartas →** obrigatório, tipo Array, deve ter pelo menos 1 carta.

Cada item dentro de cartas deve ter:

**id →** obrigatório, tipo Integer, deve corresponder a uma carta existente.

**posicao →** obrigatório, tipo String, não pode ser vazio.

#### Exemplo Válido:
```
{
  "nome": "Leitura do Dia",
  "cartas": [
    { "id": 1, "posicao": "Presente" },
    { "id": 13, "posicao": "Desafio" },
    { "id": 22, "posicao": "Conselho" }
  ]
}
```

#### Exemplos Inválidos:

- Sem nome:
```
{
  "cartas": [
    { "id": 1, "posicao": "Presente" }
  ]
}
```
Retorna 400 Bad Request.

- Sem Cartas:
```
{
  "nome": "Tiragem Vazia",
  "cartas": []
}

```
Retorna 400 Bad Request.

- Carta sem posição:
```
{
  "nome": "Leitura Incompleta",
  "cartas": [
    { "id": 10 }
  ]
}
```
Retorna 400 Bad Request.


---

_Obrigada por usar a TarotAPI. Feito por Ana G Fraiz RU:4877350_