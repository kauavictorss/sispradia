# 📋 HISTÓRICO DE DESENVOLVIMENTO - SISPRADIA

**Projeto:** Sistema de Práticas Diárias (SISPRADIA)  
**Início:** 21/12/2024  
**Última atualização:** 21/12/2024  

---

## 🎯 OBJETIVO DO PROJETO

Sistema para gerenciamento de práticas e hábitos diários, permitindo que usuários criem, monitorem e acompanhem suas atividades do dia a dia.

---

## 🛠️ TECNOLOGIAS DEFINIDAS

### Backend
- **Java 8** (escolhido por ser a versão mais usada no mercado brasileiro)
- **Spring Boot 2.7.18** (última versão compatível com Java 8)
- **Spring Data JPA** (persistência de dados)
- **Spring Validation** (validação de dados)
- **MySQL 8.0.33** (banco de dados)
- **Flyway** (versionamento de banco de dados)
- **Lombok** (redução de código boilerplate)
- **Maven** (gerenciamento de dependências)

### Arquitetura
- **Arquitetura em Camadas** (Layered Architecture)
- **Separação de responsabilidades:** API → Aplicação → Domínio
- **DTOs** para transferência de dados
- **Conversores** para transformação DTO ↔ Entidade

---

## 📚 ESTRUTURA DO PROJETO

```
src/main/java/sispradia/
├── SispradiaApplication.java
├── api/
│   └── controlador/          # Controllers REST (Porta de entrada HTTP)
│       ├── UsuarioControlador.java ✅
│       └── PraticaControlador.java ✅
├── aplicacao/                # Coordenação e orquestração
│   ├── dto/                  # Data Transfer Objects
│   │   ├── usuario/ ✅
│   │   └── pratica/ ✅
│   ├── conversor/            # Conversores DTO ↔ Entidade
│   │   ├── UsuarioConversor.java ✅
│   │   └── PraticaConversor.java ✅
│   └── servico/              # Serviços de aplicação
│       ├── UsuarioAppServico.java ✅
│       └── PraticaAppServico.java ✅
├── dominio/                  # Coração do sistema (Regras de negócio)
│   ├── modelo/               # Entidades JPA
│   │   ├── Usuario.java ✅
│   │   ├── Pratica.java ✅
│   │   ├── CategoriaPratica.java ✅
│   │   ├── Meta.java ✅
│   │   ├── Periodo.java ✅
│   │   └── RegistroDiario.java ✅
│   ├── repositorio/          # Repositórios (Acesso ao banco)
│   │   ├── UsuarioRepositorio.java ✅
│   │   ├── PraticaRepositorio.java ✅
│   │   ├── CategoriaPraticaRepositorio.java
│   │   ├── MetaRepositorio.java
│   │   └── RegistroDiarioRepositorio.java
│   └── servico/              # Serviços de domínio (Validações)
│       ├── UsuarioServico.java ✅
│       └── PraticaServico.java ✅
└── excecao/                  # Tratamento de exceções (Pendente)
```

---

## ✅ O QUE JÁ FOI IMPLEMENTADO

### 1. **SETUP INICIAL DO PROJETO**
- [x] Projeto Spring Boot criado
- [x] Dependências configuradas (pom.xml)
- [x] Banco de dados MySQL configurado
- [x] Flyway configurado para migrations
- [x] Application.properties configurado

### 2. **ENTIDADES (Modelos de Domínio)**
- [x] Usuario
- [x] Pratica
- [x] CategoriaPratica
- [x] Meta
- [x] Periodo
- [x] RegistroDiario

### 3. **CRUD COMPLETO DE USUÁRIO** ✅

#### **Repositório (UsuarioRepositorio.java)**
- [x] `existsByEmail()` - Verifica se email já existe
- [x] `findByEmail()` - Busca usuário por email
- [x] `findByAtivoTrue()` - Lista usuários ativos
- [x] `findByAtivoFalse()` - Lista usuários inativos
- [x] `findByNomeContainingIgnoreCase()` - Busca por nome (parcial, case-insensitive)

#### **Serviço de Domínio (UsuarioServico.java)**
- [x] `cadastrar()` - Cadastra novo usuário com validação de email único
- [x] `buscarPorId()` - Busca usuário por ID
- [x] `buscarPorEmail()` - Busca usuário por email
- [x] `listarTodos()` - Lista todos os usuários
- [x] `listarAtivos()` - Lista apenas ativos
- [x] `listarInativos()` - Lista apenas inativos
- [x] `buscarPorNome()` - Busca por nome com validação
- [x] `atualizar()` - Atualiza usuário com validação de email único
- [x] `deletar()` - Soft delete (marca como inativo)
- [x] `deletarPermanente()` - Delete físico do banco

