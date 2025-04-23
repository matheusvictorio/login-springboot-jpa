# Projeto de Login com Spring Boot

Este é um projeto simples de autenticação com Spring Boot, utilizando JWT para autenticação de usuários.

## Funcionalidade
- Cadastro e Login de usuários com email e senha.

## Tecnologias

- **Spring Boot**
- **Spring Security**
- **H2 Database (em memória)**

## Como Rodar

1. Clone o repositório:
    ```bash
    git clone https://github.com/seu-usuario/projeto-login.git
    ```

2. Navegue até o diretório do projeto e rode:
    ```bash
    mvn spring-boot:run
    ```

3. Acesse a aplicação em:
    ```
    http://localhost:8080
    ```

## Endpoints

- **POST** `/api/users/register` - Registrar um novo usuário.
- **POST** `/api/users/login` - Realizar login e obter token JWT.
- **GET** `/api/users` - Ver todos os usuários.
- **GET** `/api/users/{email}` - Procurar usuário por email.

## Testando

1. **Registrar usuário**:
    - URL: `POST http://localhost:8080/api/users/register`
    - Corpo:
    ```json
    { "name": "teste", "email": "usuario@exemplo.com", "password": "senha123" }
    ```

2. **Login**:
    - URL: `POST http://localhost:8080/api/users/login`
    - Corpo:
    ```json
    { "email": "usuario@exemplo.com", "password": "senha123" }
    ```
3. **Listar todos os usuários**:
   -URL: `GET http://localhost:8080/api/users`
   - Resposta:
  Todos usuários

4.  **Buscar usuário por email**:
    - URL: `GET http://localhost:8080/api/users/usuario@exemplo.com`
    - Resposta:
    ```json
    { "id": número do id, "email": "usuario@exemplo.com", "password": "senha123" }
    ```

## Licença

Este projeto está licenciado sob a licença MIT.
