# usermgmt
Projeto para apresentação de conceitos REST utilizando Spring

### Tecnologias
* Java 8
* H2 Database
* Spring Boot

### Banco de dados
1. Banco de dados: estamos utilizando o H2 que cria um arquivo no diretório do projeto para manter as informações inseridas persistidas mesmo se a aplicação é reiniciada.
2. Client do H2: http://localhost:8080/h2.
3. No campo: `JDBC URL`, informe o caminho do arquivo sem a extensão do mesmo. Ex nome do arquivo `db.mv.db`, coloque apenas `db` no final da URL. Assim: `jdbc:h2:file:${full_path}/usermgmt/db`

### Como funciona

O projeto está dividido em etapas separadas por *branches* para facilitar o acompanhamento.

* step-1: Criação de controller + endpoint ping
* step-2: MVP completo. Fim de curso!  :D
* step-3: Refactoring: Business Layer e Versionamento de endpoints
* step-4: Desconforto de expor entidades de BD via API? Lets add some domain models!!
* step-5: Business Layer não serve pra nada! Vamos fazer alguma coisa com ela? Validações!!
* step-6: Exceptions customizadas e tratamento de erros
* step-7: Swagger, um inicio para documentar API’s

### Batendo nos endpoints:

#### Linux CURL to the rescue!

##### Users V1

  * POST /v1/users
  ```
  curl -v -X POST http://localhost:8080/v1/users -d '{"email":"kashka@gmail.com","name":"Kashka", "password":"123"}' -H 'Content-Type: application/json'
  ```
  
  * PUT /v1/users
  ```
  curl -v -X PUT http://localhost:8080/v1/users -d '{"email":"kashka@gmail.com","name":"Kashka", "password":"123"}' -H 'Content-Type: application/json'
  ```
  
  * GET /v1/users
  ```
  curl -v -X GET http://localhost:8080/v1/users
  ```
  
  * GET /v1/users/{id}
  ```
  curl -v -X GET http://localhost:8080/v1/users/1
  ```
  
  * DELETE /v1/users/{id}
  ```
  curl -v -X DELETE http://localhost:8080/v1/users/1
  ```

##### Users V2

  * POST /v2/users
  ```
  curl -v -X POST http://localhost:8080/v2/users -d '{"email":"kashka@gmail.com","name":"Kashka", "password":"123", "passwordConfirmation" : "123"}' -H 'Content-Type: application/json'
  ```
  
  * PUT /v2/users
  ```
  curl -v -X PUT http://localhost:8080/v2/users -d '{"email":"kashka@gmail.com","name":"Kashka", "password":"123", "passwordConfirmation" : "123"}' -H 'Content-Type: application/json'
  ```
  
  * GET /v2/users
  ```
  curl -v -X GET http://localhost:8080/v2/users
  ```
  
  * GET /v2/users/{id}
  ```
  curl -v -X GET http://localhost:8080/v2/users/1
  ```
  
  * DELETE /v2/users/{id}
  ```
  curl -v -X DELETE http://localhost:8080/v2/users/1
  ```
  
##### Swagger URL: http://localhost:8080/swagger-ui.html