#### **DTOs**
- [x] `CadastrarUsuarioDto` - Para cadastro
- [x] `AtualizarUsuarioDto` - Para atualização
- [x] `ListarUsuarioDto` - Para resposta

#### **Conversor (UsuarioConversor.java)**
- [x] `dtoParaEntidade()` - Converte DTO de cadastro para entidade
- [x] `atualizarDtoParaEntidade()` - Converte DTO de atualização para entidade
- [x] `entidadeParaDto()` - Converte entidade para DTO
- [x] `entidadesParaDtos()` - Converte lista de entidades para lista de DTOs

#### **Serviço de Aplicação (UsuarioAppServico.java)**
- [x] `cadastrar()` - Orquestra cadastro
- [x] `buscar()` - Orquestra busca por ID
- [x] `buscarPorEmail()` - Orquestra busca por email
- [x] `listarTodos()` - Orquestra listagem completa
- [x] `listarAtivos()` - Orquestra listagem de ativos
- [x] `listarInativos()` - Orquestra listagem de inativos
- [x] `buscarPorNome()` - Orquestra busca por nome
- [x] `atualizar()` - Orquestra atualização
- [x] `deletar()` - Orquestra deleção

#### **Controlador REST (UsuarioControlador.java)**
- [x] `POST /usuarios` - Cadastrar usuário
- [x] `GET /usuarios` - Listar todos os usuários
- [x] `GET /usuarios/ativos` - Listar apenas ativos
- [x] `GET /usuarios/inativos` - Listar apenas inativos
- [x] `GET /usuarios/buscar?nome=joao` - Buscar por nome
- [x] `GET /usuarios/{id}` - Buscar por ID
- [x] `GET /usuarios/email/{email}` - Buscar por email
- [x] `PUT /usuarios/{id}` - Atualizar usuário
- [x] `DELETE /usuarios/{id}` - Deletar (soft delete)

**Validações implementadas:**
- ✅ Email único (não duplica)
- ✅ Nome obrigatório
- ✅ Email obrigatório e formato válido
- ✅ Senha obrigatória no cadastro, opcional na atualização
- ✅ Soft delete (marca como inativo ao invés de deletar)
- ✅ Busca por nome case-insensitive e parcial

---

### 4. **CRUD PARCIAL DE PRÁTICA** ✅

#### **Repositório (PraticaRepositorio.java)**
- [x] `existsByTituloAndUsuarioId()` - Verifica prática duplicada para usuário

#### **Serviço de Domínio (PraticaServico.java)**
- [x] `cadastrar()` - Cadastra prática com validação de duplicação

#### **DTOs**
- [x] `CadastrarPraticaDto` - Para cadastro
- [x] `ListarPraticaDto` - Para resposta

#### **Conversor (PraticaConversor.java)**
- [x] `dtoParaEntidade()` - Converte DTO para entidade
- [x] `entidadeParaDto()` - Converte entidade para DTO

#### **Serviço de Aplicação (PraticaAppServico.java)**
- [x] `cadastrar()` - Orquestra cadastro com busca de usuário

#### **Controlador REST (PraticaControlador.java)**
- [x] `POST /praticas` - Cadastrar prática

**Validações implementadas:**
- ✅ Título obrigatório
- ✅ Usuário obrigatório (não pode cadastrar prática sem usuário)
- ✅ Não permite prática duplicada para o mesmo usuário
- ✅ Prática sempre começa ativa

---

## 📖 DOCUMENTAÇÃO CRIADA

### Arquivos de Documentação
1. **README.md** ✅
   - Descrição do projeto
   - Tecnologias utilizadas
   - Nota sobre versões (Java 8 e mercado brasileiro)
   - Pré-requisitos
   - Configuração do ambiente
   - Instalação e execução
   - Estrutura do projeto atualizada com arquitetura em camadas

2. **GUIA_SPRING_BOOT_ARQUITETURA.md** ✅
   - Explicação completa da arquitetura em camadas
   - Descrição detalhada de cada componente
   - Exemplos práticos de código
   - Fluxo completo de uma requisição
   - Vocabulário técnico correto
   - Dicas para entrevistas
   - Checklist do que cada camada pode e não pode fazer
   - Exercícios práticos

3. **ENDPOINTS_USUARIO.md** ✅
   - Documentação completa de todos os endpoints de usuário
   - Exemplos de requisição e resposta (JSON)
   - Exemplos com CURL
   - Códigos de status HTTP
   - Validações implementadas
   - Fluxo das camadas visual

4. **HISTORICO_DESENVOLVIMENTO.md** ✅ (este arquivo)
   - Histórico de tudo que foi feito
   - Estado atual do projeto
   - Próximos passos

---

## 🎓 APRENDIZADOS E CORREÇÕES FEITAS

