CREATE TABLE usuario (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(50) NOT NULL,
    data_criacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ativo TINYINT NOT NULL DEFAULT 1
);

CREATE TABLE categoria_habito (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255)
);

CREATE TABLE habito (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    criado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ativo TINYINT NOT NULL DEFAULT 1,
    usuario_id BIGINT NOT NULL,
    categoria_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (categoria_id) REFERENCES categoria_habito(id)
);

CREATE TABLE meta (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    quantidade_objetivo INT NOT NULL,
    periodo VARCHAR(20) NOT NULL,
    data_inicio DATE,
    data_fim DATE,
    habito_id BIGINT NOT NULL,
    FOREIGN KEY (habito_id) REFERENCES habito(id)
);

CREATE TABLE registro_diario (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    data_registro DATE NOT NULL,
    feito TINYINT NOT NULL DEFAULT 0,
    observacao TEXT,
    habito_id BIGINT NOT NULL,
    FOREIGN KEY (habito_id) REFERENCES habito(id)
);