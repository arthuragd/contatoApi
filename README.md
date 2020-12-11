# ContatoApi

## Configurações:
* Configurar o banco em application.yml localizado em src/main/resources
* Conexao com MySql: 
    * Criar banco agenda; ``CREATE DATABASE `agenda``
    * Criar tabela contato: 
    `` CREATE TABLE `contatos` (
        `id` bigint(20) NOT NULL AUTO_INCREMENT,
        `email` varchar(255) NOT NULL,
        `nome` varchar(255) NOT NULL,
        PRIMARY KEY (`id`)
      ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;``