### **Problema 1: Erro na atualização de usuário**
**O que estava errado:**
- AtualizarUsuarioDto não tinha campo ID
- UsuarioServico tentava salvar DTO ao invés de Entidade
- Controller retornava Usuario ao invés de DTO
- Faltava buscar usuário existente antes de atualizar

**Como foi corrigido:**
- Adicionado campo ID no AtualizarUsuarioDto
- Criado método `atualizarDtoParaEntidade()` no conversor
- UsuarioServico agora recebe 2 parâmetros: usuarioAtualizado e usuarioExistente
- Controller agora passa o ID da URL para o DTO
- Validação de email único ao mudar email

### **Problema 2: Erro 400 nos endpoints /ativos e /inativos**
**O que estava errado:**
- Endpoints específicos (`/ativos`, `/inativos`) estavam DEPOIS do endpoint genérico `/{id}`
- Spring tentava interpretar "ativos" como um ID
- Conflito de rotas

**Como foi corrigido:**
- Reorganização dos endpoints no Controller
- Endpoints específicos DEVEM vir ANTES de `/{id}`
- Ordem correta agora:
  1. POST /usuarios
  2. GET /usuarios/ativos
  3. GET /usuarios/inativos
  4. GET /usuarios/buscar
  5. GET /usuarios/email/{email}
  6. GET /usuarios (listar todos)
  7. GET /usuarios/{id} (buscar por ID - ÚLTIMO)

### **Problema 3: Vulnerabilidades no pom.xml**
**O que foi feito:**
- Análise das versões e vulnerabilidades (CVE-2025-41242, CVE-2025-22235)
- Decisão de manter Java 8 + Spring Boot 2.7.18 por alinhamento com mercado brasileiro
- Documentação clara no README sobre a escolha
- Corrigido encoding no application.properties

---

## 🧠 CONCEITOS APLICADOS

### **Arquitetura em Camadas**
- **API (Controlador):** Recebe requisições HTTP, valida entrada, retorna respostas
- **Aplicação (Serviço de Aplicação):** Busca dependências, coordena conversores e serviços
- **Domínio (Serviço de Domínio):** Contém regras de negócio e validações
- **Repositório:** Acessa o banco de dados

### **Padrões Aplicados**
- **DTO (Data Transfer Object):** Transferência de dados sem expor entidades
- **Conversor/Mapper:** Transformação DTO ↔ Entidade
- **Soft Delete:** Inativar ao invés de deletar fisicamente
- **Query Methods:** Métodos de repositório gerados automaticamente pelo Spring Data JPA
- **Bean Validation:** Validações com anotações (@NotBlank, @NotNull, @Email)
- **ResponseEntity:** Respostas HTTP com status codes apropriados

### **Validações Implementadas**
- **Email único:** Não permite emails duplicados
- **Campos obrigatórios:** Nome, email, título, usuarioId
- **Formato válido:** Email com formato válido
- **Regras de negócio:** Não duplicar prática para mesmo usuário
- **Soft delete:** Preserva histórico de dados

---

## 📊 ESTADO ATUAL DO BANCO DE DADOS

### **Tabelas Criadas (via Flyway)**
- `usuario` ✅
- `pratica` ✅
- `categoria_pratica` ✅
- `meta` ✅
- `periodo` ✅
- `registro_diario` ✅

### **Relacionamentos**
- Usuario → Pratica (OneToMany)
- Pratica → Usuario (ManyToOne)
- Pratica → CategoriaPratica (ManyToOne)

---

## 🔜 PRÓXIMOS PASSOS

### **CRUD de Prática - Completar**
- [ ] Listar todas as práticas
- [ ] Listar práticas por usuário
- [ ] Listar práticas ativas
- [ ] Listar práticas inativas
- [ ] Buscar prática por ID
- [ ] Buscar práticas por título
- [ ] Atualizar prática
- [ ] Deletar prática (soft delete)

### **Sistema de Registro Diário**
- [ ] Registrar que fez a prática em um dia
- [ ] Listar registros de um período
- [ ] Calcular estatísticas (streak, total, etc.)
- [ ] Marcar/desmarcar dia como concluído

### **Melhorias e Funcionalidades Adicionais**
- [ ] Tratamento global de exceções
- [ ] Respostas padronizadas (RespostaPadrao<T>)
- [ ] Paginação nas listagens
- [ ] Ordenação (por nome, data de criação, etc.)
- [ ] Endpoint para reativar usuário/prática inativa
- [ ] Endpoint para alterar apenas senha de usuário
- [ ] Autenticação com JWT
- [ ] Documentação Swagger/OpenAPI
- [ ] Testes unitários
- [ ] Testes de integração

### **Frontend (Planejado)**
- [ ] Vue 3
- [ ] BootstrapVue Next
- [ ] Axios
- [ ] Vue Router
- [ ] Pinia (gerenciamento de estado)

---

## 🎯 OBJETIVOS DE APRENDIZADO ALCANÇADOS

