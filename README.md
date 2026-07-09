# SHD API

#### Sistema de Hábitos Diários

Uma API para acompanhamento e gerenciamento de hábitos e práticas diárias — construída como um projeto de estudo de **manutenção e boas práticas em um stack legado (Java 8 + Spring Boot 2.7.x)**, muito próximo do que se encontra no mercado brasileiro.

> 🔁 Este projeto nasceu como `sispradia-api` e foi renomeado para `shd-api` para refletir melhor seu propósito.

**Status:** 🚧 Em desenvolvimento

---

## 🎯 Objetivo do projeto

Além de construir uma API funcional de hábitos diários, este repositório existe para praticar:

- Manutenção e evolução de um sistema em stack "legado" (Java 8 / Spring Boot 2.7.x), muito comum em vagas Brasil afora
- Fundamentos sólidos de Programação Orientada a Objetos (encapsulamento, polimorfismo, composição, SOLID) aplicados a um domínio real
- Arquitetura em camadas e boas práticas de engenharia que independem da versão do framework

## 🚀 Tecnologias

### Backend

- **Java 8**
- **Spring Boot 2.7.18**
- **Spring Data JPA** — persistência de dados
- **Spring Validation** — validação de dados de entrada
- **MySQL 8.0.33** — banco de dados relacional
- **Flyway** — versionamento e migração de schema
- **Lombok** — redução de boilerplate
- **JUnit 5 + Mockito** — testes unitários e de integração

> **📌 Nota sobre as versões**
> Este projeto usa deliberadamente **Java 8** e **Spring Boot 2.7.x**, por serem as versões mais recorrentes em vagas de backend no mercado brasileiro. A ideia é treinar manutenção de legado com qualidade, não apenas escrever código em uma stack desatualizada.
>
> Uma futura migração para **Java 17+ / Spring Boot 3.x** está no roadmap como exercício documentado à parte (veja [Roadmap](#-roadmap)), e não como pré-requisito para este projeto evoluir.

### Frontend (planejado)

- **Vue 3** — framework progressivo
- **Pinia** — gerenciamento de estado
- **Vue Router** — roteamento
- **Axios** — cliente HTTP

## 📁 Arquitetura

O projeto segue arquitetura em camadas (Layered Architecture):

```
shd-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── shd/
│   │   │       ├── ShdApplication.java
│   │   │       ├── api/                 # Camada API — controllers REST
│   │   │       │   └── controlador/
│   │   │       ├── aplicacao/           # Camada Aplicação — coordenação
│   │   │       │   ├── dto/
│   │   │       │   ├── conversor/
│   │   │       │   └── servico/
│   │   │       ├── dominio/             # Camada Domínio — regras de negócio
│   │   │       │   ├── modelo/
│   │   │       │   ├── repositorio/
│   │   │       │   └── servico/
│   │   │       └── excecao/             # Tratamento de exceções
│   │   └── resources/
│   │       ├── application.properties
│   │       └── db/migration/            # Scripts Flyway
│   └── test/
│       └── java/                        # Testes unitários e de integração
├── pom.xml
└── README.md
```

- **API**: recebe requisições HTTP e retorna respostas (controllers)
- **Aplicação**: coordena o fluxo, faz conversões DTO ↔ entidade
- **Domínio**: contém entidades, repositórios e regras de negócio centrais

## 📋 Pré-requisitos

- JDK 8 ou superior
- Maven 3.6+
- MySQL 8.0+
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

## ⚙️ Configuração do ambiente

### 1. Configurar variáveis de ambiente

Copie o arquivo de exemplo e preencha com suas credenciais locais:

```bash
cp .env.example .env
```

> Nunca commite credenciais reais. `application.properties` deve referenciar variáveis de ambiente, ex: `${DB_USER}`, `${DB_PASSWORD}`.

### 2. Banco de dados

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/shd
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=none
spring.flyway.baseline-on-migrate=true

server.port=8090
```

## 🔧 Instalação e execução

```bash
# Compilar
mvn clean install

# Executar
mvn spring-boot:run

# Ou via wrapper
./mvnw spring-boot:run     # Linux/Mac
mvnw.cmd spring-boot:run   # Windows
```

A aplicação estará disponível em `http://localhost:8090`.

## 🧪 Testes

```bash
# Todos os testes
mvn test

# Com cobertura (Jacoco)
mvn clean test jacoco:report
```

Estratégia de testes adotada:

- **Unitários** — JUnit 5 + Mockito, isolando serviços de domínio
- **Fatiados** — `@WebMvcTest` (controllers) e `@DataJpaTest` (repositórios)
- **Integração** — `@SpringBootTest` com banco real via Testcontainers

## 📝 Documentação da API

Com a aplicação em execução:

- Swagger UI: `http://localhost:8090/swagger-ui.html`

## 🔐 Segurança

Autenticação/autorização via JWT está planejada — ver [Roadmap](#-roadmap).

## 🗺️ Roadmap

- [ ] Modelagem de domínio: `Usuario`, `Habito`, `RegistroDiario`
- [ ] CRUD completo de hábitos
- [ ] Registro e histórico de execução diária
- [ ] Tratamento global de exceções (`@ControllerAdvice`)
- [ ] Documentação via springdoc-openapi
- [ ] Autenticação JWT
- [ ] Pipeline de CI (GitHub Actions) rodando testes a cada push
- [ ] Cobertura de testes com Testcontainers
- [ ] Frontend em Vue 3
- [ ] *(Exercício à parte)* Migração documentada para Java 17+ / Spring Boot 3.x

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças seguindo Conventional Commits (`git commit -m 'feat: adiciona MinhaFeature'`)
4. Push para a branch (`git push origin feature/MinhaFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT.

## 👨‍💻 Autor

<div align="center">
  <img src="https://github.com/kauavictorss.png" width="150px" style="border-radius: 50%;" alt="Kauã Victor"/>
  <br>
  <h1>Kauã Victor Silva dos Santos</h1>
  
[![GitHub](https://img.shields.io/badge/-GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/kauavictorss)
[![LinkedIn](https://img.shields.io/badge/-LinkedIn-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/kaua-victor-santos/)
</div>

Desenvolvido com ❤️