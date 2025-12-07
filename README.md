# SISPRADIA

Sistema de Práticas Diárias - Uma aplicação para gerenciamento de práticas e atividades do dia a dia.

## 🚀 Tecnologias

### Backend
- **Java 8**
- **Spring Boot 2.7.18**
- **Spring Data JPA** - Persistência de dados
- **Spring Validation** - Validação de dados
- **MySQL 8** - Banco de dados
- **Flyway** - Versionamento de banco de dados
- **Lombok** - Redução de código boilerplate
- **JUnit + Mockito** - Testes unitários

## 📋 Pré-requisitos

- JDK 8 ou superior
- Maven 3.6+
- MySQL 8.0+
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

## ⚙️ Configuração do Ambiente

### 1. Configurar MySQL no PATH (Windows)

```powershell
$env:Path += ";C:\Program Files\MySQL\MySQL Server 8.0\bin"
```

### 2. Configurar application.properties

Edite o arquivo `src/main/resources/application.properties` com suas credenciais:

```properties
# Conexão com o banco de dados
spring.datasource.url=jdbc:mysql://localhost:3306/sispradia
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=none

# Mostrar SQL no console
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Flyway funcionar em banco de dados existente
spring.flyway.baseline-on-migrate=true

# Porta do servidor
server.port=8090
```

## 🔧 Instalação e Execução

### Compilar o projeto

```bash
mvn clean install
```

### Executar a aplicação

```bash
mvn spring-boot:run
```

Ou via wrapper:

```bash
./mvnw spring-boot:run     # Linux/Mac
mvnw.cmd spring-boot:run   # Windows
```

A aplicação estará disponível em: `http://localhost:8090`

## 🎨 Frontend

O frontend será desenvolvido com **Vue 3** e estará em uma porta separada

### Tecnologias Frontend
- **Vue 3** - Framework progressivo
- **BootstrapVue Next** - Componentes UI
- **Axios** - Cliente HTTP
- **Vue Router** - Roteamento
- **Pinia** - Gerenciamento de estado

## 🧪 Testes

### Executar todos os testes

```bash
mvn test
```

### Executar com cobertura

```bash
mvn clean test jacoco:report
```

## 📁 Estrutura do Projeto

```
sispradia/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── sispradia/api/
│   │   │       ├── config/          # Configurações
│   │   │       ├── controller/      # Controllers REST
│   │   │       ├── model/           # Entidades JPA
│   │   │       ├── repository/      # Repositórios
│   │   │       ├── service/         # Lógica de negócio
│   │   │       ├── dto/             # Data Transfer Objects
│   │   │       └── exception/       # Tratamento de exceções
│   │   └── resources/
│   │       ├── application.properties
│   │       └── db/migration/        # Scripts Flyway
│   └── test/
│       └── java/                    # Testes unitários e integração
├── pom.xml
└── README.md
```

## 🔐 Segurança

O projeto está preparado para implementação de segurança com JWT (JSON Web Token). A configuração de segurança será adicionada em breve.

## 📝 API Documentation

Após a execução, a documentação da API estará disponível em:
- Swagger UI: `http://localhost:8090/swagger-ui.html` (quando configurado)

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças (`git commit -m 'Adiciona MinhaFeature'`)
4. Push para a branch (`git push origin feature/MinhaFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT.

## 👥 Autores

**Kauã Victor** - Equipe SISPRADIA

Desenvolvido com ❤️

---

**Status:** 🚧 Em desenvolvimento
