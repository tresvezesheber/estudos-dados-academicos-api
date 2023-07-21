CREATE TABLE aluno (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(120) NOT NULL,
    matricula VARCHAR(9) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    email VARCHAR(40) NOT NULL,
    curso VARCHAR(50) NOT NULL,
    ativo TINYINT(1) NOT NULL,
    endereco_id INT NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE endereco (
    id INT NOT NULL AUTO_INCREMENT,
    rua VARCHAR(150) NOT NULL,
    numero VARCHAR(5) NOT NULL,
    complemento VARCHAR(10),
    bairro VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    cep VARCHAR(8) NOT NULL,
    estado VARCHAR(25) NOT NULL,

    PRIMARY KEY (id)
);

ALTER TABLE aluno ADD CONSTRAINT
    FOREIGN KEY fk_endereco_id (endereco_id) REFERENCES endereco (id);