### **Arquitetura**
✅ Entendimento da separação em camadas  
✅ Responsabilidade de cada camada  
✅ Fluxo de dados entre camadas  
✅ Diferença entre Serviço de Aplicação e Serviço de Domínio  

### **Spring Boot / Spring Data JPA**
✅ Criação de entidades JPA  
✅ Relacionamentos entre entidades  
✅ Query Methods (findBy, existsBy)  
✅ Busca case-insensitive e parcial  
✅ Soft delete vs Hard delete  

### **DTOs e Conversores**
✅ Por que usar DTOs  
✅ DTOs de entrada vs DTOs de saída  
✅ Criação de conversores  
✅ Conversão de listas  

### **REST API**
✅ Verbos HTTP (GET, POST, PUT, DELETE)  
✅ Path variables vs Query parameters  
✅ Status codes HTTP (200, 201, 204, 400, 404)  
✅ ResponseEntity  
✅ Ordenação correta de endpoints  

### **Validações**
✅ Bean Validation (@NotBlank, @NotNull, @Email)  
✅ Validações de negócio (email único, prática duplicada)  
✅ Validações opcionais (senha na atualização)  

### **Boas Práticas**
✅ Nomenclatura clara e descritiva  
✅ Separação de responsabilidades  
✅ Validações claras com mensagens explicativas  
✅ Documentação completa  
✅ Comentários úteis no código  

---

## 💡 LIÇÕES APRENDIDAS

### **1. Ordem dos Endpoints Importa**
Endpoints específicos (como `/ativos`) devem vir ANTES de endpoints genéricos (como `/{id}`) para evitar conflitos de rota.

### **2. Soft Delete é Melhor para Preservar Histórico**
Ao invés de deletar fisicamente, marcar como inativo preserva o histórico e permite reativação.

### **3. DTOs São Essenciais**
Nunca expor entidades diretamente. DTOs garantem segurança, simplicidade e controle.

### **4. Validações em Múltiplas Camadas**
- **DTO:** Validações de formato (@NotBlank, @Email)
- **Domínio:** Validações de regras de negócio (email único, não duplicar)

### **5. Mensagens de Erro Claras**
Sempre retornar mensagens claras ao usuário quando uma validação falha.

### **6. Escolha de Versões Baseada no Mercado**
Java 8 foi escolhido porque é a versão mais usada no mercado brasileiro, mesmo com vulnerabilidades conhecidas. Para produção, avaliar migração.

---

## 📝 OBSERVAÇÕES IMPORTANTES

### **Sobre Vulnerabilidades (Java 8 + Spring Boot 2.7.18)**
- ✅ **Seguro para desenvolvimento local** - Zero risco
- ⚠️ **Atenção em produção** - Avaliar atualização para versões mais recentes
- ✅ **Alinhado com mercado brasileiro** - Maioria das vagas pede Java 8 ou 11
- ✅ **Documentado no README** - Explicação clara da escolha

### **Sobre Soft Delete**
- Usuario.deletar() marca como inativo (ativo = false)
- Usuario.deletarPermanente() remove do banco (use com cautela!)
- Mesmo padrão deve ser aplicado em Prática

### **Sobre Query Methods**
Padrão de nomenclatura do Spring Data JPA:
- `findBy` + campo → buscar
- `existsBy` + campo → verificar existência
- `countBy` + campo → contar
- `deleteBy` + campo → deletar
- Pode combinar com `And`, `Or`, `Containing`, `IgnoreCase`

---

## 🔗 REFERÊNCIAS E RECURSOS

### **Documentação Oficial**
- Spring Boot 2.7.x: https://docs.spring.io/spring-boot/docs/2.7.x/reference/html/
- Spring Data JPA: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
- Bean Validation: https://beanvalidation.org/2.0/spec/

### **Guias Criados no Projeto**
- GUIA_SPRING_BOOT_ARQUITETURA.md
- ENDPOINTS_USUARIO.md
- README.md

---

## 👥 EQUIPE

**Desenvolvedor:** Kauã Victor  
**Suporte Técnico:** Assistente IA  
**Data de Início:** 21/12/2024  

---

## 📌 VERSÃO

**Versão atual:** 1.0  
**Última atualização:** 21/12/2024 - 15:22  

---

**Status do Projeto:** 🚧 **EM DESENVOLVIMENTO ATIVO**

**Progresso Geral:** ~35% concluído
- ✅ Setup e configuração
- ✅ CRUD de Usuário completo
- 🔄 CRUD de Prática (parcial - só cadastro)
- ⏳ Sistema de Registro Diário
- ⏳ Tratamento de exceções
- ⏳ Autenticação e segurança
- ⏳ Frontend

---

_Este documento deve ser atualizado sempre que novas funcionalidades forem implementadas ou problemas forem resolvidos._
