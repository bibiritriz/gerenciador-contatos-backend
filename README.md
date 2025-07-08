# 📦 Gerenciador de Contatos - Backend

## 📌 Visão Geral

Este repositório contém o código-fonte do **backend** do sistema de gerenciamento de contatos. Desenvolvido com **Java Spring Boot**, ele é responsável por toda a lógica de negócios, persistência de dados e exposição da **API RESTful** que serve o frontend da aplicação.  
O objetivo é fornecer uma base sólida, escalável e fácil de manter para o gerenciamento eficiente de informações de contato.

---

## 🔧 Funcionalidades da API

A API do backend oferece as seguintes funcionalidades principais:

### ✅ Gerenciamento Completo de Contatos
- Operações CRUD: criar, ler, atualizar e deletar contatos.
- Suporte a múltiplas informações:
  - Nome completo
  - Telefones
  - E-mails
  - Endereços
  - Data de nascimento
  - Notas
  - Foto de perfil

### 🗂️ Categorização
- Criação e associação de categorias aos contatos.
- Exemplo de categorias: Família, Trabalho, Amigos, Escola, Outros.

### 🔄 Associação de Dados
- Relacionamento de múltiplos telefones, e-mails e endereços a um único contato.
- Cada entidade (telefone, e-mail, endereço) possui seu próprio controle e validação.

### 🔎 Pesquisa e Filtragem
- Endpoints para buscas por nome, telefone, e-mail, categoria e outras combinações.
- Ideal para uso com filtros dinâmicos no frontend.

---

## 🛠️ Tecnologias Utilizadas

O backend foi desenvolvido com as seguintes tecnologias e bibliotecas:

- **Java 21** — Linguagem principal.
- **Spring Boot 3.5.3** — Framework para aplicações web robustas.
- **Spring Data JPA** — Abstração de persistência com repositórios.
- **Maven** — Gerenciador de dependências e automação de build.
- **H2 Database** — Banco de dados em memória.
- **Lombok** — Geração automática de getters, setters, construtores e builders.
- **SpringDoc OpenAPI UI** — Geração automática de documentação interativa com Swagger.

