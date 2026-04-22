# SISPRADIA

Sistema de Práticas Diárias - Uma aplicação para gerenciamento de práticas e atividades do dia a dia.

## 🚀 Tecnologias

### Backend
- **Java 8**
- **Spring Boot 2.7.18**
- **Spring Data JPA** - Persistência de dados
- **Spring Validation** - Validação de dados
- **MySQL 8.0.33** - Banco de dados
- **Flyway** - Versionamento de banco de dados
- **Lombok** - Redução de código boilerplate
- **JUnit + Mockito** - Testes unitários

> **📌 Nota sobre versões:**  
> Este projeto utiliza **Java 8** e **Spring Boot 2.7.18** por serem as versões mais utilizadas no mercado brasileiro de desenvolvimento.
> A escolha foi baseada em pesquisa de vagas, onde a maioria das empresas trabalha com Java 8 ou 11.
> 
> **Para ambientes de produção expostos publicamente**, recomenda-se avaliar atualização para versões mais recentes
> (Java 17+ e Spring Boot 3.x) que recebem atualizações de segurança ativas.
> 
> **Para desenvolvimento local e aprendizado**, as versões utilizadas são adequadas e seguras.

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

O projeto segue a arquitetura em camadas (Layered Architecture) para melhor organização e manutenibilidade:

```
sispradia/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── sispradia/
│   │   │       ├── SispradiaApplication.java
│   │   │       ├── api/                    # CAMADA API (Porta de entrada)
│   │   │       │   └── controlador/        # Controllers REST
│   │   │       ├── aplicacao/              # CAMADA APLICAÇÃO (Coordenação)
│   │   │       │   ├── dto/                # Data Transfer Objects
│   │   │       │   ├── conversor/          # Conversores DTO ↔ Entidade
│   │   │       │   └── servico/            # Serviços de aplicação
│   │   │       ├── dominio/                # CAMADA DOMÍNIO (Regras de negócio)
│   │   │       │   ├── modelo/             # Entidades JPA
│   │   │       │   ├── repositorio/        # Repositórios
│   │   │       │   └── servico/            # Serviços de domínio
│   │   │       └── excecao/                # Tratamento de exceções
│   │   └── resources/
│   │       ├── application.properties
│   │       └── db/migration/               # Scripts Flyway
│   └── test/
│       └── java/                           # Testes unitários e integração
├── pom.xml
└── README.md
```

### 📚 Arquitetura em Camadas

O projeto utiliza **separação em camadas** para melhor organização:

- **API**: Recebe requisições HTTP e retorna respostas (Controllers)
- **Aplicação**: Coordena o fluxo, busca dependências e faz conversões (DTOs, Conversores, Serviços de Aplicação)
- **Domínio**: Contém as regras de negócio e lógica central (Entidades, Repositórios, Serviços de Domínio)

Para entender melhor a arquitetura, consulte o arquivo [GUIA_SPRING_BOOT_ARQUITETURA.md](./GUIA_SPRING_BOOT_ARQUITETURA.md).

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

## 👨‍💻 Autor

<div align="center">
  <img src="https://github.com/kauavictorss.png" width="150px" style="border-radius: 50%;" alt="Kauã Victor"/>
  <br>
  <h1>Kauã Victor Silva dos Santos</h1>
  
[![GitHub](https://img.shields.io/badge/-GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/kauavictorss)
[![LinkedIn](https://img.shields.io/badge/-LinkedIn-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/kaua-victor-santos/)
</div>

Desenvolvido com ❤️

---

**Status:** 🚧 Em desenvolvimento
