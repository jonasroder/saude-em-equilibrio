-- Criação da tabela de usuários
CREATE TABLE usuario
(
    id_usuario  INT AUTO_INCREMENT PRIMARY KEY,
    id_pessoa   INT,
    usuario     VARCHAR(255) NOT NULL,
    senha       VARCHAR(255) NOT NULL,
    id_situacao INT,
    is_active   TINYINT(1) DEFAULT 1
);
